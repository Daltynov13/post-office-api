package kz.dar.academy.backend.postofficeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PostOfficeApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(PostOfficeApiApplication.class, args);
  }

}
