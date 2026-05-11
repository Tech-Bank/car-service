package edu.prz.carservice.foundation.domain;

public abstract class DomainException extends RuntimeException {

  protected DomainException(String message) {
    super(message);
  }
}