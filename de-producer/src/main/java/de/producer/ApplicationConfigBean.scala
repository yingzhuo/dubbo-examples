package de.producer

import org.springframework.context.annotation.{Configuration, ImportResource}

@Configuration
@ImportResource(locations = Array(
  "classpath:/META-INF/spring-bean.xml"
))
private class ApplicationConfigBean
