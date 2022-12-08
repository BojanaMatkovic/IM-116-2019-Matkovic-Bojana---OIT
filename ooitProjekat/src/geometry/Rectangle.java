package geometry;

public class Rectangle {
	
	private Point upperleft;
	private int width;
	private int height;
	private boolean selected;
	
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

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	

}
