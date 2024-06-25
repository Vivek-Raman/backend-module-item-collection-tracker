package dev.vivekraman.item.collection.tracker.service.api;

import dev.vivekraman.item.collection.tracker.dto.request.OperationDTO;
import dev.vivekraman.item.collection.tracker.entity.Checklist;
import reactor.core.publisher.Mono;

import java.util.List;

public interface OperationService {
  Mono<Checklist> processOperations(List<OperationDTO> operations);
}
