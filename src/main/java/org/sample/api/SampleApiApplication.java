package org.sample.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"org.sample.*"})
public class SampleApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(SampleApiApplication.class, args);
  }
}
