//Jake Bezold and Paul Giordano
package com.jake.project1;

public class NBody {
 
	
/*creates the animation by, first calculating all the values of the planets, then drawing
 * the background and finally drawing the planets, looping over and over to animate the 
 * planets depending on whatever txt file is given in the arguments.
 */
 public static void main(String[] args) {
	 double uniRad = 0.0;
     int numPlanets = 0;
	 double T = Double.parseDouble(args[0]) ;
     double dt = Double.parseDouble(args[1]);
     String filename = args[2];
     
     In in = new In(filename) ;
     numPlanets = in.readInt() ;
     double[] xForce = new double[numPlanets];
	 double[] yForce = new double[numPlanets];
     Planet[] planets = new Planet[numPlanets];
     uniRad = readRadius(filename);
     planets = readPlanets(filename);
     
     StdDraw.setScale(-uniRad, uniRad);
     StdDraw.picture(0, 0, "./images/starfield.jpg");
     Planet[] bodies = NBody.readPlanets(args[2]);
         
     
     for(double t = 0.0; t < T; t += dt) {       
   
    	 	for(int i = 0;i < planets.length; i++) {
    	 		xForce[i] = planets[i].calcNetForceExertedByX(planets);
    	 		yForce[i] = planets[i].calcNetForceExertedByY(planets);
    	 	}
    
    	 	for(int i = 0; i < planets.length; i++) {
    	 		planets[i].update(dt, xForce[i], yForce[i]);
    	 	}
 
    	 	StdDraw.picture(0, 0, "./images/starfield.jpg");
    	 	for (Planet p : planets) {
    	 		p.draw();
    	 	}
    	 	StdDraw.show(15);
     }
     
     StdOut.printf ("%d\n", bodies.length);
        StdOut.printf ("%.2e\n",uniRad);
         for (int i = 0; i < bodies.length; i++) {
         StdOut . printf ("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n" 
           ,bodies[i].getXPos() 
           ,bodies[i].getYPos() 
           ,bodies[i].getXVel() 
           ,bodies[i].getYVel() 
           ,bodies[i].getMass() 
           ,bodies[i].getImgFileName() ) ;
         }
         
 }
 
 //............................................
 
 //reads the radius of the universe from the txt file in the arguments
 public static double readRadius(String filename) {
 	double radius = 0.0;
 	
 		In in = new In(filename); 
 		
 		in.readInt();
     radius = in.readDouble();
 		
     	return radius;
 	}
 
 //............................................
 
 // reads the planet info from the given txt file in the arguments
 public static Planet[] readPlanets(String filename) {
 	In in = new In(filename);
 	int numPlanets = in.readInt();
 	Planet[] planets = new Planet[numPlanets];
 	in.readDouble();

 	for(int i=0; i < numPlanets; i++) {
 		planets[i] = new Planet (in.readDouble(),in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());     
     }
 	return planets;
 	}
}
 
