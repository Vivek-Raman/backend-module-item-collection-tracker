package dev.vivekraman.item.collection.tracker.service.impl;

import dev.vivekraman.item.collection.tracker.dto.request.OperationDTO;
import dev.vivekraman.item.collection.tracker.entity.Checklist;
import dev.vivekraman.item.collection.tracker.service.api.ChecklistFindService;
import dev.vivekraman.item.collection.tracker.service.api.ChecklistSaveService;
import dev.vivekraman.item.collection.tracker.service.api.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.*;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {
  private final ChecklistFindService checklistFindService;
  private final ChecklistSaveService checklistSaveService;

  @Override
  public Mono<Checklist> processOperations(List<OperationDTO> operations) {
    return checklistFindService.findByIdentifier(operations.getFirst().getIdentifier())
        .switchIfEmpty(checklistSaveService.createNewChecklist(operations.getFirst().getIdentifier()))
        .map(checklist -> {
          operations.forEach(op -> {
            switch (op.getType()) {
              case REGISTER -> checklist.getCollection().putIfAbsent(op.getItemCode(),
                  Checklist.CollectionInfo.builder()
                      .collectedOn(op.getCollectedOn()).build());
              case UNREGISTER -> checklist.getCollection().remove(op.getItemCode());
            }
          });
          return checklist;
        }).flatMap(checklistSaveService::save);
  }
}
