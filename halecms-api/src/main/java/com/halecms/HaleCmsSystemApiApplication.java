package com.halecms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;


@SpringBootApplication
@ComponentScans(value= {  @ComponentScan(value = "dto.IMapping"),@ComponentScan(value = "repository.service"),@ComponentScan(value = "com.halecms.admin"),@ComponentScan(value = "com.halecms.api")})
@ServletComponentScan("com.halecms.admin")
public class HaleCmsSystemApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(HaleCmsSystemApiApplication.class, args);
    }

}
