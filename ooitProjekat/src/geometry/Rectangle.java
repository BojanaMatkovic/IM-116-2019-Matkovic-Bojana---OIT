package geometry;

public class Rectangle extends Shape{
	
	private Point upperleft;
	private int width;
	private int height;
	
	
	public Rectangle() {
	
	}
	
	public Rectangle(Point upperLeft, int width, int height) {
		this.upperleft=upperLeft;
		this.width=width;
		this.height=height;
	}
	
	public Rectangle (Point upperLeft, int width, int height, boolean selected) {
		this.upperleft=upperLeft;
		this.width=width;
		this.height=height;
		this.selected=selected;
	}
	
	public boolean contains (int x, int y) {
		return (upperleft.getX() < x) && (upperleft.getX() + width > x) 
				&& (upperleft.getY()) < y && (upperleft.getY() + height > y);
	}
	
	
	@Override
	public String toString() {
		return "upperleft=" + upperleft + ", width=" + width + ", height=" + height;
	}

	public Point getUpperleft() {
		return upperleft;
	}

	public void setUpperleft(Point upperleft) {
		this.upperleft = upperleft;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
	
	
	

}
