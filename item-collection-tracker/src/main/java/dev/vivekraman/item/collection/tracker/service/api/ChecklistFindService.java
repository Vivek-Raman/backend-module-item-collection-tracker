package dev.vivekraman.item.collection.tracker.service.api;

import dev.vivekraman.item.collection.tracker.entity.Checklist;
import reactor.core.publisher.Mono;

public interface ChecklistFindService {
  Mono<Checklist> findByIdentifier(String identifier);
}
