package dev.vivekraman.item.collection.tracker.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.vivekraman.item.collection.tracker.dto.request.OperationDTO;
import dev.vivekraman.item.collection.tracker.entity.Operation;
import dev.vivekraman.item.collection.tracker.repository.OperationRepository;
import dev.vivekraman.item.collection.tracker.service.api.OperationInsertionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationInsertionServiceImpl implements OperationInsertionService {
  private final OperationRepository operationRepository;
  private final ObjectMapper objectMapper;

  @Override
  public Mono<Boolean> bulkInsert(List<OperationDTO> operations) {
    List<Operation> toSave = this.objectMapper.convertValue(operations, new TypeReference<List<Operation>>() {});
    return this.operationRepository.saveAll(toSave).collectList()
        .map(result -> true);
  }
}
