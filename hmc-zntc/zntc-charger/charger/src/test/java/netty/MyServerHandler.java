package netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.SocketProtocol;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @ClassName MyServerHandler
 * @Description TODO
 * @Author 张小白
 * @Date 2019/1/8 16:17
 * @Version V1.0
 */
public class MyServerHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
//        //打印出客户端地址
//        System.out.println(ctx.channel().remoteAddress() + ", " + msg);
//        ctx.channel().writeAndFlush("form server: " + UUID.randomUUID());

        SocketProtocol socketProtocol = (SocketProtocol) msg;

        // 打印出客户端地址
        System.out.println("服务端接受来自客户端的消息：" + socketProtocol.toString());

        // 要发送的消息
        String message = "我是服务端户端" + LocalDateTime.now();
        // 将消息转换为字节数组
        byte[] msgByte = message.getBytes();
        // 发送消息的长度
        int contentLength = msgByte.length;
        // 组装协议对象
        SocketProtocol m = new SocketProtocol(contentLength, msgByte);

        ctx.channel().writeAndFlush(m);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
