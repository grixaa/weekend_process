package org.example.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import lombok.extern.slf4j.Slf4j;
import org.example.controller.dto.ProcessVariables;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DecideWhatDoOnWeekendTask {
    @JobWorker(type = "decideWhatDoOnWeekend", autoComplete = false)
    public ProcessVariables decideWhatDoOnWeekend(ActivatedJob job) {
        log.info("Выполняется Task: decideWhatDoOnWeekend");
        return job.getVariablesAsType(ProcessVariables.class);
    }
}