package com.hmc.zntc.admin.modules.app;

import java.util.Arrays;
import java.util.Map;

import com.hmc.zntc.admin.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hmc.zntc.admin.entity.AdvertEntity;
import com.hmc.zntc.admin.service.AdvertService;
import com.hmc.zntc.admin.utils.PageUtils;
import com.hmc.zntc.admin.utils.R;



/**
 * 广告设置
 *
 * @author hmc
 * @email hmc@qq.com
 * @date 2019-01-07 14:41:12
 */
@RestController
@RequestMapping("app/advert")
public class AdvertController {
    @Autowired
    private AdvertService advertService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:advert:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = advertService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:advert:info")
    public R info(@PathVariable("id") Integer id){
        AdvertEntity advert = advertService.selectById(id);

        return R.ok().put("advert", advert);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:advert:save")
    public R save(@RequestBody AdvertEntity advert){
        advertService.insert(advert);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:advert:update")
    public R update(@RequestBody AdvertEntity advert){
        ValidatorUtils.validateEntity(advert);
        advertService.updateAllColumnById(advert);//全部更新

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:advert:delete")
    public R delete(@RequestBody Integer[] ids){
        advertService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
