package org.elu.spring.boot.data;

import org.springframework.data.repository.CrudRepository;

/** Created by luhtonen on 09/04/16. */
public interface CarRepository extends CrudRepository<Car, Long> {

  Iterable<Car> findByMakeIgnoringCase(String make);
}
