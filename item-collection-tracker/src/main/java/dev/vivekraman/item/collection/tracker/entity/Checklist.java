package dev.vivekraman.item.collection.tracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;
import com.google.cloud.spring.data.firestore.mapping.UpdateTime;
import lombok.*;

import java.util.Date;
import java.util.Map;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collectionName = "ict_checklist")
public class Checklist {
  @UpdateTime(version = true) private Timestamp updatedOn;
  @DocumentId private String identifier;
  private Map<String, CollectionInfo> collection;

  @Data
  @Builder
  @ToString
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class CollectionInfo {
    private Date collectedOn;
  }
}
