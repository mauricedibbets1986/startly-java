package app.startly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartlyApplication.class, args);
		System.out.println("HAVE A GOOD START OF THE DAY");
	}

}
