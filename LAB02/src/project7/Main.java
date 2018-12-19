package project7;

public class Main {
	public static void main(String[] args) {
		GeometricObject[] g= {new Square(1.2),new Square(2.2),new Square(3.4),new Square(1.9),new Square(1.0)};
		g[0].setFilled(false);
		g[1].setFilled(true);
		g[2].setFilled(false);
		g[3].setFilled(true);
		g[4].setFilled(false);
		g[0].setColor("red");
		g[1].setColor("yellow");
		g[2].setColor("blue");
		g[3].setColor("green");
		g[4].setColor("black");
		
		for(int i=0;i<5;i++) {
			System.out.println("Square "+i+":\n"
						+"Area:"+g[i].getArea()+"\n"
						+g[i].toString());
			if(g[i].isFilled()==true) {
				((Square) g[i]).howToColor();
			}
			System.out.println();
		}
		
		Octagon o1=new  Octagon(5);
		System.out.println("Perimeter:"+o1.getPerimeter()+"  Area:"+o1.getArea());
		Octagon o2=(Octagon)o1.clone();
		o1.compareTo(o2);
		System.out.println("the result of o1 compareTo o2: "+o1.compareTo(o2));
	}
}

