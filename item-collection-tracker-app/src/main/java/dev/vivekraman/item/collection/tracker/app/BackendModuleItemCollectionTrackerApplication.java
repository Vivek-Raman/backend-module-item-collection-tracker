package dev.vivekraman.item.collection.tracker.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "dev.vivekraman.*")
public class BackendModuleItemCollectionTrackerApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendModuleItemCollectionTrackerApplication.class, args);
	}
}
