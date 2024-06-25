package dev.vivekraman.item.collection.tracker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.vivekraman.item.collection.tracker.config.Constants;
import dev.vivekraman.item.collection.tracker.dto.request.OperationDTO;
import dev.vivekraman.item.collection.tracker.dto.response.ChecklistDTO;
import dev.vivekraman.item.collection.tracker.service.api.OperationService;
import dev.vivekraman.monolith.annotation.MonolithController;
import dev.vivekraman.monolith.model.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

import java.util.List;

@Slf4j
@MonolithController(moduleName = Constants.MODULE_NAME)
@RequiredArgsConstructor
public class OperationController {
  private final OperationService operationService;
  private final ObjectMapper objectMapper;
  private final Scheduler scheduler;

  @PostMapping("/operations")
  public Mono<Response<ChecklistDTO>> processOperations(@RequestBody List<OperationDTO> operations) {
    return operationService.processOperations(operations)
        .map(checklist -> Response.of(ChecklistDTO.copy(objectMapper, checklist)))
        .subscribeOn(scheduler);
  }
}
