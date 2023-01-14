package com.example.ejerciciossesiones456;

import com.example.ejerciciossesiones456.repositorios.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
/*
Ejercicio 1

Implementar los métodos CRUD en el API REST de Laptop creada en ejercicios anteriores.

Los métodos CRUD:

findAll()

findOneById()

create()

update()

delete()

deleteAll()

Ejercicio 2

Implementar swagger sobre el API REST de Laptop y verificar que funciona
 en la URL: http://localhost:8081/swagger-ui/

Ejercicio 3

Crear casos de test para el controlador de Laptop desde Spring Boot.
 Con click derecho dentro del código de la clase LaptopController utilizar
  la opción Generate > Test para crear la clase con todos los tests unitarios e implementarlos siguiente el proceso visto en clase.
 */


@SpringBootApplication
public class springdeployapplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(springdeployapplication.class, args);
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);

		//laptopRepository.save(new Laptop(null, "Banghó", "ACXAQ", 300.0));
		System.out.println("Cantidad de laptops en la base de datos: " + laptopRepository.count());
	}

}
