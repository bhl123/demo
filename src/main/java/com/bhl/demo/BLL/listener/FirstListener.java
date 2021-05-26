package com.bhl.demo.BLL.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Component
@WebListener
public class FirstListener implements ServletContextListener {

    private Logger logger = LoggerFactory.getLogger(FirstListener.class);


    @Value("${clock.powerSwitch}")
    private String powerSwitch;

    @Value("${clock.startTime}")
    private String startTime;

    public void contextInitialized(ServletContextEvent sce){
        if("true".equals(powerSwitch)){
            System.out.println("~~~~"+this.startTime);
        }

    }
}
