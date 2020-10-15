package org.itstep.msk.app;

		import lombok.extern.log4j.Log4j2;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.context.annotation.ComponentScan;
		import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

		import java.io.IOException;


@SpringBootApplication(scanBasePackages = {"org.itstep.msk.app","src/main/resources"})
@EnableAutoConfiguration
public class AppApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AppApplication.class, args);
	}
}
