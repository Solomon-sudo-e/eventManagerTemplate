package eventpackages.events.Config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import eventpackages.events.Entity.Guest;
import eventpackages.events.dao.GuestRepository;
import io.r2dbc.spi.ConnectionFactory;

@Configuration
public class DbCoxInit {
	
	@Bean
	ConnectionFactoryInitializer initializer(@Qualifier("connectionFactory")
	ConnectionFactory factory) {
		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
		initializer.setConnectionFactory(factory);
		initializer.setDatabasePopulator(
				new ResourceDatabasePopulator(new ClassPathResource("EventManagementDefaultScript.sql")));
		return initializer;
	}

//	@Bean
//	CommandLineRunner initUser(UserRepository repo) {
//		return args -> {
//			repo.save(new UserData("Solomon", "4793243242",
//					"Siloam", "Spain", 
//					"Solo.hufford@gmail.com", "password"))
//				.thenMany(repo.findAll())
//				.subscribe(System.out::println);		
//		};
//	}
	
//	@Bean
//	CommandLineRunner initEvent(EventCrRepository repo) {
//		Status accept = Status.ACCEPTED;
//		return args -> {
//			repo.save(new EventCreation("New event", "free food", accept, "time", "tiempo"))
//			.thenMany(repo.findAll())
//			.subscribe(System.out::println);
//		};
//	}
	
//	@Bean
//	CommandLineRunner initEventCr(EventRepository repo) {
//		return args -> {
//			repo.save(new Event("Hackathon", "Where the best meet", "023422", "022225"))
//			.thenMany(repo.findAll())
//			.subscribe(System.out::println);
//		};
//	}
	
//	@Bean
//	CommandLineRunner initVenue(VenueRepository repo) {
//		return args -> {
//			repo.save(new Venue("La rosa", "2231 S California Lane", 250))
//			.thenMany(repo.findAll())
//			.subscribe(System.out::println);
//		};
//	}
	
//	@Bean
//	CommandLineRunner initRegistraton(RegistrationRepository repo) {
//		Private yes = Private.YES;
//		long userId = 1;
//		return args -> {
//			repo.save(new Registration("Will you be bringing a guest?, How old are you?",
//					yes, userId))
//			.thenMany(repo.findAll())
//			.subscribe(System.out::println);	
//		};
//	}
	
//	@Bean
//	CommandLineRunner initPosting(PostingRepository repo) {
//		long variable = 1;
//		return args -> {
//			repo.save(new Posting("New event somewhere cool", "Free water", variable, 
//					variable, variable, variable))
//			.thenMany(repo.findAll())
//			.subscribe(System.out::println);
//		};
//	}
	
//	@Bean
//	CommandLineRunner initGuest(GuestRepository repo) {
//		return args -> {
//			repo.save(new Guest("salmon"))
//			.thenMany(repo.findAll())
//			.subscribe(System.out::println);
//		};
//	}
	
}
