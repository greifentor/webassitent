package de.ollie.webassistent.gui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The starter class for the application.
 *
 * GENERATED CODE !!! DO NOT CHANGE !!!
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("de.ollie.webassistent.persistence.repository")
@ComponentScan("de.ollie.webassistent")
@EntityScan("de.ollie.webassistent.persistence.entity")
public class GUIApplicationStarter extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(GUIApplicationStarter.class, args);
	}

}