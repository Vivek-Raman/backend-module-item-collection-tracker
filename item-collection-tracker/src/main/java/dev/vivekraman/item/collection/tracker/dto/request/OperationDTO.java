package dev.vivekraman.item.collection.tracker.dto.request;

import dev.vivekraman.item.collection.tracker.model.OperationType;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OperationDTO {
  private OperationType type;
  private String itemCode;
  private String identifier;
}
