package edu.prz.carservice.maintenance.domain.maintenanceorder;

import com.fasterxml.jackson.annotation.JsonValue;
import edu.prz.carservice.foundation.domain.Identity;
import jakarta.persistence.Embeddable;

@Embeddable
public record MaintenanceOrderId(@JsonValue Long id) implements Identity {

}