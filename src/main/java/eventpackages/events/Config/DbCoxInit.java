package eventpackages.events.Config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import eventpackages.events.Entity.UserData;
import eventpackages.events.dao.UserRepository;
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
//	CommandLineRunner init(UserRepository repo) {
//		return args -> {
//			repo.save(new UserData("Solomon", "4793243242",
//					"Siloam", "Spain", 
//					"Solo.hufford@gmail.com", "password"))
//				.thenMany(repo.findAll())
//				.subscribe(System.out::println);		
//		};
//	}
	
}
