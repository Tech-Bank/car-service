package edu.prz.carservice.foundation.domain;

public interface StandardFactory<I, T extends BaseEntity> {

  T create(I input);
}
