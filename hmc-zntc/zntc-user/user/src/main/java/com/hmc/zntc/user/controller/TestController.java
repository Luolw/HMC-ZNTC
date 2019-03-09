package com.hmc.zntc.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("swagger测试接口")
public class TestController {

    // 使用get post等具体请求类型注解
    @GetMapping("/test/{id}")
    // 此接口的描述信息，和笔记信息
    @ApiOperation(value = "查询首页数据", notes = "查询数据库中信息", response = LoginForm.class)
    // 参数数组
    @ApiImplicitParams({
            // name: 参数字段名称;
            // value: 参数的描述;
            // paramType: 参数传递的类型(path为请求路径中带的参数，query是请求路径后拼接的参数，body是对象);
            // dataType: 参数类型，int/string等
            @ApiImplicitParam(name = "id", value = "数据id", paramType = "path", required = true, dataType = "int")
    })
    public LoginForm test(@PathVariable("id") Integer id) {
        return new LoginForm();
    }

}
