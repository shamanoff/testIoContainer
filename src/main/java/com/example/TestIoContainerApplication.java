package com.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestIoContainerApplication {

    public static void main(String[] args) {


        BeanFactory beanFactory = SpringApplication.run(TestIoContainerApplication.class, args);
        beanFactory.getBean(IService.class).print(1);
    }
}
