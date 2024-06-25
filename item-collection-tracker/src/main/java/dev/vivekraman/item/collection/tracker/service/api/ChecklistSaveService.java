package dev.vivekraman.item.collection.tracker.service.api;

import dev.vivekraman.item.collection.tracker.entity.Checklist;
import reactor.core.publisher.Mono;

public interface ChecklistSaveService {
  Mono<Checklist> createNewChecklist(String identifier);
  Mono<Checklist> save(Checklist toSave);
}
