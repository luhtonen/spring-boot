package org.elu.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/** Created by luhtonen on 07/04/16. */
public class Application {
  public static void main(String[] args) throws Exception {
    ConfigurableApplicationContext ctx = new SpringApplication("/org/elu/blog/integration.xml").run(args);
    System.out.printf("Hit Enter to terminate");
    System.in.read();
    ctx.close();
  }
}
