package org.itstep.msk.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"org.itstep.msk.app.Configuration","org.itstep.msk.app.controller","org.itstep.msk.app.repository",
"org.itstep.msk.app.service","org.itstep.msk.app.entity","org.itstep.msk.app"})
public class AppApplication {
	public static void main(String[] args)  {
		SpringApplication.run(AppApplication.class, args);
	}
}
