package protocol;

/**
 * @ClassName Constant
 * @Description 协议有关配置类
 * @Author 张小白
 * @Date 2019/1/9 15:01
 * @Version V1.0
 */
public class ProtocolConfig {
    /**
     * 包头数据
     */
    public static final int HEAD_DATA = 0x76;
    /**
     * 包头数据长度+数据长度
     * <pre>
     * 协议开始的标准head_data，int类型，占据4个字节.
     * 表示数据的长度contentLength，int类型，占据4个字节.
     * </pre>
     */
    public static final int BASE_LENGTH = 4 + 4;

}
