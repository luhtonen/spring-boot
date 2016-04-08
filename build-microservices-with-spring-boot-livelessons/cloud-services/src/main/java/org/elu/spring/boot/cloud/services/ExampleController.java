package org.elu.spring.boot.cloud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Created by luhtonen on 08/04/16. */
@RestController
public class ExampleController {

  private final JdbcTemplate jdbc;

  @Autowired
  public ExampleController(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  @RequestMapping("/")
  public String hello() {
    return jdbc.queryForObject("select model from car where id = 1", String.class);
  }
}