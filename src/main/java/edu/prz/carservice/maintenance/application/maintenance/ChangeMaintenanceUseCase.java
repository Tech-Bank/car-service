package edu.prz.carservice.maintenance.application.maintenance;

import edu.prz.carservice.maintenance.application.maintenance.MaintenanceController.ChangeMaintenanceRequest;
import edu.prz.carservice.maintenance.domain.maintenance.Maintenance;
import edu.prz.carservice.maintenance.domain.maintenance.MaintenanceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChangeMaintenanceUseCase {

  final MaintenanceRepository maintenanceRepository;

  @Transactional
  public Maintenance execute(Long id, ChangeMaintenanceRequest request) {

    val maintenance = maintenanceRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException(Maintenance.class.getName()));

    maintenance.changeDescription(request.description());

    return maintenanceRepository.save(maintenance);
  }

}
