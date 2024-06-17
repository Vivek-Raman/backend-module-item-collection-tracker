package dev.vivekraman.item.collection.tracker.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories(basePackages = "dev.vivekraman.item.collection.tracker.repository")
public class ItemCollectionTrackerConfig {
  @Bean
  public GroupedOpenApi moduleApiGroup() {
    return GroupedOpenApi.builder()
        .group(Constants.MODULE_NAME)
        .packagesToScan("dev.vivekraman.item.collection.tracker.controller")
        .build();
  }
}
