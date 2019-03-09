package com.hmc.zntc.user.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @ClassName UserRegForm
 * @Description 前端注册提交数据时封装成此格式
 * @Author 张小白
 * @Date 2019/1/7 16:50
 * @Version V1.0
 */
@ApiModel(value = "用户注册表单")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegForm {

    @ApiModelProperty(value = "手机号")
    @NotBlank(message = "手机号不能为空")
    @Size(min=11,max=11,message="手机号码长度不正确")
    @Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$",message = "手机号格式错误")
    private String phone;

    @ApiModelProperty(value = "密码")
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 16, message = "密码长度为6-16位")
    private String password;

    @ApiModelProperty(value = "短信验证码")
    @NotBlank(message = "短信验证码不能为空")
    private String verifyCode;
}
