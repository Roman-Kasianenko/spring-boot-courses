package com.bender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication
public class SpringAndSpringBootLoggingApplication {

    private final static Logger LOGGER =
            LoggerFactory.getLogger(SpringAndSpringBootLoggingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(
                SpringAndSpringBootLoggingApplication.class,
                args
        );
        LOGGER.info("Hello World!");
        LOGGER.debug("I am a debug message");
        LOGGER.warn("I am a warn message");
        LOGGER.error("I am a error message");
        LOGGER.trace("I am a trace message");
    }
}
