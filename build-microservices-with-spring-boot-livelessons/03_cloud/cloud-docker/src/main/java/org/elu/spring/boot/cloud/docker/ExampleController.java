package org.elu.spring.boot.cloud.docker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Created by luhtonen on 08/04/16. */
@RestController
public class ExampleController {

  @RequestMapping("/")
  public String hello() {
    return "Hello Docker World!";
  }
}
