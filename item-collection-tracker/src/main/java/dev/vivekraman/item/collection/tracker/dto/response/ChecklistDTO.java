package dev.vivekraman.item.collection.tracker.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.vivekraman.item.collection.tracker.entity.Checklist;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

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
  private Map<String, CollectionInfoDTO> collection;
  private Date lastUpdatedOn;

  public static ChecklistDTO copy(ObjectMapper objectMapper, Checklist checklist) {
    ChecklistDTO checklistDTO = objectMapper.convertValue(checklist, ChecklistDTO.class);
    checklistDTO.setLastUpdatedOn(checklist.getUpdatedOn().toDate());
    return checklistDTO;
  }

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
