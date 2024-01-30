package com.bitcafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BitcafeApplication {

    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.yml,"
            + "/app/config/springboot-webservice/real-application.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(BitcafeApplication.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }

//    public static void main(String[] args) {
//        SpringApplication.run(BitcafeApplication.class, args);
//    }

}
