package com.hmc.zntc.charger.socketserver;

/**
 * @ClassName MessageDecoder
 * @Description 数据包解码
 * @Author 张小白
 * @Date 2019/1/9 17:03
 * @Version V1.0
 */

import com.hmc.zntc.charger.constants.Constants;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ricky Fung
 */
public class MessageDecoder extends LengthFieldBasedFrameDecoder {

    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * <pre>
     *  maxFrameLength:     单个包最大长度
     *  lengthFieldOffset:  表示数据长度字段开始的偏移量(如头部长度为5，则此处应该填写5)
     *  lengthFieldLength:  数据长度字段(length)的所占的字节数
     * </pre>
     */


    public MessageDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        if (in == null) {
            return null;
        }

        if (in.readableBytes() <= Constants.HEADER_SIZE) {
            return null;
        }

        in.markReaderIndex();

        byte type = in.readByte();
        int dataLength = in.readInt();

        if (in.readableBytes() < dataLength) {
            in.resetReaderIndex();
            return null;
        }

        byte[] data = new byte[dataLength];
        in.readBytes(data);

        String body = new String(data, Constants.CHARSET_UTF8);
        Message msg = new Message(Constants.MsgType.HEARTBEAT, body);
        return msg;

    }
}

