package dev.bruno.netwars.netwars;

import dev.bruno.netwars.netwars.model.Rebellion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NetwarsApplication {
	public static Rebellion rebellion = new Rebellion();
	public static void main(String[] args) {
		SpringApplication.run(NetwarsApplication.class, args);
	}
}
