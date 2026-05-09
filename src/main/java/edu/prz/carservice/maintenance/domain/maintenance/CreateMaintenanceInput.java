package edu.prz.carservice.maintenance.domain.maintenance;

import edu.prz.carservice.shared.identity.MaintenanceOrderId;

public record CreateMaintenanceInput(MaintenanceOrderId maintenanceOrder, String description) {

}