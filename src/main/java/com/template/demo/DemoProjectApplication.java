package com.template.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.template.demo.service.ComponentDetailsService;

/**
 * @author nsingotam
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication(scanBasePackages = { "com.template.demo" })
public class DemoProjectApplication {

	private static ConfigurableApplicationContext context;

	public static void main(final String[] args) {
		context = SpringApplication.run(DemoProjectApplication.class, args);
		context.getBean(ComponentDetailsService.class)
				.createComponentDetails(context.getEnvironment().getProperty("spring.application.name"));
	}

}
