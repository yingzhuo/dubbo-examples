package de.producer

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo
import org.springframework.context.annotation.Configuration

@EnableDubbo(scanBasePackages = Array(
  "de.consumer",
  "de.service"
))
@Configuration
private class ApplicationConfigDubbo
