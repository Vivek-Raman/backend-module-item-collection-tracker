package dev.vivekraman.item.collection.tracker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.vivekraman.item.collection.tracker.config.Constants;
import dev.vivekraman.item.collection.tracker.dto.response.ChecklistDTO;
import dev.vivekraman.item.collection.tracker.service.api.ChecklistFindService;
import dev.vivekraman.monolith.annotation.MonolithController;
import dev.vivekraman.monolith.model.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

@MonolithController(moduleName = Constants.MODULE_NAME)
@RequiredArgsConstructor
public class ChecklistController {
  private final ObjectMapper objectMapper;
  private final ChecklistFindService checklistFindService;
  private final Scheduler scheduler;

  @GetMapping("/checklist")
  public Mono<Response<ChecklistDTO>> findByIdentifier(@RequestParam String identifier) {
    return checklistFindService.findByIdentifier(identifier)
        .map(checklist -> Response.of(ChecklistDTO.copy(objectMapper, checklist)))
        .subscribeOn(scheduler);
  }
}
