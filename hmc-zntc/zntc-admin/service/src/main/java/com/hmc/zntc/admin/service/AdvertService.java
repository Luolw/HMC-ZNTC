package com.hmc.zntc.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.hmc.zntc.admin.utils.PageUtils;
import com.hmc.zntc.admin.entity.AdvertEntity;

import java.util.Map;

/**
 * 广告设置
 *
 * @author hmc
 * @email hmc@qq.com
 * @date 2019-01-07 14:41:12
 */
public interface AdvertService extends IService<AdvertEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

