package edu.prz.carservice.maintenance.domain.maintenanceorder;

import edu.prz.carservice.shared.identity.VehicleId;

public record CreateMaintenanceOrderInput(VehicleId vehicleId, String description) {

}
