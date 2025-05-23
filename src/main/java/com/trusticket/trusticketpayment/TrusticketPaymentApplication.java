package com.trusticket.trusticketpayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@ConfigurationPropertiesScan
@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
@SpringBootApplication
@EnableDiscoveryClient
public class TrusticketPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrusticketPaymentApplication.class, args);
	}

}
