package org.example.worker;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AcceptInvitationTask {

    @JobWorker(type = "acceptInvitation")
    public void acceptInvitation(@Variable String messageId) {
        log.info("Выполняется Task: acceptInvitation, messageId = {}", messageId);
    }
}
