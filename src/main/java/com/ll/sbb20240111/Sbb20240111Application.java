package com.ll.sbb20240111;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Sbb20240111Application {

    public static void main(String[] args) {
        SpringApplication.run(Sbb20240111Application.class, args);
    }

}
