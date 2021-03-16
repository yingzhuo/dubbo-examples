package de.consumer

import org.springframework.boot.web.servlet.ServletComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@ServletComponentScan
private class ApplicationConfigWeb extends AnyRef with WebMvcConfigurer
