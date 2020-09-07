package com.main.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class,
        scanBasePackages = "com.main.test")
public class ExcelAppMain {

    public static void main(String[] args) {
        SpringApplication.run(ExcelAppMain.class);
    }
}
