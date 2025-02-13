package org.example.service;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ProcessInstanceEvent;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.controller.dto.ProcessData;
import org.example.controller.dto.ProcessVariables;
import org.springframework.stereotype.Service;

import static java.util.Map.of;
import static java.util.UUID.randomUUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true)
public class StartService {
    static final String WEEKEND_PROCESS_NAME = "WEEKEND_PROCESS";
    ZeebeClient zeebeClient;

    public ProcessData startProcess(ProcessVariables request) {
        String uuid = randomUUID().toString();

        ProcessInstanceEvent event = zeebeClient.newCreateInstanceCommand()
            .bpmnProcessId(WEEKEND_PROCESS_NAME)
            .latestVersion()
            .variables(of("countMoney", request.getCountMoney(), "messageId", uuid))
            .send()
            .join();

        return new ProcessData().setProcessInstanceKey(event.getProcessInstanceKey());
    }
}
