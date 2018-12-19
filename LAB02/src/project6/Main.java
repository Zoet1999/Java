package project6;

public class Main {
	public static void main(String[] args) {
		Triangle t= new Triangle(1.0,1.5,1.0);
		t.setColor("Yellow");
		t.setFilled(true);
		System.out.println(t.toString());
		System.out.println("Area:"+t.getArea()+" Perimeter:"+t.getPerimeter()
					+"\nColor:"+t.getColor()+" Filled:"+t.isFilled());
	}
}
