package com.hmc.zntc.charger.socketserver;

import com.hmc.zntc.charger.constants.Constants;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @ClassName ServerChannelInitializer
 * @Description 服务端初始化类，添加编解码器，添加自定以数据处理器
 * @Author 张小白
 * @Date 2019/1/9 17:54
 * @Version V1.0
 */
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    public void initChannel(SocketChannel ch) throws Exception {

        ChannelPipeline p = ch.pipeline();
        // 添加解码器
        p.addLast(new MessageDecoder(1024, 5, 4));
        // 添加编码器
        p.addLast(new MessageEncoder());
        // 编/解码字符编码格式
        p.addLast(new StringDecoder(Constants.CHARSET_UTF8));
        p.addLast(new StringEncoder(Constants.CHARSET_UTF8));
        // 自定义业务处理器
        p.addLast(new ServerHandler());
    }

}
