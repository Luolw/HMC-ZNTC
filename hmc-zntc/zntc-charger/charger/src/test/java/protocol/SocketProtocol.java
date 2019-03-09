package protocol;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

/**
 * @ClassName SocketProtocol
 * @Description Socket服务端与客户端通讯数据协议
 * @Author 张小白
 * @Date 2019/1/9 14:43
 * @Version V1.0
 *
 *
 * <pre>
 * 数据包格式
 * -----------------------
 * | 包头 | 数据长度 | 数据 |
 * -----------------------
 * 1.协议开始标志head_data，为int类型的数据，16进制表示为0X76
 * 2.传输数据的长度contentLength，int类型
 * 3.要传输的数据(字节)
 * </pre>
 */
@Data
@NoArgsConstructor
public class SocketProtocol {

    /**
     * 消息的开头的信息标志
     */
    private int head_data = 0X76;

    /**
     * 消息的长度
     */
    private int contentLength;

    /**
     * 消息的内容
     */
    private byte[] content;

    public SocketProtocol(int contentLength, byte[] content) {
        this.contentLength = contentLength;
        this.content = content;
    }

    @Override
    public String toString() {
        return "SocketProtocol{" +
                "head_data=" + head_data +
                ", contentLength=" + contentLength +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
