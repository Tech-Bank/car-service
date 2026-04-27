package edu.prz.carservice.servicing.domain.request;

import edu.prz.carservice.foundation.domain.StandardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RequestService implements StandardService<Request> {

  final RequestRepository repository;

  @Override
  public Request add(Request entity) {
    return repository.save(entity);
  }

  @Override
  public Request change(Request entity) {
    return repository.save(entity);
  }

  @Override
  public void remove(Long id) {
    repository.deleteById(id);
  }

}
