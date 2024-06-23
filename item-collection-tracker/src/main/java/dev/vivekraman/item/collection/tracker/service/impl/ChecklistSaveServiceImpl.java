package dev.vivekraman.item.collection.tracker.service.impl;

import com.google.cloud.Timestamp;
import dev.vivekraman.item.collection.tracker.entity.Checklist;
import dev.vivekraman.item.collection.tracker.repository.ChecklistRepository;
import dev.vivekraman.item.collection.tracker.service.api.ChecklistSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ChecklistSaveServiceImpl implements ChecklistSaveService {
  private final ChecklistRepository checklistRepository;

  @Override
  public Mono<Checklist> save(Checklist toSave) {
    return this.save(toSave, new Date());
  }

  @Override
  public Mono<Checklist> save(Checklist toSave, Date updatedOn) {
    toSave.setUpdatedOn(Timestamp.of(updatedOn));
    return checklistRepository.save(toSave);
  }
}
