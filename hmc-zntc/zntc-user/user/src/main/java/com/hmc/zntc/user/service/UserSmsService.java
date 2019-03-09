package com.hmc.zntc.user.service;

import com.baomidou.mybatisplus.service.IService;
import com.hmc.zntc.user.utils.PageUtils;
import com.hmc.zntc.user.entity.UserSmsEntity;

import java.util.Map;

/**
 * 短信
 *
 * @author hmc
 * @email hmc@qq.com
 * @date 2019-01-07 11:20:54
 */
public interface UserSmsService extends IService<UserSmsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 发送验证码
     * @return          返回用户ID
     */
    boolean sendMsg(String phone, String busiCode);
}

