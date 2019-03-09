package github;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName ServerHandler
 * @Description TODO
 * @Author 张小白
 * @Date 2019/1/9 17:55
 * @Version V1.0
 */
public class ServerHandler extends SimpleChannelInboundHandler<Message> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {

        System.out.println("server read msg: " + msg.getBody());

        Message resp = new Message((byte) 0xAF, "server message");
        ctx.writeAndFlush(resp);
    }
}
