package edu.prz.carservice.servicing.application.request;

import edu.prz.carservice.servicing.application.request.RequestController.AddRequestReq;
import edu.prz.carservice.servicing.domain.request.CreateRequestInput;
import edu.prz.carservice.servicing.domain.request.Request;
import edu.prz.carservice.servicing.domain.request.RequestFactory;
import edu.prz.carservice.servicing.domain.request.RequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddRequestUseCase {

  final RequestFactory requestFactory;
  final RequestRepository requestRepository;

  @Transactional
  public Request addRequest(AddRequestReq request) {

    val entity = requestFactory.create(
        new CreateRequestInput(request.vehicleId(), request.description()));

    return requestRepository.save(entity);
  }

}
