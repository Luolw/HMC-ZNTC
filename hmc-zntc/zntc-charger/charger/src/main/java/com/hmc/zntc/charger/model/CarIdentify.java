package com.hmc.zntc.charger.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName CarIdentify
 * @Description 车牌识别数据模型
 * @Author 张小白
 * @Date 2019/1/11 11:00
 * @Version V1.0
 * <p>
 * 功能描述：检测用户停车动作并识别车牌，检测用户取车动作并通知服务器推送账单
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarIdentify implements Serializable {

    private static final long serialVersionUID = -5907466525562095683L;

    /**
     * 一体机编码
     */
    private String machineCode;

    /**
     * 识别的号牌字符串
     */
    private String carCard;

    /**
     * 停靠完成时间(完全停入车位时)格式为：yyyy-MM-dd HH:mm:ss
     */
    private String parkingTime;

    /**
     * 离开时间(车身完全离开车位，精确至秒)格式为：yyyy-MM-dd HH:mm:ss
     */
    private String parkingLeaveTime;

    /**
     * 车牌特写图片地址
     */
    private String carCardImg;

    /**
     * 停靠完成后远景照片地址
     */
    private String carCardFarImg;

    /**
     * 识别故障类型(天气/自身故障/号牌遮挡/无号牌)
     */
    private int identifyFaultType;

    /**
     * 车辆品牌
     */
    private String carBrand;

    /**
     * 车身颜色
     */
    private String carColor;

    /**
     * 车辆型号
     */
    private String carType;

    /**
     * 车牌颜色
     */
    private String carCardColor;

}
