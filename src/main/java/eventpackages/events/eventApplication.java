package eventpackages.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import eventpackages.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class eventApplication {

	public static void main(String[] args) {
		SpringApplication.run(eventApplication.class, args);
	}

}
