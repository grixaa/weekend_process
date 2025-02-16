package org.example.worker;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StayHomeTask {
    @JobWorker(type = "stayHome")
    public void stayHome() {
        log.info("Выполняется Task: stayHome");
    }
}
