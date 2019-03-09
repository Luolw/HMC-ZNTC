package protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @ClassName SocketEncoder
 * @Description Socket编码器
 * @Author 张小白
 * @Date 2019/1/9 14:55
 * @Version V1.0
 */
public class SocketEncoder extends MessageToByteEncoder<SocketProtocol> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, SocketProtocol socketProtocol,
                          ByteBuf byteBuf) throws Exception {
        // 进行编码
        // 1.写入消息的开头的信息标志(int类型)
        byteBuf.writeInt(socketProtocol.getHead_data());
        // 2.写入消息的长度(int 类型)
        byteBuf.writeInt(socketProtocol.getContentLength());
        // 3.写入消息的内容(byte[]类型)
        byteBuf.writeBytes(socketProtocol.getContent());
    }
}
