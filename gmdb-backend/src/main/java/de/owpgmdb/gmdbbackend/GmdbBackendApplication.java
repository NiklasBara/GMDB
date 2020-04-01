package de.owpgmdb.gmdbbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"de.owpgmdb.gmdbbackend"})
public class GmdbBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmdbBackendApplication.class, args);
	}

}