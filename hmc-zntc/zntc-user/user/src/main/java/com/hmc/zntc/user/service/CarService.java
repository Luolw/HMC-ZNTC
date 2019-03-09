package com.hmc.zntc.user.service;

import com.hmc.zntc.user.failback.FailBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "ZNTC-CAR", fallback = FailBack.class)
public interface CarService {

    @RequestMapping("/car")
    String car();
}
