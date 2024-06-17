package dev.vivekraman.item.collection.tracker.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.vivekraman.item.collection.tracker.dto.response.OperationResponseDTO;
import dev.vivekraman.item.collection.tracker.repository.OperationRepository;
import dev.vivekraman.item.collection.tracker.service.api.OperationFindService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OperationFindServiceImpl implements OperationFindService {
  private final OperationRepository operationRepository;
  private final ObjectMapper objectMapper;

  @Override
  public Mono<List<OperationResponseDTO>> findByIdentifier(String identifier) {
    return this.operationRepository.findByIdentifier(identifier).collectList()
        .map(result -> this.objectMapper.convertValue(result, new TypeReference<List<OperationResponseDTO>>() {}));
  }
}
