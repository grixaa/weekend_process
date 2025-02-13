package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.controller.dto.ProcessData;
import org.example.controller.dto.ProcessVariables;
import org.example.service.StartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/start")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true)
public class StartController {
    StartService startService;

    @PostMapping("/weekend")
    public ProcessData startProcess(@RequestBody ProcessVariables request) {
        return startService.startProcess(request);
    }
}
