package edu.prz.carservice.maintenance.domain.maintenance;

import edu.prz.carservice.foundation.domain.StandardFactory;
import edu.prz.carservice.maintenance.domain.maintenance.MaintenanceFactory.Input;
import edu.prz.carservice.shared.identity.MaintenanceOrderId;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
public class MaintenanceFactory implements StandardFactory<Input, Maintenance> {

  public record Input(MaintenanceOrderId maintenanceOrderId, String description) {

  }

  @Override
  public Maintenance create(Input input) {
    val m = new Maintenance();
    m.maintenanceOrderId = input.maintenanceOrderId();
    m.description = input.description();
    return m;
  }

}