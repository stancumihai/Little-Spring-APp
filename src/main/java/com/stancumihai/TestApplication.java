package com.stancumihai;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args)  {

    }
}
