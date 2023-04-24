package restApiProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootConfiguration,@EnableAutoConfiguration,@ComponentScan
public class RestApIprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApIprojectApplication.class, args);
		System.out.println("Server started");
	}

}
