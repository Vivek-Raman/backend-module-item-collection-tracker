package dev.vivekraman.item.collection.tracker.service.impl;

import com.google.cloud.Timestamp;
import dev.vivekraman.item.collection.tracker.dto.request.OperationDTO;
import dev.vivekraman.item.collection.tracker.entity.Checklist;
import dev.vivekraman.item.collection.tracker.repository.ChecklistRepository;
import dev.vivekraman.item.collection.tracker.service.api.ChecklistSaveService;
import dev.vivekraman.item.collection.tracker.service.api.OperationInsertionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.*;

@Service
@RequiredArgsConstructor
public class OperationInsertionServiceImpl implements OperationInsertionService {
  private final ChecklistSaveService checklistSaveService;

  @Override
  public Mono<Checklist> bulkInsert(List<OperationDTO> operationRequests) {
    Date now = new Date();
    SortedMap<String, Checklist.CollectionInfo> map = new TreeMap<>();
    operationRequests.forEach(op -> {
      Checklist.CollectionInfo collectionInfo = Checklist.CollectionInfo.builder()
          .collectedOn(now).build();
      map.put(op.getItemCode(), collectionInfo);
    });
    return checklistSaveService.save(Checklist.builder()
        .identifier("asd")
        .collection(map)
        .build());
  }
}
