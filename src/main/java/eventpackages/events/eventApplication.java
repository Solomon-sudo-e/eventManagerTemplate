package eventpackages.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import eventpackages.ComponentScanMarker;
import reactor.core.publisher.Hooks;
import reactor.tools.agent.ReactorDebugAgent;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class eventApplication {

	public static void main(String[] args) {
		ReactorDebugAgent.init();
		SpringApplication.run(eventApplication.class, args);
	}

}
