package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.example.dao","com.example.mapper"})
public class JavawebMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavawebMainApplication.class, args);
    }

}
