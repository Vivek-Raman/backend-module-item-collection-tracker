package dev.vivekraman.item.collection.tracker.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.vivekraman.item.collection.tracker.model.OperationType;
import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class OperationDTO {
  private OperationType type;
  private String itemCode;
  private String identifier;
  private Date collectedOn;
}
