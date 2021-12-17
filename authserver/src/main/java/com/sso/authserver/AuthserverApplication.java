package com.sso.authserver;

import com.sso.authserver.config.KeycloakServerProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = LiquibaseAutoConfiguration.class)
@EnableConfigurationProperties({ KeycloakServerProperties.class })
public class AuthserverApplication {

	private static final Logger LOG = LoggerFactory.getLogger(AuthserverApplication.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AuthserverApplication.class, args);
	}

	@Bean
	ApplicationListener<ApplicationReadyEvent> onApplicationReadyEventListener(ServerProperties serverProperties,
			KeycloakServerProperties keycloakServerProperties) {

		return (evt) -> {

			Integer port = serverProperties.getPort();
			String keycloakContextPath = keycloakServerProperties.getContextPath();

			LOG.info("Embedded Keycloak started: http://localhost:{}{} to use keycloak", port, keycloakContextPath);
		};
	}

}