package dev.vivekraman.item.collection.tracker.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.cloud.Timestamp;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.SortedMap;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChecklistDTO implements Serializable {
  @Serial
  private static final long serialVersionUID = 6797350723621588547L;

  private String identifier;
  private SortedMap<String, CollectionInfoDTO> collection;
  @JsonIgnore private Date updatedOn;

  @Data
  @Builder
  @ToString
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class CollectionInfoDTO {
    private Date collectedOn;
  }
}
