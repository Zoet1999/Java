package project7;

public class Octagon  extends GeometricObject implements Comparable<Octagon> ,Cloneable{
	/**
	 * 八边形类，继承抽象几何类，实现Comparable ,Cloneable接口
	 * 存储了八边形的边长
	 * 可计算八边形的面积和周长
	 */
	double side;
	public Octagon() {
		/**
		 * 无参构造函数，初始化八边形的边长为1.0
		 */
		super();
		this.side = 1.0;
	}
	public Octagon(double side) {
		/**
		 * 有参构造函数，
		 * 参数为八边形边长
		 */
		super();
		this.side = side;
	}
	
	//getter and setter 
	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}
	
	
	
	@Override
	protected Object clone()  {
		/**
		 * 实现Cloneable接口的clone()，克隆原来的对象的信息给新的对象
		 */
		Octagon o=new Octagon();
		o.setColor(this.getColor());
		o.setFilled(this.isFilled());
		o.setSide(this.getSide());
		return o;
	}

	@Override
	public int compareTo(Octagon o) {
		/**
		 * 实现Comparable接口的compareTo()，与另一个对象进行比较。
		 * 相等返回0，大于返回1，小于返回-1
		 */
		if(this.side>o.getSide())
		return 1;
		else if(this.side<o.getSide())
		return -1;
		else 
		return 0;//相等返回0
	}

	@Override
	public double getArea() {
		/**
		 * 重载抽象类GeometricObject的getArea()函数，返回面积
		 */
		return (2+4*Math.sqrt(2))*side*side;
	}

	@Override
	public double getPerimeter() {
		/**
		 * 重载抽象类GeometricObject的getPerimeter()函数，返回周长
		 */
		return 8*side;
	}

}
