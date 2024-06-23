package dev.vivekraman.item.collection.tracker.config;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.spring.data.firestore.repository.config.EnableReactiveFirestoreRepositories;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Configuration
@EnableReactiveFirestoreRepositories(basePackages = "dev.vivekraman.item.collection.tracker.repository")
public class ItemCollectionTrackerConfig {
  @Value("${item-collection-tracker.gcp.service-account.credentials:}")
  private String firebaseCredentials;

  @Bean
  public GroupedOpenApi moduleApiGroup() {
    return GroupedOpenApi.builder()
        .group(Constants.MODULE_NAME)
        .packagesToScan("dev.vivekraman.item.collection.tracker.controller")
        .build();
  }

  @Bean
  public CredentialsProvider googleCredentials() throws IOException {
    return FixedCredentialsProvider.create(ServiceAccountCredentials.fromStream(
        new ByteArrayInputStream(firebaseCredentials.getBytes())));
  }
}