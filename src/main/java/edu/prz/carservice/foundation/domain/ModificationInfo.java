package edu.prz.carservice.foundation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class ModificationInfo {

  @Column(name = "modification_user_id")
  private Long userId;
  @Column(name = "modification_time")
  private LocalDateTime time;
}
