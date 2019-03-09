package com.hmc.zntc.admin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hmc.zntc.admin.utils.PageUtils;
import com.hmc.zntc.admin.utils.Query;

import com.hmc.zntc.admin.mapper.UserMapper;
import com.hmc.zntc.admin.entity.UserEntity;
import com.hmc.zntc.admin.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserEntity> page = this.selectPage(
                new Query<UserEntity>(params).getPage(),
                new EntityWrapper<UserEntity>()
        );

        return new PageUtils(page);
    }

}
