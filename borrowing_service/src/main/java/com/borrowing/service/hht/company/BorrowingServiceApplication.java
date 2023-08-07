package com.borrowing.service.hht.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.borrowing.service.hht.company.config.AxonConfig;

@SpringBootApplication
@EnableDiscoveryClient
@Import({AxonConfig.class})
public class BorrowingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BorrowingServiceApplication.class, args);
	}

}
