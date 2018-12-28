package project7;

public class Main {
	public static void main(String[] args) {
		//2.2.2Problem 1
		//creates an array of five GeometricObject
		long t1=System.currentTimeMillis();
		
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
		
		//For each object in the array, invoke its howToColor method if it is colorable.
		for(int i=0;i<5;i++) {
			System.out.println("Square "+i+":\n"
						+"Area:"+g[i].getArea()+"\n"
						+g[i].toString());
			if(g[i].isFilled()==true) {//如果可填充，调用howToColor（）
				System.out.println("HowToColor");
				((Square) g[i]).howToColor();
			}
			System.out.println();
		}
		
		
		//2.2.3Problem 2
		//reates an Octagon object with side value 5
		Octagon o1=new  Octagon(5);
		//displays its area and perimeter.
		System.out.println("Perimeter:"+o1.getPerimeter()+"  Area:"+o1.getArea());
		//Create a new object using the clone method 
		Octagon o2=(Octagon)o1.clone();
		//compare the two objects using the compareTo method.
		System.out.println("the result of o1 compareTo o2: "+o1.compareTo(o2));
		long t2=System.currentTimeMillis();
		System.out.println("运行时间"+(t2-t1)+"ms");

	}
}

