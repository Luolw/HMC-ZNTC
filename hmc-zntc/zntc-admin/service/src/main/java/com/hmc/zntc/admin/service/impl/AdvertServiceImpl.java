package com.hmc.zntc.admin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hmc.zntc.admin.utils.PageUtils;
import com.hmc.zntc.admin.utils.Query;

import com.hmc.zntc.admin.mapper.AdvertMapper;
import com.hmc.zntc.admin.entity.AdvertEntity;
import com.hmc.zntc.admin.service.AdvertService;


@Service("advertService")
public class AdvertServiceImpl extends ServiceImpl<AdvertMapper, AdvertEntity> implements AdvertService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AdvertEntity> page = this.selectPage(
                new Query<AdvertEntity>(params).getPage(),
                new EntityWrapper<AdvertEntity>()
        );

        return new PageUtils(page);
    }

}
