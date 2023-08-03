package eventpackages.events.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfig {
	private final PasswordEncoder pwEncoder = 
			PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	@Bean
	UserDetailsService authentication() {
		UserDetails solomon = User.builder()
				.username("solomon")
				.password(pwEncoder.encode("solomon"))
				.roles("USER", "ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(solomon);
	}
	
}
