package de.producer;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = "classpath:/META-INF/spring-bean.xml")
class AppCnfBean {
}
