package com.hmc.zntc.user.service;

import com.baomidou.mybatisplus.service.IService;
import com.hmc.zntc.user.utils.PageUtils;
import com.hmc.zntc.user.entity.UserEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 用户
 *
 * @author hmc
 * @email hmc@qq.com
 * @date 2019-01-07 10:49:14
 */
public interface UserService extends IService<UserEntity> {

    /**
     * 分页
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询用户
     *
     * @param name
     * @return
     */
    UserEntity queryUserName(String name);

    /**
     * 注册插入用户信息
     * @param userEntity
     * @return
     */
    Integer registerUser(UserEntity userEntity);

    /**
     * 查询手机号
     *
     * @param phone
     * @return
     */
    UserEntity queryPhone(String phone);

}
