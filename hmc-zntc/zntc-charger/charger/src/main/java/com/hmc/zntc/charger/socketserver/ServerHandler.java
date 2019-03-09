package com.hmc.zntc.charger.socketserver;

import com.hmc.zntc.charger.constants.Constants;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @ClassName ServerHandler
 * @Description 自定义数据处理器
 * @Author 张小白
 * @Date 2019/1/9 17:55
 * @Version V1.0
 */
public class ServerHandler extends SimpleChannelInboundHandler<Message> {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {

        String testMeg = "测试消息";
        String body = msg.getBody();
        if (testMeg.equals(body)) {
            log.info("---接收到来自客户端的测试消息: " + body);
        } else {
            log.info("---接受来自一体机的测试消息: " + body);
        }

        Message resp = new Message(Constants.MsgType.HEARTBEAT, "{code:0}");
        ctx.writeAndFlush(resp);
    }
}
