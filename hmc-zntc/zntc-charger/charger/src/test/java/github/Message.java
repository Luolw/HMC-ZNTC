package github;

import lombok.Data;

import java.nio.charset.Charset;

/**
 * @ClassName Message
 * @Description TODO
 * @Author 张小白
 * @Date 2019/1/9 17:02
 * @Version V1.0
 */
@Data
public class Message {

    private final Charset charset = Charset.forName("utf-8");
    // 消息类型 0xAF 心跳包 0xBF 业务信息包
    private byte type;
    // 数据的长度
    private int length;
    // 内容
    private String body;

    public Message() {

    }

    public Message(byte type, byte[] data) {
        this.type = type;
        this.length = data.length;
        this.body = new String(data, charset);
    }

    public Message(byte type, String body) {
        this.type = type;
        this.length = body.getBytes(charset).length;
        this.body = body;
    }


}

