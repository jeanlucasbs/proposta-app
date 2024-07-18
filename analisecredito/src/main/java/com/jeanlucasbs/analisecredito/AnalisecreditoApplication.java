package com.jeanlucasbs.analisecredito;

import com.jeanlucasbs.analisecredito.service.AnaliseCreditoService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication
public class AnalisecreditoApplication {

	private AnaliseCreditoService analiseCreditoService;

	public static void main(String[] args) {
		SpringApplication.run(AnalisecreditoApplication.class, args);
	}

	public CommandLineRunner commandLineRunner(){
		return args -> {
//			analiseCreditoService.analisar();
		};
	}

}
