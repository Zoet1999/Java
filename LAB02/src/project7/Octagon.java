package project7;

public class Octagon  extends GeometricObject implements Comparable<Octagon> ,Cloneable{

	double side;
	public Octagon() {
		super();
		this.side = 1.0;
	}
	public Octagon(double side) {
		super();
		this.side = side;
	}
	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}
	
	@Override
	protected Object clone()  {
		Octagon o=new Octagon();
		o.setColor(this.getColor());
		o.setFilled(this.isFilled());
		o.setSide(this.getSide());
		return o;
	}

	@Override
	public int compareTo(Octagon o) {
		if(this.side>o.getSide())
		return 1;
		else if(this.side<o.getSide())
		return -1;
		else 
		return 0;
	}

	@Override
	public double getArea() {
		return (2+4*Math.sqrt(2))*side*side;
	}

	@Override
	public double getPerimeter() {
		return 8*side;
	}

}
