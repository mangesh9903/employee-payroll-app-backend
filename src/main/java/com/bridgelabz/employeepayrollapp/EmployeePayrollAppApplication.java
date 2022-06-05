package com.bridgelabz.employeepayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/***********************************************************************************************************************
 * Class :- Employee Payroll Application.
 * @author Mangesh
 * @date 02-06-2022
 **********************************************************************************************************************/
@EnableSwagger2
@Slf4j
@SpringBootApplication
public class EmployeePayrollAppApplication {

    public static void main(String[] args) {

      ApplicationContext context = SpringApplication.run(EmployeePayrollAppApplication.class, args);
        log.info("Employee Payroll App Started", context.getEnvironment().getProperty("environment"));
    }

	/**
	 * Method :- Method to Configure Swagger.
	 */
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bridgelabz.employeepayrollapp"))
                .build();
    }


}
