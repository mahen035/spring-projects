package com.ps.zuulgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ZuulgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulgatewayApplication.class, args);
	}

	@Bean
	public RouteLocator configureRoute(RouteLocatorBuilder builder){
		return builder.routes()
				.route("student", r->r.path("/api/v1/**").uri("lb://student-service"))
				.route("course", r->r.path("/api/vi/**").uri("lb://course-service"))
				.build();
	}
}

//@PostConstruct:
/*
   @PostConstruct
   public void postConstruct(){
    User user = new User("test", "test123");
    repository.save(user)
  }

  @PreDestroy
  cleanup activity
 */


