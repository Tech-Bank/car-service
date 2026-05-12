package edu.prz.carservice.maintenance.domain.maintenance;

import edu.prz.carservice.foundation.domain.BaseEntity;
import edu.prz.carservice.maintenance.domain.maintenanceorder.MaintenanceOrderId;
import edu.prz.carservice.shared.identity.EmployeeId;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Maintenance extends BaseEntity {

  @AttributeOverride(name = "id", column = @Column(name = "maintenance_order_id"))
  MaintenanceOrderId maintenanceOrderId;

  String description;

  @Enumerated(EnumType.STRING)
  MaintenanceStatus status;

  @AttributeOverride(name = "id", column = @Column(name = "responsible_employee_id"))
  EmployeeId responsibleEmployeeId;

  LocalDateTime startedAt;
  LocalDateTime finishedAt;

  LocalDateTime plannedFinishTime;

  public void changeDescription(String description) {
    this.description = description;
  }

  public void start() {
    this.status = MaintenanceStatus.IN_PROGRESS;
    this.startedAt = LocalDateTime.now();
  }

  public void finish() {
    this.status = MaintenanceStatus.FINISHED;
    this.finishedAt = LocalDateTime.now();
  }

  public void cancel() {
    this.status = MaintenanceStatus.CANCELLED;
  }

  public void assign(EmployeeId responsibleEmployeeId) {
    this.responsibleEmployeeId = responsibleEmployeeId;
  }

}