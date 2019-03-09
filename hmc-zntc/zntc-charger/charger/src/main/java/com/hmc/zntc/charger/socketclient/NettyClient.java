package com.hmc.zntc.charger.socketclient;

/**
 * @ClassName NettyClient
 * @Description Socket服务端
 * @Author 张小白
 * @Date 2019/1/9 17:04
 * @Version V1.0
 */

import com.hmc.zntc.charger.constants.Constants;
import com.hmc.zntc.charger.socketserver.Message;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author Ricky Fung
 */
//@Component
public class NettyClient {

    public void connect(String host, int port) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ClientChannelInitializer());

            ChannelFuture future = b.connect(host, port).sync();

            future.awaitUninterruptibly(2000, TimeUnit.MILLISECONDS);

            // 向服务器发送1000条测试数据
//            if (future.channel().isActive()) {
//                for (int i = 0; i < 1000; i++) {
//                    sendMsg(future, i);
//                }
//            }

            Message msg = new Message(Constants.MsgType.HEARTBEAT, "测试消息");
            Message msg1 = new Message(Constants.MsgType.HEARTBEAT, "{name:'a'}");
            future.channel().writeAndFlush(msg);
            future.channel().writeAndFlush(msg1);

            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    private void sendMsg(ChannelFuture future, int i) {
        String body = "12345Hello world12345 " + i;
        Message msg = new Message(Constants.MsgType.HEARTBEAT, body);
        future.channel().writeAndFlush(msg);
    }

//    @PostConstruct
    public static void main(String[] args) throws InterruptedException {
        new NettyClient().connect("localhost", 9999);
    }
}
