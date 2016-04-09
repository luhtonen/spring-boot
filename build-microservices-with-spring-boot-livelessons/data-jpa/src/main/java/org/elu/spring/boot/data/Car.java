package org.elu.spring.boot.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/** Created by luhtonen on 09/04/16. */
@Entity
public class Car {

  @Id
  @GeneratedValue
  private long id;

  private String make;

  private String model;

  private int year;

  public Car(String make, String model, int year) {
    this.make = make;
    this.model = model;
    this.year = year;
  }

  public Car() {
  }

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public int getYear() {
    return year;
  }

  @Override
  public String toString() {
    return make + " " + model + " " + year;
  }
}
