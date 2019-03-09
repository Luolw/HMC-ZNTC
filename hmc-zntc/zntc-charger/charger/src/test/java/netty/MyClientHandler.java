package netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.SocketProtocol;

import java.time.LocalDateTime;

/**
 * @ClassName MyClientHandler
 * @Description TODO
 * @Author 张小白
 * @Date 2019/1/8 16:18
 * @Version V1.0
 */
public class MyClientHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
//        //服务端的远程地址
//        System.out.println(ctx.channel().remoteAddress());
//        System.out.println("client output: " + msg);
//        ctx.writeAndFlush("from client: " + LocalDateTime.now());
//        //完成通信后关闭连接
////        ctx.close();

        System.out.println(msg.toString());
//         要发送的消息
        String message = "我是客户端" + LocalDateTime.now();
        // 将消息转换为字节数组
        byte[] msgByte = message.getBytes();
        // 发送消息的长度
        int contentLength = msgByte.length;
        // 组装协议对象
        SocketProtocol socketProtocol = new SocketProtocol(contentLength, msgByte);
        // 向服务端发送消息
        ctx.writeAndFlush(socketProtocol);
    }

    /**
     * 当服务器端与客户端进行建立连接的时候会触发，如果没有触发读写操作，则客户端和客户端之间不会进行数据通信，也就是channelRead0不会执行，
     * 当通道连接的时候，触发channelActive方法向服务端发送数据触发服务器端的handler的channelRead0回调，然后
     * 服务端向客户端发送数据触发客户端的channelRead0，依次触发。
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("来自与客户端!");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

