package eventpackages.events.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import eventpackages.events.Entity.Registration;

public interface RegistrationRepository extends ReactiveCrudRepository<Registration, Long>{

}
