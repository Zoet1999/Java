package project6;

public class Triangle extends  GeometricObject{
	/**
	 * 三角形类，继承于几何类
	 * 保存三角形的三边长的数据
	 * 计算三角形面积与周长
	 */
	private double side1;//三角形三边的数据
	private double side2;
	private double side3;
	
	public Triangle() {
		/*
		 * 无参构造函数
		 * 初始化三角形三边为1.0
		 */
		super();
		side1=1.0;
		side2=1.0;
		side3=1.0;
	}
	public Triangle(double side1,double side2,double side3) {
		/**
		 * 有参构造函数
		 * 参数为三角形的三边长度
		 */
		super();
		this.side1=side1;
		this.side2=side2;
		this.side3=side3;
	}
	

	@Override
	public double getArea() {
		/**
		 * 重载抽象类GeometricObject的getArea()函数，返回面积
		 * 根据公式和三边长计算出三角形面积
		 */
		double P=(side1+side2+side3)/2;
		 P=P*(P-side1)*(P-side2)*(P-side3);
		P=Math.sqrt(P);
		return P;
	}

	@Override
	public double getPerimeter() {
		/**
		 * 重载抽象类GeometricObject的getPerimeter()函数，返回周长
		 */
		return side1+side2+side3;
	}

	@Override
	public String toString() {
		/**
		 * 返回显示三角形三边长的字符串
		 */
	    return "Tri: side1 = " + side1 + " side2 = " + side2 +  " side3 = " + side3;
	  }
}
