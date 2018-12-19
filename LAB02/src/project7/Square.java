package project7;

public class Square extends GeometricObject implements Colorable{
	double side;
	 public Square() {
		 super();
		 side=1.0;
	 }
	public Square(double side) {
		super();
		this.side=side;
	}
	public double getSide() {
		return side;
	}
	public void setSide(double side) {
		this.side = side;
	}
	@Override
	public void howToColor() {
		System.out.println("fill with "+getColor());
	}

	@Override
	public double getArea() {
		
		return side*side;
	}

	@Override
	public double getPerimeter() {
		
		return 4*side;
	}
	
}
