package github;

/**
 * @ClassName NettyClient
 * @Description TODO
 * @Author 张小白
 * @Date 2019/1/9 17:04
 * @Version V1.0
 */

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.concurrent.TimeUnit;

/**
 * @author Ricky Fung
 */
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
            if (future.channel().isActive()) {
                for (int i = 0; i < 1000; i++) {
                    sendMsg(future, i);
                }
            }

            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    private void sendMsg(ChannelFuture future, int i) {
        String body = "12345Hello world12345 " + i;
        Message msg = new Message((byte) 0XAF, body);
        future.channel().writeAndFlush(msg);
    }

    public static void main(String[] args) throws Exception {
        new NettyClient().connect("localhost", 9999);
    }
}
