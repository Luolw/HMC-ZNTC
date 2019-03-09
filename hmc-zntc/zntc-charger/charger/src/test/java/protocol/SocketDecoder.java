package protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @ClassName SocketDecoder
 * @Description Socket服务端解码器
 * @Author 张小白
 * @Date 2019/1/9 14:57
 * @Version V1.0
 */
public class SocketDecoder extends ByteToMessageDecoder {


    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf,
                          List<Object> list) throws Exception {
        // 可读长度必须大于基本长度
        if (byteBuf.readableBytes() >= ProtocolConfig.BASE_LENGTH) {
            // 防止socket字节流攻击
            // 防止，客户端传来的数据过大
            // 因为，太大的数据，是不合理的
            if (byteBuf.readableBytes() > 2048) {
                byteBuf.skipBytes(byteBuf.readableBytes());
            }

            // 记录包头开始的index
            int beginReader;

            while (true) {
                // 获取包头开始的index
                beginReader = byteBuf.readerIndex();
                // 标记包头开始的index
                byteBuf.markReaderIndex();
                // 读到了协议的开始标志，结束while循环
                if (byteBuf.readInt() == ProtocolConfig.HEAD_DATA) {
                    break;
                }

                // 未读到包头，略过一个字节
                // 每次略过，一个字节，去读取，包头信息的开始标记
                byteBuf.resetReaderIndex();
                byteBuf.readByte();

                // 当略过，一个字节之后，
                // 数据包的长度，又变得不满足
                // 此时，应该结束。等待后面的数据到达
                if (byteBuf.readableBytes() < ProtocolConfig.BASE_LENGTH) {
                    return;
                }
            }

            // 消息的长度

            int length = byteBuf.readInt();
            // 判断请求数据包数据是否到齐
            if (byteBuf.readableBytes() < length) {
                // 还原读指针
                byteBuf.readerIndex(beginReader);
                return;
            }

            // 读取data数据
            byte[] data = new byte[length];
            byteBuf.readBytes(data);

            SocketProtocol protocol = new SocketProtocol(data.length, data);
            list.add(protocol);
        }
    }
}
