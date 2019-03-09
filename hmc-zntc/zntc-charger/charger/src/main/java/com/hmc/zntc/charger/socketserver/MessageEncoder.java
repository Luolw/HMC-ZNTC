package com.hmc.zntc.charger.socketserver;

import com.hmc.zntc.charger.constants.Constants;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @ClassName MessageEncoder
 * @Description 数据包编码
 * @Author 张小白
 * @Date 2019/1/9 17:03
 * @Version V1.0
 */
public class MessageEncoder extends MessageToByteEncoder<Message> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {

        out.writeByte(msg.getType());
        byte[] data = msg.getBody().getBytes(Constants.CHARSET_UTF8);
        out.writeInt(data.length);
        out.writeBytes(data);
    }
}
