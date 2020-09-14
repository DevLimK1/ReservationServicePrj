package kr.or.devlimk1.reservationweb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"kr.or.devlimk1.reservationweb.dao",
		"kr.or.devlimk1.reservationweb.service"})
@Import({DBConfig.class})
public class ApplicationConfig {

}
