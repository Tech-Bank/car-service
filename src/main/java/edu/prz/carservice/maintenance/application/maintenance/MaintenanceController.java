package edu.prz.carservice.maintenance.application.maintenance;

import edu.prz.carservice.foundation.application.BaseController;
import edu.prz.carservice.maintenance.domain.maintenance.Maintenance;
import edu.prz.carservice.maintenance.domain.maintenance.Maintenance.TaskInput;
import edu.prz.carservice.maintenance.domain.maintenance.MaintenanceRepository;
import edu.prz.carservice.maintenance.domain.maintenanceorder.MaintenanceOrderId;
import edu.prz.carservice.shared.identity.EmployeeId;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "maintenance / maintenances", description = "Maintenances")
@RequestMapping("/api/maintenance/maintenances")
@RequiredArgsConstructor
public class MaintenanceController extends BaseController {

  final MaintenanceRepository maintenanceRepository;
  final AddMaintenanceUseCase addMaintenanceUseCase;
  final ChangeMaintenanceUseCase changeMaintenanceUseCase;
  final AddMaintenanceTaskUseCase addMaintenanceTaskUseCase;

  public record AddMaintenanceRequest(MaintenanceOrderId maintenanceOrderId,
                                      @NotBlank String description) {

  }

  public record ChangeMaintenanceRequest(@NotBlank String description) {

  }

  public record AddMaintenanceTaskRequest(@NotBlank String description,
                                      EmployeeId employeeId) {

    public TaskInput toTaskInput() {
      return new TaskInput(description, employeeId);
    }
  }

  @PostMapping
  public ResponseEntity<Maintenance> add(
      @RequestBody @Valid final AddMaintenanceRequest request) {

    return ResponseEntity.ok(addMaintenanceUseCase.execute(request));
  }

  @PostMapping(_ID + "/change")
  public ResponseEntity<Maintenance> change(
      @PathVariable final Long id,
      @RequestBody @Valid final ChangeMaintenanceRequest request) {

    return ResponseEntity.ok(changeMaintenanceUseCase.execute(id, request));
  }

  @PostMapping(_ID + "/add-task")
  public ResponseEntity<Maintenance> addTask(
      @PathVariable final Long id,
      @RequestBody @Valid final AddMaintenanceTaskRequest request) {

    return ResponseEntity.ok(addMaintenanceTaskUseCase.execute(id, request));
  }

  @GetMapping
  public ResponseEntity<Page<Maintenance>> getAll(Pageable pageable) {

    return ResponseEntity.ok(maintenanceRepository.findAll(pageable));
  }

  @GetMapping(_ID)
  public ResponseEntity<Maintenance> getOne(
      @PathVariable final Long id) {

    return maintenanceRepository.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

}
