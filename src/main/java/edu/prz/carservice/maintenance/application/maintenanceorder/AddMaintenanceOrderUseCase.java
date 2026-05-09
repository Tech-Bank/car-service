package edu.prz.carservice.maintenance.application.maintenanceorder;

import edu.prz.carservice.maintenance.application.maintenanceorder.MaintenanceOrderController.AddMaintenanceOrderRequest;
import edu.prz.carservice.maintenance.domain.maintenanceorder.CreateMaintenanceOrderInput;
import edu.prz.carservice.maintenance.domain.maintenanceorder.MaintenanceOrder;
import edu.prz.carservice.maintenance.domain.maintenanceorder.MaintenanceOrderFactory;
import edu.prz.carservice.maintenance.domain.maintenanceorder.MaintenanceOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddMaintenanceOrderUseCase {

  final MaintenanceOrderFactory maintenanceOrderFactory;
  final MaintenanceOrderRepository maintenanceOrderRepository;

  @Transactional
  public MaintenanceOrder execute(AddMaintenanceOrderRequest request) {

    val entity = maintenanceOrderFactory.create(
        new CreateMaintenanceOrderInput(request.vehicleId(), request.description()));

    return maintenanceOrderRepository.save(entity);
  }

}
