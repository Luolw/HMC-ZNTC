package com.hmc.zntc.charger.constants;

import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

/**
 * @ClassName Constants
 * @Description 常量类
 * @Author 张小白
 * @Date 2019/1/10 15:22
 * @Version V1.0
 */
public class Constants {

    /**
     * 字符编码
     */
    public static final Charset CHARSET_UTF8 = CharsetUtil.UTF_8;

    /**
     * 数据包包头大小，头部信息的大小应该是 byte+int = 1+4 = 5
     */
    public static final int HEADER_SIZE = 5;

    /**
     * 数据包类型
     */
    public enum MsgType {

        /**
         * ----------------一体机客户端请求服务端数据包类型--------------------
         */

        /**
         * 心跳包
         */
        HEARTBEAT((byte) 0xAA),

        /**
         * 业务数据包
         */
        BUSINESS((byte) 0xAB),


        /**
         * ----------------服务端推送一体机客户端数据包类型--------------------
         */

        /**
         * 充电
         */
        CHARGING((byte) 0xBA),

        /**
         * 业务数据包
         */
        ADVERTISING((byte) 0xBB);


        private byte type;

        MsgType(byte type) {
            this.type = type;
        }

        public byte getValue() {
            return type;
        }

    }

    /**
     * 模块通用状态
     */
    public enum State {

        /**
         * 正常
         */
        OK(0),

        /**
         * 关机
         */
        OFF(1),

        /**
         * 异常
         */
        FAULT1(2),

        /**
         * 故障
         */
        FAULT2(3);

        private int state;

        State(int state) {
            this.state = state;
        }

        public int getValue() {
            return state;
        }

    }

    /**
     * 一体机状态
     */
    public enum MachineState {

        /**
         * 充电初始化
         */
        INIT(0),

        /**
         * 空闲
         */
        NORMAL(1),

        /**
         * 关机
         */
        OFF(2),

        /**
         * 识别中
         */
        IDENTIFY(3),

        /**
         * 广告机失联
         */
        FAULT1(4),

        /**
         * 充电机失联
         */
        FAULT2(5),

        /**
         * 广告机故障
         */
        FAULT3(6),

        /**
         * 充电器故障
         */
        FAULT4(7),

        /**
         * 需要广告机
         */
        FAULT5(8);

        private int state;

        MachineState(int state) {
            this.state = state;
        }

        public int getValue() {
            return state;
        }

    }

    /**
     * 一体机识别车牌故障类型
     */
    public enum FaultType {

        /**
         * 天气
         */
        Fault1(1),

        /**
         * 自身故障
         */
        Fault2(2),

        /**
         * 号牌遮挡
         */
        Fault3(3),

        /**
         * 无号牌
         */
        Fault4(4);

        private int type;

        FaultType(int type) {
            this.type = type;
        }

        public int getValue() {
            return type;
        }

    }

}
