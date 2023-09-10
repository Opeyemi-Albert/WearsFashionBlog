package com.example.wearsfashionblog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.TimeZone;
@Slf4j
@SpringBootApplication
public class WearsFashionBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(WearsFashionBlogApplication.class, args);
        log.info(
                "\n\n ============================ APPLICATION LAUNCHED ======================= \n\n");
        TimeZone.setDefault(TimeZone.getTimeZone("Africa/Lagos"));
        System.out.println(LocalDateTime.now());
    }

}
