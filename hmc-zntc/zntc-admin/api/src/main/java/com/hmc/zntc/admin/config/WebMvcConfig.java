package com.hmc.zntc.admin.config;

import com.hmc.zntc.admin.interceptor.AuthorizationInterceptor;
import com.hmc.zntc.admin.resolver.LoginUserHandlerMethodArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * MVC配置
 *
 * @author chengxinghua
 * @email sunlightcs@gmail.com
 * @date 2017-04-20 22:30
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    public AuthorizationInterceptor getAuthorizationInterceptor(){
        return new AuthorizationInterceptor();
    }
    @Bean
    public LoginUserHandlerMethodArgumentResolver getLoginUserHandlerMethodArgumentResolver(){
        return new LoginUserHandlerMethodArgumentResolver();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthorizationInterceptor()).addPathPatterns("/api/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(getLoginUserHandlerMethodArgumentResolver());
    }

}
