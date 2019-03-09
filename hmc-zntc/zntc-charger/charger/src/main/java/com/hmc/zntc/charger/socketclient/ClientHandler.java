package com.hmc.zntc.charger.socketclient;

import com.hmc.zntc.charger.socketserver.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @ClassName ClientHandler
 * @Description 自定义数据处理器
 * @Author 张小白
 * @Date 2019/1/9 17:59
 * @Version V1.0
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        Message message = (Message) msg;
        System.out.println("client read msg: " + message.getBody());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        System.out.println("客户端异常" + cause.getMessage());
        ctx.close();
    }
}
