package github;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @ClassName ClientChannelInitializer
 * @Description TODO
 * @Author 张小白
 * @Date 2019/1/9 17:58
 * @Version V1.0
 */
public class ClientChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ChannelPipeline p = ch.pipeline();
        p.addLast(new MessageDecoder(1024, 5, 4));
        p.addLast(new MessageEncoder());

        p.addLast(new ClientHandler());
    }
}
