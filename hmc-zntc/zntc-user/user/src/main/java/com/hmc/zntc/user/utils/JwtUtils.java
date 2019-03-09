package com.hmc.zntc.user.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * 类JwtUtils的功能描述:
 * jwt工具类
 * @auther hxy
 * @date 2017-10-16 14:19:54
 */
@ConfigurationProperties(prefix = "audience")
@Component
public class JwtUtils {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${audience.secret}")
    private String secret;

    @Value("${audience.expire}")
    private long expire;

    @Value("${audience.header}")
    private String header;




    /**
     * 生成jwt token
     */
    public String generateToken(String userId) {
        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(userId)//主题，也差不多是个人的一些信息
                .setIssuedAt(nowDate) //创建时间
                .setExpiration(expireDate)//添加Token过期时间
                //.setAudience(audience) //个人签名
                //.setIssuer(issuer) //发送谁
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Claims getClaimByToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            logger.debug("token验证错误,请重新登陆 ", e);
            return null;
        }
    }

    /**
     * token是否过期
     * @return  true：过期
     */
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }

    public String getSecret() {
        return secret;
    }

    public long getExpire() {
        return expire;
    }

    public String getHeader() {
        return header;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public void setHeader(String header) {
        this.header = header;
    }
    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
