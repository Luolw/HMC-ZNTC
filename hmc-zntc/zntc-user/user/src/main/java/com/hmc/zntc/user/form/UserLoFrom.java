package com.hmc.zntc.user.form;


import com.hmc.zntc.user.entity.UserEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;


@ApiModel(value = "用户登录")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoFrom implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "用户名")
    @NotEmpty(message="用户名不能为空")
    private String name;


    @ApiModelProperty(value = "密码")
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 16, message = "密码长度为6-16位")
    private String pwd;

}
