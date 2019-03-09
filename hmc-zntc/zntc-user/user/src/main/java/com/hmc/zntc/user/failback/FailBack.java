package com.hmc.zntc.user.failback;

import com.hmc.zntc.user.service.CarService;
import org.springframework.stereotype.Component;

@Component
public class FailBack implements CarService {

    @Override
    public String car() {
        return "car error";
    }
}
