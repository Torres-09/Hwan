package hwan.SMDFA;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EnableBatchProcessing // 배치기능 활성화
@SpringBootApplication
public class SmdfaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmdfaApplication.class, args);
	}

}
