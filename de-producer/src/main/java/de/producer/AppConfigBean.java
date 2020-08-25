package de.producer;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = {"classpath:/dubbo/producer.xml"})
class AppConfigBean {
}
