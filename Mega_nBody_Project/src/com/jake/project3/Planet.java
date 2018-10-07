//Jake Bezold and Paul Giordano
package com.jake.project3;

	public class Planet {
		private double xPos = 0.0;
		private double yPos = 0.0; 
		private double xVel = 0.0;
		private double yVel = 0.0;
		private double Mass = 0.0;
		private String img = "";

//.........................................

		//creates set and get methods for all the variables listed above
	public void setXPos(double setxPos) {
		xPos = setxPos;
	}

//..........................................
	
	public double getXPos() {
		return xPos;
	}
	
//.........................................
	
	public void setYPos(double setyPos) {
		yPos = setyPos;
	}
	
//.........................................
	
	public double getYPos() {
		return yPos;
	}
//.........................................
	
	public void setXVel(double setxVel) {
		xVel = setxVel;
	}

//..........................................
	
	public double getXVel() {
		return xVel;
	}

//..........................................	
	
	public void setYVel(double setyVel) {
		yVel = setyVel;
	}
	
//..........................................
	
	public double getYVel() {
		return yVel;
	}
	
//...........................................
	
	public void setMass(double setMass) {
		Mass = setMass;
	}

//...........................................
	
	public double getMass() {
		return Mass;
	}
	
//.............................................
	
	public void setImg(String setImg) {
		img = setImg;
	}
	
//............................................
	
	public String getImgFileName() {
		return img;
	}
	
//..............................................
	
	//creates the Planet type
	public Planet (double xPos, double yPos, double xVel, double yVel, double mass, String img){
			this.xPos = xPos;
			this.yPos = yPos;
			this.xVel = xVel;
			this.yVel = yVel;
			this.Mass = mass;
			this.img = img;
				
			}
	
//...............................................	
	
	//calculates distance between to planets
	public double calcDistance(Planet p2) {
		double distance, xDistance, yDistance = 0.0;
		double xP2 = p2.getXPos();
		double yP2 = p2.getYPos();
		
		xDistance = (xP2 - this.xPos);
		yDistance = (yP2 - this.yPos);
		
		distance =  Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
		
		return distance;
	}
	
//...............................................
	
	//calculates the force exerted between two different objects with mass and a distance between
	public double calcForceExertedBy(Planet p2) {
		double forceExerted, p2Mass = 0.0;
		double G = 6.67e-11;
		
		p2Mass = p2.getMass();
		
		forceExerted = G*((this.Mass*p2Mass)/(calcDistance(p2)*calcDistance(p2)));
		
		return forceExerted;
	}
	
//..............................................
	
	//calculates force on current planet by p2 in the x direction
	public double calcForceExertedByX(Planet p2 ) {
		double forceExertedByX = 0.0;
		double xP2 = p2.getXPos();
		double xDistance = (xP2 - this.xPos);
		
		forceExertedByX = (calcForceExertedBy(p2) * xDistance)/calcDistance(p2);
		
		return forceExertedByX;
	}
	
//..............................................	
	
	//calculates force on current planet by p2 in the y direction
	public double calcForceExertedByY(Planet p2 ) {
		double forceExertedByY = 0.0;
		double yP2 = p2.getYPos();
		double yDistance = (yP2 - this.yPos);
		
		forceExertedByY = (calcForceExertedBy(p2) * yDistance)/calcDistance(p2);
		
		return forceExertedByY;
	}
	
//..............................................
	
	//calculates the netforce in the x direction, which in this case, makes sure that the planet isn't casuing a force upon itself
	public double calcNetForceExertedByX(Planet[] planetArray) {
		double netForceExertedByX = 0.0;

			for (int i =0; i < planetArray.length; i++) {
				if (!(planetArray[i].equals(this))) {
					 netForceExertedByX += this.calcForceExertedByX(planetArray[i]);
				}
			}
		return netForceExertedByX;
	}
	
//..............................................
	
	
	public double calcNetForceExertedByY(Planet[] planetArray) {
		double netForceExertedByY = 0.0;

			for (int i =0; i < planetArray.length; i++) {
				if (!(planetArray[i].equals(this))) {
					netForceExertedByY += this.calcForceExertedByY(planetArray[i]);

				}
			}
			
		return netForceExertedByY;
	}
	
//...................................................
	
	
	//updates the current values of the planet
	public void update(double seconds, double xForce, double yForce) {
		double accelX = 0.0, accelY = 0.0;
		
		accelX = xForce/ Mass;
		accelY = yForce/ Mass;
		
		xVel = (xVel + (accelX * seconds));
		yVel = (yVel + (accelY * seconds));
		
		xPos = (xPos + (xVel* seconds));
		yPos = (yPos + (yVel* seconds));
		
		this.setXPos(xPos);
		this.setYPos(yPos);
		this.setXVel(xVel);
		this.setYVel(yVel);
		 
	}
	
//...................................................
	
	//draw method that draws the planets
	public void draw() {
	      StdDraw.picture(getXPos(), getYPos(),"./images/" + getImgFileName());

	  }
	
//..................................................
	
	public static void main(String[] args) {
		
	}
}