package com.rdm.rdm;

import Interfaces.Animal;
import Interfaces.CreateAnimalService;
import com.rdm.rdm.entity.AnimalDb;
import com.rdm.rdm.implementations.CreateAnimalServiceImpl;
import com.rdm.rdm.repo.AnimalDbRepository;
import com.rdm.rdm.repo.AnimalTypeDbRepository;
import com.rdm.rdm.service.AnimalDbService;
import com.rdm.rdm.service.AnimalTypeDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;


import java.io.IOException;
import java.util.List;
import java.util.Map;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }, scanBasePackages={
		"com.rdm.rdm"})
//@ComponentScan
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private AnimalDbRepository animalDbRepository;
	@Autowired
	private AnimalTypeDbRepository animalTypeDbRepository;
	@Autowired
	private AnimalDbService animalDbService;
	@Autowired
	private AnimalTypeDbService animalTypeDbService;


	@Bean
	@Profile("!test")
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			testMain(ctx);

			List<AnimalDb> animals = animalDbService.findByCharacter("Angry");
			System.out.println("Результат работы метода: " + animals);
		};
	}

	private static void testMain(ApplicationContext ctx) throws IOException {
		System.out.println("----- Старт приложения -----");
		/*CreateAnimalService createAnimalService = ctx.getBean(CreateAnimalServiceImpl.class);
		createAnimalService.createAnimals(5);*/

		/*Map<String, List<Animal>> mapAnimals = createAnimalService.createAnimalsMap(5);
		System.out.println(mapAnimals.keySet().toString());*/
	}

}
