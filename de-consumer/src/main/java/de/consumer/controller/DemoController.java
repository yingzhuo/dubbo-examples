package de.consumer.controller;

import de.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/echo")
    String echo() {
        return demoService.echo("hello, dubbo!");
    }

    @GetMapping("/broken")
    String broken() {
        try {
            demoService.broken();
            return "ok";
        } catch (Exception exception) {
            return exception.getClass().getName();
        }
    }

}
