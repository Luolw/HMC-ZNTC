package com.hmc.zntc.user.controller;


import com.google.code.kaptcha.Producer;
import com.hmc.zntc.user.annotation.Login;
import com.hmc.zntc.user.annotation.LoginUser;
import com.hmc.zntc.user.entity.UserEntity;
import com.hmc.zntc.user.form.UserLoFrom;
import com.hmc.zntc.user.form.UserRegForm;
import com.hmc.zntc.user.interceptor.AuthorizationInterceptor;
import com.hmc.zntc.user.service.RedisService;
import com.hmc.zntc.user.service.UserService;
import com.hmc.zntc.user.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

    /**
    * 用户接口
    */
    @RestController
    @RequestMapping("/user")
    @Api(tags = "用户接口")
    public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private Producer producer;//谷歌验证码生成


    @GetMapping(value = "/verifyCode")
    @ResponseBody
    @ApiOperation("生成验证码")
    public void verifyCode(HttpServletResponse response) throws IOException {

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);

        //图片验证码5分钟有效
        redisService.setCode("verification", text, 360);

        //输出图片验证码
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        out.flush();

    }

    /**
     * 注册用户
     *
     * @param from   表单对象
     * @param result 字段校验参数(此参数名称固定为"result")
     */
    @PostMapping(value = "/register")
    @ResponseBody
    @ApiOperation("注册用户")
    @ApiImplicitParam(name = "用户注册表单", value = "from", dataTypeClass = UserRegForm.class)
    public R registUser(@Valid @RequestBody UserRegForm from,
                        BindingResult result) {
        UserEntity register = userService.queryPhone(from.getPhone());

        String code = redisService.get("verification");

        if (register != null) {
            return R.error("手机号已注册,请登入");
        }
        if (!from.getVerifyCode().equals(code)) {
            return R.error("验证码输入有误");
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setPhone(from.getPhone());
        userEntity.setPwd(from.getPassword());
        userEntity.setUuid(UUIDUtil.getUUID());
        Integer userSave = userService.registerUser(userEntity);
        if (userSave > 0) {
            return R.ok("注册成功");
        }
        return R.error("注册失败");
    }

    /**
     * 登录
     * @param from
     * @param result
     * @return
     */
    @PostMapping(value = "login")
    @ResponseBody
    @ApiOperation("登录")
    @ApiImplicitParam(name = "用户登录", value = "from", dataTypeClass = UserLoFrom.class)
    public R login(@Valid @RequestBody UserLoFrom from, BindingResult result) {
        UserEntity user = userService.queryUserName(from.getName());
        if (user == null) {
            return R.error("用户名不正确！");
        }
        if (!user.getPwd().equals(from.getPwd())) {
            return R.error("密码不正确！");
        }
        //生成Token
        String token = UUIDUtil.getUUID();
        Map<String, String> data = new HashMap<>();
        data.put("token", token);
        //Token存Redis,7天有效期
        redisService.setDay(token, token, 7);

        return R.ok(data);

    }


//    /**
//     * 获取用户信息
//     */
//    @Login
//    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
//    @ResponseBody
//    @ApiOperation("获取用户信息")
//    public R userInfo(@LoginUser UserEntity user, HttpServletRequest request) {
////        user.setPassWord("");
////        user.setSalt("");
////
////        Object token = request.getAttribute(AuthorizationInterceptor.USER_TOKEN);
////        Map<String, Object> map = new HashMap<>();
////        map.put("user", user);
////        map.put("token",token);
////        return R.ok(map);
//        return R.ok();
//    }
//
//    /**
//     * 获取用户ID
//     */
//    @Login
//    @PostMapping("userId")
//    @ResponseBody
//    @ApiOperation("获取用户ID")
//    public R userInfo(@RequestAttribute("userId") String userId) {
//        return R.ok().put("userId", userId);
//    }
//
//    /**
//     * 修改用户信息
//     */
//    @Login
//    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
//    @ResponseBody
//    @ApiOperation("修改用户信息")
//    public R updateUser(@LoginUser UserEntity userEntity, @RequestBody RequestDataPackage rd) {
////        String userName = rd.getDataToString("userName");
////        Validate.notBlank(userName, "用户名为空");
////
////        userEntity.setUserName(userName);
////        userEntity.setUpdateTime(new Date());
////        userService.updateById(userEntity);
//        return R.ok();
//    }
//
//    /**
//     * 修改当前用户密码
//     */
//    @Login
//    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
//    @ResponseBody
//    @ApiOperation("修改当前用户密码")
//    public R updatePassword(@RequestBody RequestDataPackage rd) {
////        UserEntity user = rd.getDataBean(UserEntity.class);
////
////        String userId = rd.getDataToString("userId");
////        boolean state = userService.updatePassword(user, userId);
////        if (state == false) {
////            return R.error("更改密码失败");
////        }
//        return R.ok("更改密码成功");
//    }
//
//    /**
//     * 忘记密码
//     */
//    @RequestMapping(value = "/forgetPwd", method = RequestMethod.POST)
//    @ResponseBody
//    @ApiOperation("忘记密码")
//    public R forgetPwd(@RequestBody RequestDataPackage rd) {
////        String newPassword = rd.getDataToString("newPassword");
////        String phone = rd.getDataToString("phone");
////        String verifyCode = rd.getDataToString("verifyCode");
////
////        return userService.forgetPwd(phone, newPassword, verifyCode);
//
//        return R.ok();
//    }
//
//
//    /**
//     * 登出
//     *
//     * @return
//     */
//    @Login
//    @PostMapping("/loginOut")
//    @ApiOperation("登出")
//    public R loginOut(@RequestBody RequestDataPackage rd, HttpServletRequest request) {
////        String json = getJsonByReq(request);
//
////        if(StringUtils.isBlank(json)){
////            return R.ok( "请输入有效数据");
////        }
////        JSONObject input = JSONObject.parseObject(json);
//        String phone = rd.getDataToString("phone");
//        if (StringUtils.isBlank(phone)) {
//            return R.ok("登陆账号为空");
//        }
////        String address = "";
//        Object token = request.getAttribute(AuthorizationInterceptor.USER_KEY);
//        try {
////            String phone =input.getString("phone");
////            //查看数据库是否有记录
////            Wallet wallet= walletService.quryWallet("", phone);
////            if(wallet == null){
////                return R.create( DomainConstant.R_NOT_SUCCESS, "用户未注册");
////            } else {
////                address =wallet.getAddress();
////            }
//            //清除redis登录状态
////            deleteWallet(phone);
////            String walletStr = JSON.toJSON(wallet).toString( );
//
//            //验证token
////            String token = request.getHeader("token");
////            Claims claims = jwtUtils.getClaimByToken(token);
////            claims.remove(token);
//            return R.ok("退出成功");
//        } catch (Exception e) {
////            logger.error(e.getMessage( ));
//            return R.error(e.getMessage());
//        }
//    }


}
