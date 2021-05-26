package com.bhl.demo;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@ComponentScan(basePackages = {"com.bhl.demo.*"})
@ServletComponentScan(basePackages = "com.bhl.demo.BLL.listener")
public class DemoApplication {
    private static Logger log=Logger.getLogger(DemoApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        log.info("===============启动成功================");
    }

}
