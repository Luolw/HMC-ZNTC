package netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import protocol.SocketDecoder;
import protocol.SocketEncoder;

/**
 * @ClassName MyClientInitializer
 * @Description TODO
 * @Author 张小白
 * @Date 2019/1/8 16:18
 * @Version V1.0
 */
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

//        pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
//        pipeline.addLast(new LengthFieldPrepender(4));

        // 添加自定义编码器
        pipeline.addLast(new SocketEncoder());
        // 添加自定义解码器
        pipeline.addLast(new SocketDecoder());
//        pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
//        pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
        pipeline.addLast(new MyClientHandler());
    }
}

