package com.rdm.rdm;

import Interfaces.Animal;
import Interfaces.AnimalsRepository;
import Interfaces.CreateAnimalService;
import com.rdm.rdm.entity.AnimalDb;
import com.rdm.rdm.entity.AnimalTypeDb;
import com.rdm.rdm.implementations.AnimalsRepositoryImpl;
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
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan({ "com.rdm.rdm*" })
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*@Autowired
	private AnimalDbRepository animalDbRepository;
	@Autowired
	private AnimalTypeDbRepository animalTypeDbRepository;*/
	@Autowired
	private AnimalDbService animalDbService;
	@Autowired
	private AnimalTypeDbService animalTypeDbService;



	@Bean
	@Profile("!test")
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			testMain(ctx);

			AnimalsRepositoryImpl animalsRepository = new AnimalsRepositoryImpl();

			List<AnimalDb> animals = animalDbService.getAnimalsByName("b");
			System.out.println("Результат работы метода: " + animals);
			List<AnimalDb> allAnimals = animalDbService.getAllAnimals();
			System.out.println("Все животные: " + allAnimals);
			AnimalTypeDb animalTypeDb = animalTypeDbService.findByAnimalType("Cat").get(0);
			System.out.println("Тип животного: " + animalTypeDb);
			AnimalDb newAnimal = new AnimalDb(null,animalTypeDb,"w", "e", 99.1, "qwe", LocalDate.of(2020, 3, 23));
			animalDbService.addAnimal(newAnimal);
			animalDbService.deleteById(1L);


			Map<String, LocalDate> animalsMap;
			animalsMap = animalsRepository.findLeapYearIdsDb(allAnimals);
			System.out.println("Животные високосного года: " + animalsMap.keySet());
			System.out.println("Животные с мин стоимостью: " +
					animalsRepository.findMinCostAnimalsDb(allAnimals));
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
