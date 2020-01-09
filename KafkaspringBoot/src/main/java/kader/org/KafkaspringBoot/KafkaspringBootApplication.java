package kader.org.KafkaspringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaspringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaspringBootApplication.class, args);
	}

}
