package dev.vivekraman.item.collection.tracker.controller;

import dev.vivekraman.item.collection.tracker.config.Constants;
import dev.vivekraman.item.collection.tracker.dto.request.OperationDTO;
import dev.vivekraman.item.collection.tracker.dto.response.OperationResponseDTO;
import dev.vivekraman.item.collection.tracker.service.api.OperationFindService;
import dev.vivekraman.item.collection.tracker.service.api.OperationInsertionService;
import dev.vivekraman.monolith.annotation.MonolithController;
import dev.vivekraman.monolith.model.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

import java.util.List;

@Slf4j
@MonolithController(moduleName = Constants.MODULE_NAME)
@RequiredArgsConstructor
public class TrackerFindController {
  private final OperationFindService operationFindService;
  private final Scheduler scheduler;

  @GetMapping
  public Mono<Response<List<OperationResponseDTO>>> findByIdentifier(@RequestParam String identifier) {
    return this.operationFindService.findByIdentifier(identifier)
        .map(Response::of)
        .subscribeOn(scheduler);
  }
}
