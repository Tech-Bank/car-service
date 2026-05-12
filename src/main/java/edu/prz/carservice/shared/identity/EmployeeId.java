package edu.prz.carservice.shared.identity;

import com.fasterxml.jackson.annotation.JsonValue;
import edu.prz.carservice.foundation.domain.Identity;
import jakarta.persistence.Embeddable;

@Embeddable
public record EmployeeId(@JsonValue Long id) implements Identity {

}
