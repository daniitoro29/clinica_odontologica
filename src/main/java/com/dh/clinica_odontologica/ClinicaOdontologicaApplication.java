package com.dh.clinica_odontologica;

import com.dh.clinica_odontologica.dao.DB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaOdontologicaApplication {

	public static void main(String[] args) {
		DB.createTable();
		SpringApplication.run(ClinicaOdontologicaApplication.class, args);
	}

}
