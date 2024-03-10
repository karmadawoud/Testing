package group_9.Faircraft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.micrometer.common.lang.NonNull;

@SpringBootApplication
@EnableJpaAuditing
public class FaircraftApplication {

public static void main(String[] args){
	SpringApplication.run(FaircraftApplication.class,args);
}


@Bean
public WebMvcConfigurer corsConfigurer() {
	return new WebMvcConfigurer() 
	{
		@NonNull
		@Override
		public void addCorsMappings(CorsRegistry registry){
			registry.addMapping("/**")
			.allowedOrigins("http://localhost:3000");
		}

	};
	
}

}


