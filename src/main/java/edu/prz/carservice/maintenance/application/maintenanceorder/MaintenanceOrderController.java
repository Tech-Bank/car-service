package edu.prz.carservice.maintenance.application.maintenanceorder;

import edu.prz.carservice.maintenance.domain.maintenanceorder.MaintenanceOrder;
import edu.prz.carservice.maintenance.domain.maintenanceorder.MaintenanceOrderRepository;
import edu.prz.carservice.shared.identity.VehicleId;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "maintenance / maintenance-orders", description = "Maintenance orders")
@RequestMapping("/api/maintenance/maintenance-orders")
@RequiredArgsConstructor
public class MaintenanceOrderController {

  final MaintenanceOrderRepository maintenanceOrderRepository;
  final AddMaintenanceOrderUseCase addMaintenanceOrderUseCase;
  final ChangeMaintenanceOrderUseCase changeMaintenanceOrderUseCase;

  public record AddMaintenanceOrderRequest(@NotNull VehicleId vehicleId, @NotBlank String description) {

  }

  public record ChangeMaintenanceOrderRequest(@NotBlank String description) {

  }

  @PostMapping
  public ResponseEntity<MaintenanceOrder> add(
      @RequestBody @Valid final AddMaintenanceOrderRequest request) {

    return ResponseEntity.ok(addMaintenanceOrderUseCase.execute(request));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<MaintenanceOrder> change(
      @PathVariable final Long id,
      @RequestBody @Valid final ChangeMaintenanceOrderRequest request) {

    return ResponseEntity.ok(changeMaintenanceOrderUseCase.execute(id, request));
  }

  @GetMapping
  public ResponseEntity<Page<MaintenanceOrder>> getAll(Pageable pageable) {

    return ResponseEntity.ok(maintenanceOrderRepository.findAll(pageable));
  }

}
