package com.hmc.zntc.user.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.code.kaptcha.Producer;
import com.hmc.zntc.user.entity.UserEntity;
import com.hmc.zntc.user.mapper.UserMapper;
import com.hmc.zntc.user.service.UserService;
import com.hmc.zntc.user.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

        @Override
        public PageUtils queryPage(Map<String, Object> params) {
    //        Page<UserEntity> page = this.selectPage(
    //                new Query<UserEntity>(params).getPage(),
    //                new EntityWrapper<UserEntity>()
    //        );
    //
    //        return new PageUtils(page);
            return null;
        }

        /**
         * 查询用户
         *
         * @param name
         * @return
         */
        @Override
        public UserEntity queryUserName(String name) {
            return baseMapper.queryUserName(name);
        }

        /**
         * 注册插入用户信息
         * @param userEntity
         * @return
         */
        @Override
        public Integer registerUser(UserEntity userEntity) {
            return baseMapper.registerUser(userEntity);
        }

        /**
         * 查询手机号
         *
         * @param phone
         * @return
         */
        @Override
        public UserEntity queryPhone(String phone) {
            return baseMapper.queryPhone(phone);
        }

}
