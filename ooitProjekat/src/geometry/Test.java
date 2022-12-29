package geometry;

public class Test {

	public static void main(String[] args) {
		
		Point p = new Point(10,5); //napravili smo objekat za klasu Point koji ima vrednost 10 i 5
		System.out.println(p.getY());
		System.out.println(p.distance(8,5));
		Point a = new Point(); //zbog ovog postoji prazan konstruktor
		a.setX(16);
		a.setY(7);
		System.out.println(p);
		
		Line l = new Line(p,a); //u zagradu stavljamo tacke koje smo prethodno definisali gore
		System.out.println(l);
		
		Circle c = new Circle(a, 6);
		Circle ce = new Circle(p,6);
		System.out.println(c);
		System.out.println(ce.equals(c));
		System.out.println("x: " + c.getCenter().getX());
		System.out.println("y: " + c.getCenter().getY());
		System.out.println("r: " + c.getR());
		
		
		
		
		Rectangle r = new Rectangle();
		r.setUpperleft(p);
		r.setWidth(7);
		r.setHeight(9);
		System.out.println(r);
		//ili
		Rectangle re = new Rectangle(a,8,9);
		System.out.println(re);
		
		Donut d = new Donut(p,6,8);
		System.out.println(d);
		System.out.println(c.equals(d));
		System.out.println("innerR: " + d.getInnerR());
		
		Circle cc = new Circle();
		System.out.println(cc.getCenter());
		
		
		
		
		
		
	}

}
