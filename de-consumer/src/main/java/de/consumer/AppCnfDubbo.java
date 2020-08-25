package de.consumer;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = {"classpath:/dubbo/consumer.xml"})
class AppCnfDubbo {
}
