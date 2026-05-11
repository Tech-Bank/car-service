package edu.prz.carservice.maintenance.application.maintenanceorder;

import edu.prz.carservice.maintenance.application.maintenanceorder.MaintenanceOrderController.AddMaintenanceOrderRequest;
import edu.prz.carservice.maintenance.domain.maintenanceorder.MaintenanceOrder;
import edu.prz.carservice.maintenance.domain.maintenanceorder.MaintenanceOrderFactory;
import edu.prz.carservice.maintenance.domain.maintenanceorder.MaintenanceOrderFactory.Input;
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

    val order = maintenanceOrderFactory.create(
        new Input(request.vehicleId(), request.description()));

    return maintenanceOrderRepository.save(order);
  }

}
