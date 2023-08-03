package eventpackages.events.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import eventpackages.events.Entity.UserData;

public interface UserRepository extends ReactiveCrudRepository<UserData, Long> {}
