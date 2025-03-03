package com.example.flowTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.flowTest.test.StartControllerA;

@SpringBootApplication
public class FlowTestApplication {
	
	private static ApplicationContext applicationContext;
	
	@Autowired
	StartControllerA startControllerA;

	public static void main(String[] args) {
		
		applicationContext = SpringApplication.run(FlowTestApplication.class, args);
		
		 String[] allBeanNames = applicationContext.getBeanDefinitionNames();
	        for(String beanName : allBeanNames) {
	            System.out.println(beanName);
	        }			        				
	}
	
//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		return args -> {
//
//			StringRequest request = new StringRequest();
//			request.setRequets("PassoE");		
//			StringResponse response = new StringResponse();
//			
//			FlowchartSpringHandler<StringRequest,StringResponse> flow = new FlowchartSpringHandler<StringRequest,StringResponse>(request,response);			
//			flow.start(startControllerA);									
//			
//			System.out.println(flow.getResponse().getResponse().toString());
//		};
//	}

}
