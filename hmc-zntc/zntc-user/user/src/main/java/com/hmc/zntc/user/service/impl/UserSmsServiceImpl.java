package com.hmc.zntc.user.service.impl;

import org.springframework.stereotype.Service;

import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hmc.zntc.user.utils.PageUtils;

import com.hmc.zntc.user.mapper.UserSmsMapper;
import com.hmc.zntc.user.entity.UserSmsEntity;
import com.hmc.zntc.user.service.UserSmsService;


@Service("userSmsService")
public class UserSmsServiceImpl extends ServiceImpl<UserSmsMapper, UserSmsEntity> implements UserSmsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
//        Page<UserSmsEntity> page = this.selectPage(
//                new Query<UserSmsEntity>(params).getPage(),
//                new EntityWrapper<UserSmsEntity>()
//        );
//
//        return new PageUtils(page);
        return null;
    }

    @Override
    public boolean sendMsg(String phone, String busiCode) {

        // TODO 发送短信，添加到缓存中，将发送记录插入到表中

//        String code = ChuangLanSmsUtil.generateVerifyCode();
//        boolean send = ChuangLanSmsUtil.send(phone, SmsTemplate.VERIFY_CODE_MSG, code);
//        if (send) {
//            SmsEntity sms = new SmsEntity();
////            register(用户注册)，modifyPwd(修改密码)，setTradePwd(设置交易密码)
//            sms.setBusicCode(BC_REGISTER);
//            sms.setPhoneNumber(phone);
//            Date date =new Date();
//            sms.setSendTime(date);
//            sms.setVerifyCode(code);
////            0、未验证；1、已验证；2、已过期
//            sms.setState(0);
////            sms.setSendTime(date);
//            sms.setValidMinus(date);
//
//            /**短信验证码有效时间(分钟)*/
////            int VC_VALID_MINUS = 5;
//
//            Date expireTime = DateUtils.doSecondOperation(date, VC_VALID_MINUS * 60);
//            sms.setExpireTime(expireTime);
//            this.insert(sms);
//        }
        return true;
    }

}
