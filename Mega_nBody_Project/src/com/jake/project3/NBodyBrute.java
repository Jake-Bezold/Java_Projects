package com.jake.project3;
import java.awt.Color;

public class NBodyBrute {

    public static void main(String[] args) {
    		String filename = args[0];
    		In In = new In(filename);
    		
    		final double dt = 0.1;                     // time quantum
        int N = In.readInt();            	     // number of particles
        double radius = In.readDouble();        // radius of universe

        // turn on animation mode and rescale coordinate system
        StdDraw.show(0);
        StdDraw.setXscale(-radius, +radius);
        StdDraw.setYscale(-radius, +radius);

        // read in and initialize bodies
        Body[] bodies = new Body[N];               // array of N bodies
        for (int i = 0; i < N; i++) {
            double px   = In.readDouble();
            double py   = In.readDouble();
            double vx   = In.readDouble();
            double vy   = In.readDouble();
            double mass = In.readDouble();
            int red     = In.readInt();
            int green   = In.readInt();
            int blue    = In.readInt();
            Color color = new Color(red, green, blue);
            bodies[i]   = new Body(px, py, vx, vy, mass, color);
        }


        // simulate the universe
        for (double t = 0.0; true; t = t + dt) {

            // update the forces
            for (int i = 0; i < N; i++) {
                bodies[i].resetForce();
                for (int j = 0; j < N; j++) {
                    if (i != j) bodies[i].addForce(bodies[j]);
                }
            }

            // update the bodies
            for (int i = 0; i < N; i++) {
                bodies[i].update(dt);
            }

            // draw the bodies
            StdDraw.clear(StdDraw.BLACK);
            for (int i = 0; i < N; i++) {
                bodies[i].draw();
            }
            StdDraw.show(10);

        }
    }
}
