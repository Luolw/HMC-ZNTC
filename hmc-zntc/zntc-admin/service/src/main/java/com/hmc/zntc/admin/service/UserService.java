package com.hmc.zntc.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.hmc.zntc.admin.utils.PageUtils;
import com.hmc.zntc.admin.entity.UserEntity;

import java.util.Map;

/**
 * 模块：用户 
作用：用户表，存储用户信息
 *
 * @author hmc
 * @email hmc@qq.com
 * @date 2019-01-03 11:17:38
 */
public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

