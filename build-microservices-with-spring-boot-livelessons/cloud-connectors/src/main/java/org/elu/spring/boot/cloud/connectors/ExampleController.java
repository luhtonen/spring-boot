package org.elu.spring.boot.cloud.connectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.app.ApplicationInstanceInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Created by luhtonen on 08/04/16. */
@RestController
public class ExampleController {

  private final JdbcTemplate jdbc;

  private final ApplicationInstanceInfo info;

  @Autowired
  public ExampleController(JdbcTemplate jdbc, ApplicationInstanceInfo info) {
    this.jdbc = jdbc;
    this.info = info;
  }

  @RequestMapping("/")
  public String hello() {
    return jdbc.queryForObject("select model from car where id = 1", String.class);
  }

  @RequestMapping("/cloudinfo")
  public ApplicationInstanceInfo info() {
    return info;
  }
}
