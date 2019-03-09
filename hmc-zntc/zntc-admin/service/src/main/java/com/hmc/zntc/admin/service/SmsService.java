package com.hmc.zntc.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.hmc.zntc.admin.utils.PageUtils;
import com.hmc.zntc.admin.entity.SmsEntity;

import java.util.Map;

/**
 *
 *
 * @author chengxinghua
 * @email sunlightcs@gmail.com
 * @date 2018-11-06 10:15:20
 */
public interface SmsService extends IService<SmsEntity> {
    /**短信验证码有效时间(分钟)*/
    public final static int VC_VALID_MINUS = 5;


    /**
     * 业务编码
     * register：用户注册，modifyPwd：修改密码，setTradePwd：设置交易密码
     */
    public final static String BC_REGISTER = "register";
    public final static String BC_MODIFY_PWD = "modifyPwd";
    public final static String BC_SET_TRADE_PWD = "setTradePwd";


    /**
     * 发送验证码
     * @return          返回用户ID
     */
    boolean sendMsg(String phone, String busiCode);

    /**
     * 获取验证码
     * @return          返回用户ID
     */
    boolean getSms(String code);


    /**
     * 判断验证码是否有效
     *
     * @param phoneNumber
     * @param busiCode
     * @param verifyCode
     * @return
     */
    boolean isValid(String phoneNumber, String busiCode, String verifyCode);

    PageUtils queryPage(Map<String, Object> params);
}

