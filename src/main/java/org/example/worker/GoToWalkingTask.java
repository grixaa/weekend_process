package org.example.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.exception.ZeebeBpmnError;
import lombok.extern.slf4j.Slf4j;
import org.example.controller.dto.ProcessVariables;
import org.springframework.stereotype.Component;

import java.util.Random;

import static java.lang.Math.random;

@Component
@Slf4j
public class GoToWalkingTask {
    @JobWorker(type = "goToWalking")
    public void goToWalking(ActivatedJob job) {
        log.info("Выполняется Task: goToWalking");

        // случайным образом определяем, пойдет ли дождь
        boolean needToGoHome = random() < 0.2;

        if (needToGoHome) {
            throw new ZeebeBpmnError("RAIN_STARTS", "Внезапно пошёл дождь");
        } else {
            ProcessVariables variables = job.getVariablesAsType(ProcessVariables.class);
            // случайным образом получаем количество денег, оставшихся полсе прогулки
            variables.setCountMoney(new Random().nextInt(variables.getCountMoney() + 1));
            log.info("Количество денег после прогулки = {}", variables.getCountMoney());
        }
    }
}
