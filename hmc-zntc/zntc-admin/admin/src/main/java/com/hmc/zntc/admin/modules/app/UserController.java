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

import com.hmc.zntc.admin.entity.UserEntity;
import com.hmc.zntc.admin.service.UserService;
import com.hmc.zntc.admin.utils.PageUtils;
import com.hmc.zntc.admin.utils.R;



/**
 * app用户表
 *
 * @author hmc
 * @email hmc@qq.com
 * @date 2019-01-03 11:44:25
 */
@RestController
@RequestMapping("app/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:user:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:user:info")
    public R info(@PathVariable("id") String id){
        UserEntity user = userService.selectById(id);

        return R.ok().put("user", user);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:user:save")
    public R save(@RequestBody UserEntity user){
        userService.insert(user);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:user:update")
    public R update(@RequestBody UserEntity user){
        ValidatorUtils.validateEntity(user);
        userService.updateAllColumnById(user);//全部更新

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:user:delete")
    public R delete(@RequestBody String[] ids){
        userService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
