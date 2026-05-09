package edu.prz.carservice.maintenance.domain.maintenanceorder;

import edu.prz.carservice.foundation.domain.StandardFactory;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
public class MaintenanceOrderFactory implements StandardFactory<CreateMaintenanceOrderInput, MaintenanceOrder> {

  @Override
  public MaintenanceOrder create(CreateMaintenanceOrderInput input) {
    val r = new MaintenanceOrder();
    r.vehicleId = input.vehicleId();
    r.description = input.description();
    return r;
  }

}
