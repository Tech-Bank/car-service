package edu.prz.carservice.maintenance.domain.maintenance;

import edu.prz.carservice.foundation.domain.BaseEntity;
import edu.prz.carservice.shared.identity.MaintenanceOrderId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Maintenance extends BaseEntity {

  @AttributeOverride(name = "id", column = @Column(name = "maintenance_order_id"))
  MaintenanceOrderId maintenanceOrder;

  String description;

}