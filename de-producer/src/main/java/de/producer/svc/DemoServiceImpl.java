package de.producer.svc;

import de.service.DemoService;

public class DemoServiceImpl implements DemoService {

    @Override
    public String echo(String text) {
        return text;
    }

    @Override
    public String broken() {
        throw new UnsupportedOperationException();
    }

}
