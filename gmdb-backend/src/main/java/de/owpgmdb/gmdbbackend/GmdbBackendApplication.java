package de.owpgmdb.gmdbbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class GmdbBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmdbBackendApplication.class, args);
	}

}