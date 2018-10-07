package com.jake.project3;

public class Quad {
    private double xCenter = 0.0;
    private double yCenter = 0.0;
    private double quadLength = 0.0;
    
    // create a new square with the given parameters (assume it is square)
    public Quad(double xmid, double ymid, double length) {
    	this.xCenter = xmid;
    this.yCenter = ymid;
    	this.quadLength = length;
    }

    // return the length of one side of the square quadrant
    public double length() {
    		return this.quadLength;
    }

    // does quadrant contain (x, y)?
    public boolean contains(double x, double y) {
    //	if (x <= this.xCenter + (this.quadLength/2.0) && x >= this.xCenter - (this.quadLength/2.0) && y <= this.yCenter + (this.quadLength/2.0) && y >= this.yCenter - (this.quadLength/2.0)){
    	if (Math.abs(x - this.xCenter) <= this.quadLength/2 && Math.abs(y - this.yCenter) <= this.quadLength/2) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    // return a new object that represents the northwest quadrant
    public Quad NW() {
    		return new Quad(this.xCenter - (this.quadLength/4), this.yCenter + (this.quadLength/4), this.quadLength/2);
    }

    // return a new object that represents the northeast quadrant
    public Quad NE() {
		return new Quad(this.xCenter + (this.quadLength/4), this.yCenter + (this.quadLength/4), this.quadLength/2);

    }

    // return a new object that represents the southwest quadrant
    public Quad SW() {
		return new Quad(this.xCenter - (this.quadLength/4), this.yCenter - (this.quadLength/4), this.quadLength/2);

    }

    // return a new object that represents the southeast quadrant
    public Quad SE() {
		return new Quad(this.xCenter + (this.quadLength/4), this.yCenter - (this.quadLength/4), this.quadLength/2);

    }

    // draw an unfilled rectangle that represents the quadrant
    public void draw() {
    		StdDraw.show(0);
        StdDraw.setXscale(this.xCenter - this.quadLength/2, this.xCenter + this.quadLength/2);
        StdDraw.setYscale(this.yCenter - this.quadLength/2, this.yCenter + this.quadLength/2);
    }

    // return a string representation of the quadrant for debugging
    public String toString() {
    		String quadString = this.xCenter + " " + this.yCenter + " " + this.quadLength;
    		return quadString;
    }

}
