package edu.prz.carservice.maintenance.domain.maintenance;

import edu.prz.carservice.foundation.domain.BaseEntity;
import edu.prz.carservice.maintenance.domain.maintenanceorder.MaintenanceOrderId;
import edu.prz.carservice.shared.identity.EmployeeId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Maintenance extends BaseEntity {

  public record TaskInput(@NotBlank String description,
                          EmployeeId employeeId) {

  }

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

  @OneToMany(mappedBy = "maintenance", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
  List<MaintenanceTask> tasks;

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

  public void addTask(TaskInput input) {
    this.tasks.add(MaintenanceTask.builder()
        .maintenance(this)
        .description(input.description)
        .employeeId(input.employeeId)
        .build());
  }

}