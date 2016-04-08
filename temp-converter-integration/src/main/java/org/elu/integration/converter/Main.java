package org.elu.integration.converter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** Created by luhtonen on 07/04/16. */
public class Main {
  public static void main(String[] args) throws Exception {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
    // Simple Service
    TempConverter converter = ctx.getBean("simpleGateway", TempConverter.class);
    System.out.println("#### simple service: " + converter.fahrenheitToCelcius(68.0f));

    // Web Service
    converter = ctx.getBean("wsGateway", TempConverter.class);
    System.out.println("#### ws service:  " + converter.fahrenheitToCelcius(68.0f));
  }
}
