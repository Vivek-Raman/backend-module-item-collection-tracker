package dev.vivekraman.item.collection.tracker.repository;

import dev.vivekraman.item.collection.tracker.entity.Operation;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface OperationRepository extends ReactiveCrudRepository<Operation, String> {
  Flux<Operation> findByIdentifier(String identifier);
}
