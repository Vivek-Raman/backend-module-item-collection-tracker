package dev.vivekraman.item.collection.tracker.repository.api;

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import dev.vivekraman.item.collection.tracker.entity.Checklist;
import reactor.core.publisher.Mono;

public interface ChecklistRepository extends FirestoreReactiveRepository<Checklist> {
  Mono<Checklist> findFirstByIdentifier(String identifier);
}
