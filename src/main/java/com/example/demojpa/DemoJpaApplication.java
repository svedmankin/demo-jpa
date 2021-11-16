package com.example.demojpa;

import com.example.demojpa.services.TestDataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DemoJpaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoJpaApplication.class, args);

		TestDataService testService = ctx.getBean(TestDataService.class);

		testService.initData();
		testService.printAllPersons();
		testService.printPersonsByCriteria();
	}

}
