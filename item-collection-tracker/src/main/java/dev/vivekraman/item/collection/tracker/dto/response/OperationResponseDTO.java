package dev.vivekraman.item.collection.tracker.dto.response;

import dev.vivekraman.item.collection.tracker.model.OperationType;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OperationResponseDTO implements Serializable {
  @Serial
  private static final long serialVersionUID = -7434675681200650458L;

  private OperationType type;
  private String itemCode;
  private String identifier;
}
