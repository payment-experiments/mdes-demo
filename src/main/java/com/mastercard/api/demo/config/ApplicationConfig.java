package com.mastercard.api.demo.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;


@SpringBootApplication
@ComponentScan("com.mastercard.api.demo")
@Profile({ ApplicationConfig.ConfigProfile.MAIN})
@EnableAutoConfiguration(
		exclude = { DataSourceAutoConfiguration.class, 
				    DataSourceTransactionManagerAutoConfiguration.class, 
				    HibernateJpaAutoConfiguration.class})

public class ApplicationConfig extends SpringBootServletInitializer {

	public interface ConfigProfile {
		public static final String MAIN = "main";
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApplicationConfig.class);
	}

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder().sources(ApplicationConfig.class).run(args);
	}
}
