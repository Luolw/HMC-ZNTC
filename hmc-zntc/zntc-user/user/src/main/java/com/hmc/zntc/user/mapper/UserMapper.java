package com.hmc.zntc.user.mapper;

import com.hmc.zntc.user.entity.UserEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户
 *
 * @author hmc
 * @email hmc@qq.com
 * @date 2019-01-07 10:49:14
 */
public interface UserMapper extends BaseMapper<UserEntity> {

    /**
     * 登录查询用户
     * @param name
     * @return
     */
    UserEntity queryUserName(String name);

    /**
     *
     * @param userEntity
     * @return
     */
    Integer registerUser(@Param("userEntity") UserEntity userEntity);


    /**
     * 查询手机号码
     * @param
     * @return
     */
    UserEntity queryPhone(String phone);


}
