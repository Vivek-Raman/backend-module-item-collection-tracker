package dev.vivekraman.item.collection.tracker.controller;

import dev.vivekraman.item.collection.tracker.config.Constants;
import dev.vivekraman.monolith.annotation.MonolithController;
import dev.vivekraman.monolith.model.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

@Slf4j
@MonolithController(moduleName = Constants.MODULE_NAME)
@RequiredArgsConstructor
public class TestController {
  private final Scheduler scheduler;

  @PostMapping("/asd")
  public Mono<Response<Boolean>> test(@RequestBody String body) {
    log.info("asd");
    return Mono.just(Response.of(true))
        .subscribeOn(scheduler);
  }
}
