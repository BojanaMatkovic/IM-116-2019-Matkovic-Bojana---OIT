package geometry;

public class Donut extends Circle {
	
	private int innerR;
	
	public Donut() {
		
	}
	
	public Donut(Point center, int r,  int innerR) {
		super(center,r);
		this.innerR=innerR;
	}

	public int getInnerR() {
		return innerR;
	}
	
	@Override
	public boolean contains (int x, int y) {
		return super.contains(x,y) && super.getCenter().distance(x,y) >=innerR;
	}
	
	@Override
	public boolean contains(Point p) {
		return this.contains(p.getX(),p.getY());
	}

	@Override
	public String toString() {
		return "innerR=" + innerR;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut temp = (Donut) obj;
		if(temp.getInnerR()==innerR && super.equals(new Circle(temp.getCenter(),temp.getR())));
		return true;
		}
		return false;
	}
	
	@Override
	public double area() {
		return super.area() - innerR * innerR * Math.PI;
	}
	
	@Override
	public double circumference() {
		return super.circumference() + 2*innerR*Math.PI;
	}

	public void setInnerR(int innerR) {
		this.innerR = innerR;
	}
	
	
	

	
	
}
