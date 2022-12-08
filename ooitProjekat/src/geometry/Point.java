package geometry;

public class Point {
	//obelezja
	private int x;
	private int y;
	private boolean selected;
	
	//konstruktori - sluze za kreiranje objekata neke klase
	
	public Point() { //prazan konstruktor kako bi kasnije mogli da setujemo neke vrednosti
		
	}
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public Point(int x, int y, boolean selected) {
		this.x=x;
		this.y=y;
		this.selected=selected;
	}
	
	@Override
	//toString sluzi 
	public String toString() {
		return "(" + x + ", " + y + ")";
				
	}
	
	
	//izracunati razmak izmedju dve tacke po formuli
	
	public double distance(int x, int y) {
		int dx = this.x-x;
		int dy = this.y-y;
		double d = Math.sqrt(dx*dx+dy*dy);
		return d;
	}
	
	public int getX() { 
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	

}
