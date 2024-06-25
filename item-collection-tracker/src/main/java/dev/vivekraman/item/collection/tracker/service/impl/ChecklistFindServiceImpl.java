package dev.vivekraman.item.collection.tracker.service.impl;

import dev.vivekraman.item.collection.tracker.entity.Checklist;
import dev.vivekraman.item.collection.tracker.repository.api.ChecklistRepository;
import dev.vivekraman.item.collection.tracker.service.api.ChecklistFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ChecklistFindServiceImpl implements ChecklistFindService {
  private final ChecklistRepository checklistRepository;

  @Override
  public Mono<Checklist> findByIdentifier(String identifier) {
    return checklistRepository.findFirstByIdentifier(identifier);
  }
}
