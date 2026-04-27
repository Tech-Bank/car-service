package edu.prz.carservice.servicing.domain.request;

import edu.prz.carservice.shared.identity.VehicleId;

public record CreateRequestInput(VehicleId vehicleId, String description) {

}
