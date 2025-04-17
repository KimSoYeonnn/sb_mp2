package org.sommer.sb_mp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SbMp2Application {

	public static void main(String[] args) {
		SpringApplication.run(SbMp2Application.class, args);
	}

}
