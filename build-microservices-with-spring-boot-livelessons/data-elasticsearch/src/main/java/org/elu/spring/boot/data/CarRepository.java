package org.elu.spring.boot.data;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/** Created by luhtonen on 10/04/16. */
public interface CarRepository extends ElasticsearchRepository<Car, Long> {
  Iterable<Car> findByMakeIgnoringCase(String make);
}
