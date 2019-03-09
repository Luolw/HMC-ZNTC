package com.hmc.zntc.user.controller;

import com.hmc.zntc.user.form.UserLoFrom;
import com.hmc.zntc.user.form.UserRegForm;
import com.hmc.zntc.user.service.RedisService;
import com.hmc.zntc.user.utils.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@RequestMapping("/usertest")
public class Test {


    @Autowired
    private RedisService redisService;

    @PostMapping(value = "/register")
    @ResponseBody
    @ApiOperation("测试")
    @ApiImplicitParam(name = "用户注册表单", value = "from", dataTypeClass = UserRegForm.class)
    public R testlog(@Valid @RequestBody UserLoFrom from, String token, BindingResult result) {
        redisService.get(token);
        return R.ok();
    }


}
