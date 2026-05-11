package edu.prz.carservice.maintenance.application.maintenance;

import edu.prz.carservice.foundation.domain.NotExistsException;
import edu.prz.carservice.maintenance.application.maintenance.MaintenanceController.AddMaintenanceRequest;
import edu.prz.carservice.maintenance.domain.maintenance.Maintenance;
import edu.prz.carservice.maintenance.domain.maintenance.MaintenanceFactory;
import edu.prz.carservice.maintenance.domain.maintenance.MaintenanceFactory.Input;
import edu.prz.carservice.maintenance.domain.maintenance.MaintenanceRepository;
import edu.prz.carservice.maintenance.domain.maintenanceorder.MaintenanceOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddMaintenanceUseCase {

  final MaintenanceFactory maintenanceFactory;
  final MaintenanceRepository maintenanceRepository;
  final MaintenanceOrderRepository maintenanceOrderRepository;

  @Transactional
  public Maintenance execute(AddMaintenanceRequest request) {

    if (request.maintenanceOrderId() != null && !maintenanceOrderRepository.existsById(
        request.maintenanceOrderId().id())) {
      throw NotExistsException.of(
          "No maintenance order found with id: %s".formatted(request.maintenanceOrderId().id()));
    }

    val maintenance = maintenanceFactory.create(
        new Input(request.maintenanceOrderId(), request.description()));

    return maintenanceRepository.save(maintenance);
  }

}
