package edu.prz.carservice.foundation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class CreationInfo {

  @Column(name = "creation_user_id")
  private Long userId;
  @Column(name = "creation_time")
  private LocalDateTime time;
}
