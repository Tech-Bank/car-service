package edu.prz.carservice.servicing.domain.request;

import edu.prz.carservice.foundation.domain.BaseEntity;
import edu.prz.carservice.shared.identity.VehicleId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Request extends BaseEntity {

  @AttributeOverride(name = "id", column = @Column(name = "vehicle_id"))
  VehicleId vehicleId;

  String description;

}
