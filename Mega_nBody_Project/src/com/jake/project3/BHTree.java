package com.jake.project3;

public class BHTree {
	private Body body;
	
	private Quad quad;
	
	private BHTree NW;
	private BHTree NE;
	private BHTree SW;
	private BHTree SE;
	
	public BHTree(Quad q) {
		this.quad = q;
	}
	
	public void insert(Body b) {
		if (this.body == null) {
			this.body = b;
		}
		else if (this.NW != null || this.NE != null || this.SW != null || this.SE != null) {
			this.body.plus(b);
			if (b.in(NW.quad)) NW.insert(b);
			else if (b.in(NE.quad)) NE.insert(b);
			else if (b.in(SW.quad)) SW.insert(b);
			else if (b.in(SE.quad)) SE.insert(b);
		}
		else  if (this.NW == null && this.NE == null && this.SW == null && this.SE == null){
			NW = new BHTree(quad.NW());
			NE = new BHTree(quad.NE());
			SW = new BHTree(quad.SW());
			SE = new BHTree(quad.SE());
			
			if (this.body.in(quad.NW())) NW.insert(this.body);
			else if (this.body.in(quad.NE())) NE.insert(this.body);
			else if (this.body.in(quad.SW())) SW.insert(this.body);
			else if (this.body.in(quad.SE())) SE.insert(this.body);
			
			this.insert(b);
		
		}
	}
	
	
	public void updateForce(Body b) {

		if (body == null || body == b) {
			return;
		}
		else if (this.NW == null && this.NE == null && this.SW == null && this.SE == null) {
			b.addForce(this.body);
		}
		else if (this.quad.length() / this.body.distanceTo(b) < 2.0) {
			b.addForce(this.body);
		}
		else if (this.quad.length() / this.body.distanceTo(b) >= 2.0){
			this.NW.updateForce(b);
			this.NE.updateForce(b);
			this.SW.updateForce(b);
			this.SE.updateForce(b);
		}
	}
	
	public String toString() {
		String s = this.quad.toString() + " " + this.body.toString() + " " + this.NW.toString() + " " + this.NE.toString() + " " + this.SW.toString() + " " + this.SE.toString();
		return s;
	}
}
