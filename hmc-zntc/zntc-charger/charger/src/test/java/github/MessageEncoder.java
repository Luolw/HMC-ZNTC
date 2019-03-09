package github;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.Charset;

/**
 * @ClassName MessageEncoder
 * @Description TODO
 * @Author 张小白
 * @Date 2019/1/9 17:03
 * @Version V1.0
 */
public class MessageEncoder extends MessageToByteEncoder<Message> {
    private final Charset charset = Charset.forName("utf-8");

    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {

        out.writeByte(msg.getType());
        byte[] data = msg.getBody().getBytes(charset);
        out.writeInt(data.length);
        out.writeBytes(data);
    }
}
