package org.example.worker;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.PublishMessageResponse;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true)
public class ChatInSocialNetworksTask {
    ZeebeClient zeebeClient;

    @JobWorker(type = "chatInSocialNetworks", autoComplete = true)
    public void chatInSocialNetworks(@Variable String messageId) {
        log.info("Выполняется Task: chatInSocialNetworks");

        PublishMessageResponse messageResponse = zeebeClient.newPublishMessageCommand()
            .messageName("MEET_MESSAGE")
            .correlationKey(messageId)
            .send()
            .join();

        log.info("There were sent message with messageKey {} and correlationKey {}", messageResponse.getMessageKey(), messageId);
    }
}
