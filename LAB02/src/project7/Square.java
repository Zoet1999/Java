package project7;

import java.math.BigDecimal;

public class Square extends GeometricObject implements Colorable{
	/**
	 * 正方形类，继承抽象几何类，实现Colorable接口
	 * 存储了正方形的边长
	 * 实现了HowToColor函数
	 * 可计算正方形的面积和周长
	 */
	double side;
	 public Square() {
		 /**
		  * 无参构造函数，初始化边长为1.0
		  */
		 super();
		 side=1.0;
	 }
	public Square(double side) {
		/**
		 * 有参构造函数
		 * 参数为正方形的边长
		 */
		super();
		this.side=side;
	}
	
	//getter and setter
	public double getSide() {
		return side;
	}
	public void setSide(double side) {
		this.side = side;
	}
	
	
	@Override
	public void howToColor() {
		/**
		 * 实现Colorable接口的howToColor()，打印填充的颜色
		 */
		System.out.println("fill with "+getColor());
	}

	@Override
	public double getArea() {
		/**
		 * 重载抽象类GeometricObject的getArea()函数，返回面积
		 */
		BigDecimal s= BigDecimal.valueOf(side);
		return  s.multiply(s).doubleValue();
	}

	@Override
	public double getPerimeter() {
		/**
		 * 重载抽象类GeometricObject的getPerimeter()函数，返回周长
		 */
		return 4*side;
	}
	
}
