package org.elu.spring.boot.cloud.session;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Created by luhtonen on 08/04/16. */
@RestController
public class ExampleController {

  @RequestMapping("/")
  public String hello(HttpSession session) {
    UUID uid = (UUID) session.getAttribute("uid");
    if (uid == null) {
      uid = UUID.randomUUID();
    }
    session.setAttribute("uid", uid);
    return uid.toString();
  }
}
