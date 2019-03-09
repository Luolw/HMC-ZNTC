/**
 * Copyright 2018 PANDA http://io.wrzn
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.hmc.zntc.user.interceptor;


import com.hmc.zntc.user.annotation.Login;
import com.hmc.zntc.user.entity.UserEntity;
import com.hmc.zntc.user.exception.RRException;
import com.hmc.zntc.user.service.UserService;
import com.hmc.zntc.user.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限(Token)验证
 *
 * @author chengxinghua
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:38
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserService userService;

    public static final String USER_KEY = "userId";
    public static final String USER_TOKEN = "userToken";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Login annotation;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
        } else {
            return true;
        }

        if (annotation == null) {
            return true;
        }

        //需要验证，获取用户凭证
        String token = request.getHeader(jwtUtils.getHeader());

        if (StringUtils.isBlank(token)) {
            token = request.getParameter(jwtUtils.getHeader());
//            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
//            String body = IOUtils.read(reader);
//            String name = request.getParameter("name");
        }

        //凭证为空
        if (StringUtils.isBlank(token)) {
            throw new RRException("无token，请重新登录");
        }

        //验证token
        Claims claims = jwtUtils.getClaimByToken(token);
        if (claims == null || jwtUtils.isTokenExpired(claims.getExpiration())) {
            throw new RRException("凭证失效，请重新登录");
        }

        //验证用户信息
        UserEntity user = userService.selectById(claims.getSubject());
        if (user == null) {
            throw new RuntimeException("用户不存在，请重新登录");
        }

        //设置userId到request里，后续根据userId，获取用户信息
        request.setAttribute(USER_KEY, claims.getSubject());
        request.setAttribute(USER_TOKEN, token);

        return true;
    }
}
