package com.hmc.zntc.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hmc.zntc.admin.utils.DateUtils;
import com.hmc.zntc.admin.utils.PageUtils;
import com.hmc.zntc.admin.utils.Query;
import com.hmc.zntc.admin.utils.chuanglansms.ChuangLanSmsUtil;
import com.hmc.zntc.admin.utils.chuanglansms.SmsTemplate;
import com.hmc.zntc.admin.entity.SmsEntity;
import com.hmc.zntc.admin.mapper.SmsMapper;
import com.hmc.zntc.admin.service.SmsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service("smService")
public class SmsServiceImpl extends ServiceImpl<SmsMapper, SmsEntity> implements SmsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        String phoneNumber = (String) params.get("phoneNumber");
        EntityWrapper<SmsEntity> entityWrapper = new EntityWrapper<>();
        entityWrapper.like(StringUtils.isNotBlank(phoneNumber),"phone_number", phoneNumber);
        Page<SmsEntity> page = this.selectPage(
                new Query<SmsEntity>(params).getPage(),
                entityWrapper
        );

        return new PageUtils(page);
    }

//    @Autowired
//    SmsMapper smsMapper;

    @Override
    public boolean sendMsg(String phone, String busiCode) {

        String code = ChuangLanSmsUtil.generateVerifyCode();
        boolean send = ChuangLanSmsUtil.send(phone, SmsTemplate.VERIFY_CODE_MSG, code);
        if (send) {
            SmsEntity sms = new SmsEntity();
//            register(用户注册)，modifyPwd(修改密码)，setTradePwd(设置交易密码)
            sms.setBusicCode(BC_REGISTER);
            sms.setPhoneNumber(phone);
            Date date =new Date();
            sms.setSendTime(date);
            sms.setVerifyCode(code);
//            0、未验证；1、已验证；2、已过期
            sms.setState(0);
//            sms.setSendTime(date);
            sms.setValidMinus(date);

            /**短信验证码有效时间(分钟)*/
//            int VC_VALID_MINUS = 5;

            Date expireTime = DateUtils.doSecondOperation(date, VC_VALID_MINUS * 60);
            sms.setExpireTime(expireTime);
            this.insert(sms);
        }
        return send;
    }

    @Override
    public boolean getSms(String code) {
//        SmsEntity smsExample = new SmsExample();
//        smsExample.createCriteria().andVerifyCodeEqualTo(code);
        SmsEntity smsEntity =  this.selectOne(new EntityWrapper<SmsEntity>().eq("verify_code",code));

        if (smsEntity != null  || smsEntity.getState()!=0) {
//            Sms sms = exampleList.get(0);
            smsEntity.setState(1);
            insert(smsEntity);
            return true;
        } else {
            return false;
        }
    }


    /**
     * 判断验证码是否有效
     *
     * @param phoneNumber
     * @param busiCode
     * @param verifyCode
     * @return
     */
    @Override
    public boolean isValid(String phoneNumber, String busiCode, String verifyCode) {
        EntityWrapper<SmsEntity> wrapper = new EntityWrapper<>();
        wrapper.eq("verify_code",verifyCode);
        wrapper.eq("busic_code",busiCode);
        wrapper.eq("phone_number",phoneNumber);


        SmsEntity smsEntity =  selectOne(wrapper);

        //验证通过，设置验证码状态为已验证
        if (smsEntity!=null) {
//            Sms smsLog = exampleList.get(0);
            smsEntity.setState(1);
//            smsLog.set(new Date());
            updateById(smsEntity);
            return true;
        } else {
            return false;
        }
    }

}
