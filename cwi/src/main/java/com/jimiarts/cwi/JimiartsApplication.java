package com.jimiarts.cwi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = {"com.jimiarts.models", "com.jimiarts.cwi"})
public class JimiartsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JimiartsApplication.class, args);
    }

}
