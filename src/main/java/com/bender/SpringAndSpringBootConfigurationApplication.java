package com.bender;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

//@SpringBootApplication
public class SpringAndSpringBootConfigurationApplication {

    @Value("${app.stripe.api-key}")
    private  String stripeApiKey;

    public static void main(String[] args) {
        SpringApplication.run(
                SpringAndSpringBootConfigurationApplication.class,
                args
        );
    }

    @Bean
    CommandLineRunner runner(Environment env, StripeConfig stripeConfig) {
        System.out.println(stripeApiKey );
        System.out.println(env.getProperty("app.stripe.api-key"));
        System.out.println(stripeConfig);
        return args -> {};
    }
}
