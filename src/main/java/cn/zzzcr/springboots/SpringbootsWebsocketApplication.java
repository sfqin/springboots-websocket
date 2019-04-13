package cn.zzzcr.springboots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootsWebsocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootsWebsocketApplication.class, args);
	}

}
