package com.hmc.zntc.admin.controller.userController;


import io.swagger.annotations.ApiOperation;
import com.hmc.zntc.admin.annotation.Login;
import com.hmc.zntc.admin.annotation.LoginUser;
import com.hmc.zntc.admin.annotation.WalletInfo;
import com.hmc.zntc.admin.config.bean.RequestDataPackage;
import com.hmc.zntc.admin.entity.UserEntity;
import com.hmc.zntc.admin.interceptor.AuthorizationInterceptor;
import com.hmc.zntc.admin.service.SmsService;
import com.hmc.zntc.admin.service.UserService;
import com.hmc.zntc.admin.utils.JwtUtils;
import com.hmc.zntc.admin.utils.R;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录接口
 *
 * @author chengxinghua
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:31
 */
@RestController
@RequestMapping("/api")
@Api(tags = "登录接口")
public class ApiLoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private SmsService smService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private StringRedisTemplate redisTemplate;


    /**
     * 登录
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("登录")
    public R login(@RequestBody RequestDataPackage rd) {
//        UserEntity user = rd.getDataBean(UserEntity.class);
        //用户登录
//        UserEntity loginUser = userService.login(user);
//
//        String userId = loginUser.getId();
//        //生成token
//        String token = jwtUtils.generateToken(userId);
//        Map<String, Object> map = new HashMap<>();
//        map.put("token", token);
//        map.put("expire", jwtUtils.getExpire());
//        map.put("user", loginUser);
//        return R.ok(map);
        return R.ok();
    }

    /**
     * 注册用户
     */
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("注册用户")
    public R registUser(@RequestBody RequestDataPackage rd) {
//        UserEntity user = rd.getDataBean(UserEntity.class);
//        String code = rd.getDataToString("verifyCode");
//
//        return userService.insert(user, code);
        return R.ok();
    }

    /**
     * 发送短信
     */
    @RequestMapping(value = "/getVerifyCode", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("发送短信")
    public R sendMsg(@RequestBody RequestDataPackage rd) {

        String phone = rd.getDataToString("phone");
        String busicCode = rd.getDataToString("busiCode");

        Boolean send = smService.sendMsg(phone, busicCode);
        return R.ok("发送短信成功");
    }

    /**
     * 获取用户信息
     */
    @Login
    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("获取用户信息")
    public R userInfo(@LoginUser UserEntity user, HttpServletRequest request) {
//        user.setPassWord("");
//        user.setSalt("");
//
//        Object token = request.getAttribute(AuthorizationInterceptor.USER_TOKEN);
//        Map<String, Object> map = new HashMap<>();
//        map.put("user", user);
//        map.put("token",token);
//        return R.ok(map);
        return R.ok();
    }

    /**
     * 获取用户ID
     */
    @Login
    @PostMapping("userId")
    @ResponseBody
    @ApiOperation("获取用户ID")
    public R userInfo(@RequestAttribute("userId") String userId) {
        return R.ok().put("userId", userId);
    }

    /**
     * 修改用户信息
     */
    @Login
    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("修改用户信息")
    public R updateUser(@LoginUser UserEntity userEntity, @RequestBody RequestDataPackage rd) {
//        String userName = rd.getDataToString("userName");
//        Validate.notBlank(userName, "用户名为空");
//
//        userEntity.setUserName(userName);
//        userEntity.setUpdateTime(new Date());
//        userService.updateById(userEntity);
        return R.ok();
    }

    /**
     * 修改当前用户密码
     */
    @Login
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("修改当前用户密码")
    public R updatePassword(@RequestBody RequestDataPackage rd) {
//        UserEntity user = rd.getDataBean(UserEntity.class);
//
//        String userId = rd.getDataToString("userId");
//        boolean state = userService.updatePassword(user, userId);
//        if (state == false) {
//            return R.error("更改密码失败");
//        }
        return R.ok("更改密码成功");
    }

    /**
     * 忘记密码
     */
    @RequestMapping(value = "/forgetPwd", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("忘记密码")
    public R forgetPwd(@RequestBody RequestDataPackage rd) {
//        String newPassword = rd.getDataToString("newPassword");
//        String phone = rd.getDataToString("phone");
//        String verifyCode = rd.getDataToString("verifyCode");
//
//        return userService.forgetPwd(phone, newPassword, verifyCode);

        return R.ok();
    }


    /**
     * 登出
     *
     * @return
     */
    @Login
    @PostMapping("/loginOut")
    @ApiOperation("登出")
    public R loginOut(@RequestBody RequestDataPackage rd, HttpServletRequest request) {
//        String json = getJsonByReq(request);

//        if(StringUtils.isBlank(json)){
//            return R.ok( "请输入有效数据");
//        }
//        JSONObject input = JSONObject.parseObject(json);
        String phone = rd.getDataToString("phone");
        if (StringUtils.isBlank(phone)) {
            return R.ok("登陆账号为空");
        }
//        String address = "";
        Object token = request.getAttribute(AuthorizationInterceptor.USER_KEY);
        try {
//            String phone =input.getString("phone");
//            //查看数据库是否有记录
//            Wallet wallet= walletService.quryWallet("", phone);
//            if(wallet == null){
//                return R.create( DomainConstant.R_NOT_SUCCESS, "用户未注册");
//            } else {
//                address =wallet.getAddress();
//            }
            //清除redis登录状态
//            deleteWallet(phone);
//            String walletStr = JSON.toJSON(wallet).toString( );

            //验证token
//            String token = request.getHeader("token");
//            Claims claims = jwtUtils.getClaimByToken(token);
//            claims.remove(token);
            return R.ok("退出成功");
        } catch (Exception e) {
//            logger.error(e.getMessage( ));
            return R.error(e.getMessage());
        }
    }


}
