package io.github.lsmcodes.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.lsmcodes.bootcamp.model.catalogo.Catalogo;

@SpringBootApplication
public class BootcampApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampApplication.class, args);

		Catalogo catalogo = new Catalogo();
		catalogo.mostrarMenu();
	}

}