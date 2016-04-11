package org.elu.spring.boot.data;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

/** Created by luhtonen on 10/04/16. */
public interface CarRepository extends MongoRepository<Car, Long> {

  Iterable<Car> findByMakeIgnoringCase(String make);

  GeoResults<Car> findByPositionNear(Point p, Distance d);
}
