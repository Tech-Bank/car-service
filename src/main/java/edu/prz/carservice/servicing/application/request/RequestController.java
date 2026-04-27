package edu.prz.carservice.servicing.application.request;

import edu.prz.carservice.servicing.domain.request.Request;
import edu.prz.carservice.servicing.domain.request.RequestRepository;
import edu.prz.carservice.shared.identity.VehicleId;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "servicing / requests", description = "Servicing requests")
@RequestMapping("/api/servicing/requests")
@RequiredArgsConstructor
public class RequestController {

  final RequestRepository requestRepository;
  final AddRequestUseCase addRequestUseCase;

  public record AddRequestReq(VehicleId vehicleId, String description) {

  }

  @PostMapping
  public ResponseEntity<Request> addRequest(@RequestBody final AddRequestReq request) {

    return ResponseEntity.ok(addRequestUseCase.addRequest(request));
  }

  @GetMapping
  public ResponseEntity<Page<Request>> getAllRequests(Pageable pageable) {

    return ResponseEntity.ok(requestRepository.findAll(pageable));
  }

}
