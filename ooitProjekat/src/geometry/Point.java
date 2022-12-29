package geometry;

public class Point extends Shape{
	//obelezja
	private int x;
	private int y;
	
	
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
	//toString sluzi za reprezentaciju nekog objekta
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
	
	//proveravamo da li neki objekat sadrzi neke koordinate, potrebno je da ima neke argumente
	//gledamo razdaljinu izmedju tacke i koordinata, da bude manja od 2
	
	public boolean contains (int x, int y) {
		return this.distance(x, y)<=2; //this - nad ovom metodom pozovi mi distance kojoj prosledjujemo vr x i y
	}
	
	public boolean contains (Point p) {
		return this.contains(p.getX(), p.getY());
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


	
	

}
