package de.producer.svc;

import de.service.DemoService;

public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        return "hello " + name + ".";
    }

}
