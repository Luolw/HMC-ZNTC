package com.hmc.zntc.charger.model;

import com.alibaba.fastjson.JSON;
import com.hmc.zntc.charger.constants.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Heartbeat
 * @Description 心跳包数据模型
 * @Author 张小白
 * @Date 2019/1/10 15:36
 * @Version V1.0
 * <p>
 * 功能描述：一体机发送心跳包给服务器，监控一体机状态
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Heartbeat implements Serializable {

    private static final long serialVersionUID = -7348943231831964722L;

    /**
     * 一体机编码
     */
    private String machineCode;

    /**
     * 当前一体机温度
     */
    private int machineTemperature;

    /**
     * 摄像头状态
     */
    private int cameraState = Constants.State.OK.getValue();

    /**
     * 语音状态
     */
    private int voiceState = Constants.State.OK.getValue();

    /**
     * 指示灯状态
     */
    private int indicatorState = Constants.State.OK.getValue();

    /**
     * LED状态
     */
    private int ledState = Constants.State.OK.getValue();

    /**
     * 充电模块状态
     */
    private int chargingModuleState = Constants.State.OK.getValue();

    /**
     * 电量统计模块状态
     */
    private int electricityModuleState = Constants.State.OK.getValue();

    /**
     * 屏幕状态
     */
    private int screenState = Constants.State.OK.getValue();

    /**
     * 温控模块状态
     */
    private int temperatureModuleState = Constants.State.OK.getValue();

    /**
     * 超声波模块状态
     */
    private int ultrasonicModuleState = Constants.State.OK.getValue();

    /**
     * 发送心跳包时间格式为：yyyy-MM-dd HH:mm:ss
     */
    private String heartbeatTime;

    @Override
    public String toString() {
        return "Heartbeat{" +
                "machineCode='" + machineCode + '\'' +
                ", machineTemperature='" + machineTemperature + '\'' +
                ", cameraState='" + cameraState + '\'' +
                ", voiceState='" + voiceState + '\'' +
                ", indicatorState='" + indicatorState + '\'' +
                ", ledState='" + ledState + '\'' +
                ", chargingModuleState='" + chargingModuleState + '\'' +
                ", electricityModuleState='" + electricityModuleState + '\'' +
                ", screenState='" + screenState + '\'' +
                ", temperatureModuleState='" + temperatureModuleState + '\'' +
                ", ultrasonicModuleState='" + ultrasonicModuleState + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Heartbeat heartbeat = new Heartbeat();
        heartbeat.setCameraState(1234);

        System.out.println(JSON.toJSON(heartbeat).toString());

        String jsonStr = "{\"cameraState\":\"1234\"}";
        heartbeat = JSON.parseObject(jsonStr, Heartbeat.class);
        System.out.println(heartbeat);
    }

}
