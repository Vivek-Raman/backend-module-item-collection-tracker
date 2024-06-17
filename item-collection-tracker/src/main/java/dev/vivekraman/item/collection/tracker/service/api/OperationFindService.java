package dev.vivekraman.item.collection.tracker.service.api;

import dev.vivekraman.item.collection.tracker.dto.response.OperationResponseDTO;
import reactor.core.publisher.Mono;

import java.util.List;

public interface OperationFindService {
  Mono<List<OperationResponseDTO>> findByIdentifier(String identifier);
}
