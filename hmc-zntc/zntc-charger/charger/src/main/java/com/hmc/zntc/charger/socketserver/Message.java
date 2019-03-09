package com.hmc.zntc.charger.socketserver;

import com.hmc.zntc.charger.constants.Constants;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Message
 * @Description 数据包协议对象
 * @Author 张小白
 * @Date 2019/1/9 17:02
 * @Version V1.0
 */
@Data
public class Message implements Serializable {

    private static final long serialVersionUID = 5255665361019956461L;

    // 消息类型
    private byte type;
    // 数据的长度
    private int length;
    // 内容
    private String body;

    public Message() {

    }

    public Message(Constants.MsgType msgType, byte[] data) {
        this.type = msgType.getValue();
        this.length = data.length;
        this.body = new String(data, Constants.CHARSET_UTF8);
    }

    public Message(Constants.MsgType msgType, String body) {
        this.type = msgType.getValue();
        this.length = body.getBytes(Constants.CHARSET_UTF8).length;
        this.body = body;
    }


}

