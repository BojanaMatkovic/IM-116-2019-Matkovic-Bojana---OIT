package geometry;

public class Line {
	
	//obelezja
	
	private Point startPoint;
	private Point endPoint;
	private boolean selected;
	
	//konstruktori
	
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint=startPoint;
		this.endPoint=endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this.startPoint=startPoint;
		this.endPoint=endPoint;
		this.selected=selected;
	}

	
	
	@Override
	public String toString() {
		return "startPoint=" + startPoint + ", endPoint=" + endPoint ;
	}
	
	

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
	
	

}
