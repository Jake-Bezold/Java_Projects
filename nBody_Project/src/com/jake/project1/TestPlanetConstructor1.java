package com.jake.project1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *  Tests the Planet constructor.
 */
public class TestPlanetConstructor1 {

    @Test
    public void checkConstructor() {
      System.out.println("Checking Planet constructor...");

      double xPos = 1.0, yPos = 2.0, xVel = 3.0, yVel = 4.0, mass = 5.0;

      String img = "jupiter.gif";

      Planet p = new Planet(xPos, yPos, xVel, yVel, mass, img);

      assertEquals("xxPos = 1.0", xPos, p.getXPos(),0.001);
      assertEquals("yyPos = 2.0", yPos, p.getYPos(),0.001);
      assertEquals("xxVel = 3.0", xVel, p.getXVel(),0.001);
      assertEquals("yyVel = 4.0", yVel, p.getYVel(),0.001);
      assertEquals("mass = 5.0", mass, p.getMass(),0.001);
      assertEquals(img, img, p.getImgFileName());
  }
}