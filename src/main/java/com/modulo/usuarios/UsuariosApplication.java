package com.modulo.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"com.modulo.usuarios"})
public class UsuariosApplication {
	public static void main(String[] args) {
		SpringApplication.run(UsuariosApplication.class, args);
	}

}
