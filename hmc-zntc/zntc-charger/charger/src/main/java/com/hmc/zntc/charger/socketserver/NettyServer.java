package com.hmc.zntc.charger.socketserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName NettyServer
 * @Description Socket服务端
 * @Author 张小白
 * @Date 2019/1/9 17:03
 * @Version V1.0
 */
//@Component
public class NettyServer implements Runnable {

    private final Logger log = LoggerFactory.getLogger(getClass());

    public void bind(int port) throws InterruptedException {

        // 开启1个线程处理
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        // 开启5个线程处理
        EventLoopGroup workerGroup = new NioEventLoopGroup(5);
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childHandler(new ServerChannelInitializer());

            // 绑定并开始接受传入连接
            ChannelFuture future = b.bind(port).sync();
            log.info("socket服务端启动成功");
            // 等待服务器套接字关闭
            future.channel().closeFuture().sync();

        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    //    @PostConstruct
    public static void main(String[] args) {
        new Thread(new NettyServer()).start();
    }

    @Override
    public void run() {
        try {
            new NettyServer().bind(9999);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
