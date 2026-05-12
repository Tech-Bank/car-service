package edu.prz.carservice.maintenance.domain.maintenance;

import edu.prz.carservice.foundation.domain.BaseEntity;
import edu.prz.carservice.shared.identity.EmployeeId;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = "maintenance", callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class MaintenanceTask extends BaseEntity {

  @ManyToOne(optional = false, fetch = FetchType.EAGER)
  @JoinColumn(name = "maintenance_id", referencedColumnName = "id", nullable = false)
  Maintenance maintenance;

  String description;

  LocalDateTime startedAt;
  LocalDateTime finishedAt;

  @AttributeOverride(name = "id", column = @Column(name = "employee_id"))
  EmployeeId employeeId;
}
