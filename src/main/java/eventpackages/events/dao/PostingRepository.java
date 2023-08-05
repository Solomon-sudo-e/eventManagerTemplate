package eventpackages.events.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import eventpackages.events.Entity.Posting;

public interface PostingRepository extends ReactiveCrudRepository<Posting, Long>{}
