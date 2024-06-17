package dev.vivekraman.item.collection.tracker.controller;

import dev.vivekraman.item.collection.tracker.config.Constants;
import dev.vivekraman.item.collection.tracker.dto.request.OperationDTO;
import dev.vivekraman.item.collection.tracker.service.api.OperationInsertionService;
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
public class TrackerPushController {
  private final OperationInsertionService operationInsertionService;
  private final Scheduler scheduler;

  @PostMapping
  public Mono<Response<Boolean>> bulkInsert(@RequestBody List<OperationDTO> operations) {
    return operationInsertionService.bulkInsert(operations)
        .map(Response::of)
        .subscribeOn(scheduler);
  }
}
