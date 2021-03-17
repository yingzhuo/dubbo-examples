package de.producer

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.{Configuration, ImportResource}

@Configuration
@ImportResource(locations = Array(
  "classpath:/META-INF/spring-bean.xml"
))
@ConfigurationPropertiesScan
private class ApplicationConfigBean
