package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	
	// Obelezja
	
	private int innerRadius;
	
	// Konstruktori
	
	public Donut() {
		
	}
	 
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius);
		this.selected = selected;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected, Color color) {
	 	this(center, radius, innerRadius, selected);
	 	this.color = color;
	}
	    
	public Donut (Point center, int radius, int innerRadius , Color color) {
	 	this(center, radius, innerRadius);
	 	this.color = color;
	}
	    
	public Donut (Point center, int radius, int innerRadius , Color color, Color innerColor) {
	  	this(center, radius, innerRadius,color);
	  	this.innerColor = innerColor;
	}
	    
	public Donut(Point center, int radius, int innerRadius, boolean selected, Color color, Color innerColor) {
	  	this(center, radius, innerRadius, selected, color);
	  	this.innerColor = innerColor;
	}

	// Metode
	
	@Override
	public double circumference() {
		return super.circumference() + 2 * innerRadius * Math.PI;
	}
	
	@Override
	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI;
	}

	@Override
	public String toString() {
		return super.toString() + ", inner radius: " + innerRadius;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Donut) {
			Donut temp = (Donut) obj;
			if(this.center.equals(temp.getCenter()) &&
					this.radius == temp.getRadius() &&
					this.innerRadius == temp.getInnerRadius()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g); //crtanje spoljasnjeg kruga
		g.setColor(getColor());
		g.drawOval(super.center.getX()-innerRadius, super.center.getY()-innerRadius,
				innerRadius*2, innerRadius*2);
		if (isSelected()) {
        g.drawRect(this.getCenter().getX() - innerRadius - 2,this.getCenter().getY() - 2, 4, 4);
        g.drawRect(this.getCenter().getX() + innerRadius - 2,this.getCenter().getY() - 2, 4, 4);
        g.drawRect(this.getCenter().getX() - 2,this.getCenter().getY() - innerRadius - 2, 4, 4);
        g.drawRect(this.getCenter().getX() - 2,this.getCenter().getY() + innerRadius - 2, 4, 4);
		}
	}
	
    public void fill(Graphics g) {
    	g.setColor(getInnerColor());
    	super.fill(g);
    	g.setColor(Color.WHITE);
    	g.fillOval(this.getCenter().getX() - this.getInnerRadius() + 1, this.getCenter().getY() - this.getInnerRadius() + 1, this.getInnerRadius()*2 - 1, this.getInnerRadius()*2 - 1);
    }
    
	@Override
	public int compareTo(Object o) {
		if (o instanceof Donut) {
		return (int)(this.area() - ((Donut)o).area());
		}
		return 0;
	}
	
	@Override
	public boolean contains (int x, int y) {
		return super.contains(x, y) && super.getCenter().distance(x, y) >= innerRadius; 
	}
	
	@Override
	public boolean contains (Point p) {
		return this.contains(p.getX(), p.getY());
	}
	
	
	// Getters & Setters
	
	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
}
