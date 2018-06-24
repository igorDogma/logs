package com.igor.rozhnev.logs;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * The configuration that enumerates required annotation to run JUnit tests under Spring context.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@WebAppConfiguration
public class TestApplicationConfiguration {
}

