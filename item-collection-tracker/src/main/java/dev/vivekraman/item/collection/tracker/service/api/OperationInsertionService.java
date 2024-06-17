package dev.vivekraman.item.collection.tracker.service.api;

import dev.vivekraman.item.collection.tracker.dto.request.OperationDTO;
import dev.vivekraman.item.collection.tracker.entity.Operation;
import reactor.core.publisher.Mono;

import java.util.List;

public interface OperationInsertionService {
  Mono<Boolean> bulkInsert(List<OperationDTO> operations);
}
