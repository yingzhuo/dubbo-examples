package de.producer.svc;

import de.service.DemoService;
import de.service.exception.NotImplementedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("demoService")
class DemoServiceImpl implements DemoService {

    @Override
    public String echo(String text) {
        return text;
    }

    @Override
    public void broken() {
        log.error("本功能未实现");
        throw new NotImplementedException("应卓");
    }

}
