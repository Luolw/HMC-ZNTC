package com.hmc.zntc.admin.config;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @Description :
 * @Author : chengxinghua
 * @Date : 2018/6/10/010 12:05
 */
//@Configuration
public class JacksonConfig {

//    @Bean
//    public ObjectMapper ObjectMapper() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
//        SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        objectMapper.setDateFormat(smt);
//        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
//        return objectMapper;
//    }
}
