package org.example.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.example.worker.dto.AllVariables;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WakeUpTask {

    @JobWorker(type = "wakeUp", fetchAllVariables = true)
    public void wakeUp(ActivatedJob job) {
        log.info("Выполняется Task: wakeUp");
        val variables = job.getVariablesAsType(AllVariables.class);
        log.info("countMoney = {}", variables.getCountMoney());
    }
}
