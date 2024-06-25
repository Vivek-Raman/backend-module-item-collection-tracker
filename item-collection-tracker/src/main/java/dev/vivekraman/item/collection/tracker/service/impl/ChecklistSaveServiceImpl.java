package dev.vivekraman.item.collection.tracker.service.impl;

import dev.vivekraman.item.collection.tracker.entity.Checklist;
import dev.vivekraman.item.collection.tracker.repository.api.ChecklistRepository;
import dev.vivekraman.item.collection.tracker.service.api.ChecklistSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.LinkedHashMap;

@Service
@RequiredArgsConstructor
public class ChecklistSaveServiceImpl implements ChecklistSaveService {
  private final ChecklistRepository checklistRepository;

  @Override
  public Mono<Checklist> createNewChecklist(String identifier) {
    return checklistRepository.save(Checklist.builder()
        .identifier(identifier)
        .collection(new LinkedHashMap<>())
        .build());
  }

  @Override
  public Mono<Checklist> save(Checklist toSave) {
    return checklistRepository.save(toSave);
  }
}
