package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling 
@EnableWebMvc   //@EnableSwagger2
//@EnableJpaRepositories("put repository path here")

public class Examen1SqueletteApplication {

	public static void main(String[] args) {
		SpringApplication.run(Examen1SqueletteApplication.class, args);
	}

}
