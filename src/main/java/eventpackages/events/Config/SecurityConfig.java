package eventpackages.events.Config;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
//import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
//import org.springframework.web.reactive.function.client.WebClient;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig {
//	@Bean
//	WebClient client(ClientRegistrationRepository regRepo, 
//			OAuth2AuthorizedClientRepository cliRepo) {
//		ServletOAuth2AuthorizedClientExchangeFilterFunction filter =
//				new ServletOAuth2AuthorizedClientExchangeFilterFunction
//				(regRepo, cliRepo);
//		
//		filter.setDefaultOAuth2AuthorizedClient(true);
//		
//		return WebClient.builder()
//				.baseUrl("http://localhost:7655/")
//				.apply(filter.oauth2Configuration())
//				.build();
//	}
//}

