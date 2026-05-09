package edu.prz.carservice.maintenance.domain.maintenance;

import edu.prz.carservice.foundation.domain.StandardFactory;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
public class MaintenanceFactory implements StandardFactory<CreateMaintenanceInput, Maintenance> {

  @Override
  public Maintenance create(CreateMaintenanceInput input) {
    val m = new Maintenance();
    m.maintenanceOrder = input.maintenanceOrder();
    m.description = input.description();
    return m;
  }

}