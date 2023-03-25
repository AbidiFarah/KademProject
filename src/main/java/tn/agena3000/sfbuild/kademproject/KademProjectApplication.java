package tn.agena3000.sfbuild.kademproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KademProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(KademProjectApplication.class, args);
	}

}
