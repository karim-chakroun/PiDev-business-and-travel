package tn.esprit.spring;

import java.awt.image.BufferedImage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling 
@EnableWebMvc   //@EnableSwagger2
public class Examen1SqueletteApplication {

	public static void main(String[] args) {
		SpringApplication.run(Examen1SqueletteApplication.class, args);
	}
	  @Bean
	    public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
	        return new BufferedImageHttpMessageConverter();
	    }
}
