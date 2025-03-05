package com.bender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

//@SpringBootApplication
//@EnableScheduling
//@EnableAsync
public class SpringAndSpringBootTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                SpringAndSpringBootTaskApplication.class,
                args
        );
    }

    @Scheduled(fixedRate = 5, timeUnit = TimeUnit.SECONDS)
    @Async
    public void sendEmail() throws InterruptedException {
        System.out.println("Start Sending email");
        Thread.sleep(2000);
        System.out.println("Finish Sending email");
    }

    @Scheduled(fixedRate = 10, timeUnit = TimeUnit.SECONDS)
    @Async
    public void generateSalesReport() throws InterruptedException {
        System.out.println("Start Start generating sales report");
        Thread.sleep(2000);
        System.out.println("Finish generating sales report");
    }
}
