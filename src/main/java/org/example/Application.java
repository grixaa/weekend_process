package org.example;

import io.camunda.zeebe.spring.client.annotation.Deployment;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@Deployment(resources = {"classpath*:/process/*.bpmn"})
public class Application {
    public static void main(String[] args) {
        run(Application.class, args);
    }
}