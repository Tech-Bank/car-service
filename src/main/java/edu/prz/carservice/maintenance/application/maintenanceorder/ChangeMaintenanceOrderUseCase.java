package edu.prz.carservice.maintenance.application.maintenanceorder;

import edu.prz.carservice.maintenance.application.maintenanceorder.MaintenanceOrderController.ChangeMaintenanceOrderRequest;
import edu.prz.carservice.maintenance.domain.maintenanceorder.MaintenanceOrder;
import edu.prz.carservice.maintenance.domain.maintenanceorder.MaintenanceOrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChangeMaintenanceOrderUseCase {

  final MaintenanceOrderRepository maintenanceOrderRepository;

  @Transactional
  public MaintenanceOrder execute(Long id, ChangeMaintenanceOrderRequest request) {

    val order = maintenanceOrderRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException(MaintenanceOrder.class.getName()));

    order.changeDescription(request.description());

    return maintenanceOrderRepository.save(order);
  }

}
