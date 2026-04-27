package edu.prz.carservice.foundation.domain;

public interface StandardService<T extends BaseEntity> {

  T add(T entity);

  T change(T entity);

  void remove(Long id);
}
