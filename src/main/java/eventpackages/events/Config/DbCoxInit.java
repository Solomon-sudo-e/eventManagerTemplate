package eventpackages.events.Config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import eventpackages.events.dao.PostingRepository;
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
	
	@Bean
	CommandLineRunner initPosting(PostingRepository repo) {
		return args -> {
			repo.save(new Posting())
		}
	}
}
