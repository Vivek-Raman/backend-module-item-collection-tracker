package dev.vivekraman.item.collection.tracker.service.api;

import dev.vivekraman.item.collection.tracker.entity.Checklist;
import reactor.core.publisher.Mono;

import java.util.Date;

public interface ChecklistSaveService {
  Mono<Checklist> save(Checklist toSave);
  Mono<Checklist> save(Checklist toSave, Date updatedOn);
}
