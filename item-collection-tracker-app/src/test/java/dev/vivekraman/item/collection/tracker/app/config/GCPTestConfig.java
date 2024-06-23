package dev.vivekraman.item.collection.tracker.app.config;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.io.IOException;

@TestConfiguration
public class GCPTestConfig {

  @Bean
  @Primary
  public CredentialsProvider googleCredentials() throws IOException {
    return NoCredentialsProvider.create();
  }
}
