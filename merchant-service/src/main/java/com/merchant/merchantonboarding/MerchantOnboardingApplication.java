package com.merchant.merchantonboarding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class MerchantOnboardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MerchantOnboardingApplication.class, args);
    }

}
