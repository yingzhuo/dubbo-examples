package de.consumer.controller;

import de.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/hello")
    String hello() {
        return demoService.sayHello("Dubbo");
    }

}
