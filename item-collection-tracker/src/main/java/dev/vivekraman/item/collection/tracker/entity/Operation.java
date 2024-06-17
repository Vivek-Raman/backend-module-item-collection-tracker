package dev.vivekraman.item.collection.tracker.entity;

import dev.vivekraman.item.collection.tracker.model.OperationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ict_operation")
public class Operation implements Serializable {
  @Serial
  private static final long serialVersionUID = -3776272155216448941L;

  @Id
  private String id;
  private OperationType type;
  private String itemCode;
  private String identifier;
}
