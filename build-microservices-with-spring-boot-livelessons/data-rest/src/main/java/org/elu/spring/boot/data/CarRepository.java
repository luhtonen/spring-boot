package org.elu.spring.boot.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

/** Created by luhtonen on 10/04/16. */
public interface CarRepository extends CrudRepository<Car, Long> {

  @RestResource(path="find")
  Iterable<Car> findByMakeIgnoringCase(@Param("make") String make);
}
