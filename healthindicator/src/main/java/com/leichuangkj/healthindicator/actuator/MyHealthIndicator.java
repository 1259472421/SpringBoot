package com.leichuangkj.healthindicator.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        Long totalSpace = checkTotalSpace();
        Long free = checkFree();
        String status = checkStatus();
        checkFree();
        return new Health.Builder().up()
                .withDetail("status",status)
                .withDetail("total",totalSpace)
                .withDetail("free",checkFree())
                .build();
    }

    private String checkStatus() {
        //结合真是项目，获取相关参数。
        return "UP";
    }

    private Long checkFree() {
        //结合真是项目，获取相关参数。
        return 10000L;
    }

    private Long checkTotalSpace() {
        //结合真是项目，获取相关参数。
        return 10000L;
    }
}
