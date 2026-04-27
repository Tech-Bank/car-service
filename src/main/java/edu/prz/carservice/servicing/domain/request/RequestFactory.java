package edu.prz.carservice.servicing.domain.request;

import edu.prz.carservice.foundation.domain.StandardFactory;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
public class RequestFactory implements StandardFactory<CreateRequestInput, Request> {

  @Override
  public Request create(CreateRequestInput input) {
    val r = new Request();
    r.vehicleId = input.vehicleId();
    r.description = input.description();
    return r;
  }

}
