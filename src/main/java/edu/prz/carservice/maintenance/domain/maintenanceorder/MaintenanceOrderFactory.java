package edu.prz.carservice.maintenance.domain.maintenanceorder;

import edu.prz.carservice.foundation.domain.StandardFactory;
import edu.prz.carservice.maintenance.domain.maintenanceorder.MaintenanceOrderFactory.Input;
import edu.prz.carservice.shared.identity.VehicleId;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
public class MaintenanceOrderFactory implements StandardFactory<Input, MaintenanceOrder> {

  public record Input(VehicleId vehicleId, String description) {

  }

  @Override
  public MaintenanceOrder create(Input input) {
    val mo = new MaintenanceOrder();
    mo.vehicleId = input.vehicleId();
    mo.description = input.description();
    return mo;
  }

}
