package com.hmc.zntc.admin.modules.app;

import java.util.Arrays;
import java.util.Map;

import com.hmc.zntc.admin.entity.SmsEntity;
import com.hmc.zntc.admin.service.SmsService;
import com.hmc.zntc.admin.utils.PageUtils;
import com.hmc.zntc.admin.utils.R;
import com.hmc.zntc.admin.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




/**
 *
 *
 * @author chengxinghua
 * @email sunlightcs@gmail.com
 * @date 2018-11-16 13:11:56
 */
@RestController
@RequestMapping("app/sms")
public class SmsController {
    @Autowired
    private SmsService smsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:sms:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:sms:info")
    public R info(@PathVariable("id") Integer id){
        SmsEntity sms = smsService.selectById(id);

        return R.ok().put("sms", sms);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:sms:save")
    public R save(@RequestBody SmsEntity sms){
        smsService.insert(sms);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:sms:update")
    public R update(@RequestBody SmsEntity sms){
        ValidatorUtils.validateEntity(sms);
        smsService.updateAllColumnById(sms);//全部更新

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:sms:delete")
    public R delete(@RequestBody Integer[] ids){
        smsService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
