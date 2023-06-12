package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape1{

	// Obelezja
	
		protected Point center;
		protected int radius;
		
		// Konstruktori
		
		public Circle() { 
			
		}
		
		public Circle (Point center, int radius) {
			this.center = center;
			this.radius = radius;
		}
		
		public Circle (Point center, int radius, boolean selected) {
			this(center, radius);
			this.selected = selected;
		}
		
		   public Circle (Point center, int radius, boolean selected, Color color) {
			   this (center, radius, selected);
			   this.color = color;
		   }
		  
		   public Circle (Point center, int radius,  Color color) {
			   this (center, radius);
			   this.color = color;
		   }
		   
		   public Circle (Point center, int radius,  Color color, Color innerColor) {
			   this (center, radius, color);
			   this.innerColor = innerColor;
		   }
		   
		   public Circle (Point center, int radius, boolean selected, Color color, Color innerColor) {
			   this (center, radius, selected, color);
			   this.innerColor = innerColor;
		   }
		
		// Metode
		
		public double circumference() {
			return 2 * radius * Math.PI;
		}
		
		public double area() {
			return radius * radius * Math.PI;
		}
		
		@Override
		public String toString() {
			return "Center: " + center + ", radius: " + radius;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Circle) {
				Circle temp = (Circle) obj;
				if (this.center.equals(temp.getCenter()) 
						&& radius == temp.getRadius()) {
					return true;
				}
			}
			return false;
		}
		
		@Override
		public void draw(Graphics g) {
			g.setColor(getColor());
			g.drawOval(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
			this.fill(g);
			if (isSelected()) {
				g.setColor(getColor());
				g.drawRect(center.getX()-2, center.getY()-2, 4, 4);
				g.drawRect(center.getX()- radius -2, center.getY()-2, 4, 4);
				g.drawRect(center.getX()+ radius -2, center.getY()-2, 4, 4);
				g.drawRect(center.getX()-2, center.getY()-radius-2, 4, 4);
				g.drawRect(center.getX()-2, center.getY()+radius-2, 4, 4);
			}
		}
		
		public void fill (Graphics g) {
			g.setColor(getInnerColor());
			//dodajemo i oduzimamo 1 da se ne bi preklopilo sa ivicom
			g.fillOval(this.center.getX() - this.radius + 1, this.center.getY() - this.radius + 1, this.radius*2 - 2, this.radius*2 - 2);
		}
		
		@Override
		public void moveTo(int x, int y) {
			center.moveTo(x, y);
			
		}

		@Override
		public void moveBy(int byX, int byY) {
			center.moveBy(byX, byY);
			
		}
		
		@Override
		public int compareTo(Object o) {
			if(o instanceof Circle) {
				Circle temp = (Circle)o;
				return ((int)(this.area() - temp.area()));
			}
			return 0;
		}
		
		
		public boolean contains (int x, int y) {
			return center.distance(x, y) <= radius;
		}
		
		public boolean contains (Point p) {
			return center.distance(p.getX(), p.getY()) <= radius;
		}
		
		// Getters & Setters

		public Point getCenter() {
			return center;
		}

		public void setCenter(Point center) {
			this.center = center;
		}

		public int getRadius() {
			return radius;
		}

		public void setRadius(int radius) {
			this.radius = radius;
		}
}
