package org.sample.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EntityScan({"org.sample.*"})
@EnableScheduling
public class SampleApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(SampleApiApplication.class, args);
  }
}
