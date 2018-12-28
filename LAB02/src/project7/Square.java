package project7;

import java.math.BigDecimal;

public class Square extends GeometricObject implements Colorable{
	/**
	 * �������࣬�̳г��󼸺��࣬ʵ��Colorable�ӿ�
	 * �洢�������εı߳�
	 * ʵ����HowToColor����
	 * �ɼ��������ε�������ܳ�
	 */
	double side;
	 public Square() {
		 /**
		  * �޲ι��캯������ʼ���߳�Ϊ1.0
		  */
		 super();
		 side=1.0;
	 }
	public Square(double side) {
		/**
		 * �вι��캯��
		 * ����Ϊ�����εı߳�
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
		 * ʵ��Colorable�ӿڵ�howToColor()����ӡ������ɫ
		 */
		System.out.println("fill with "+getColor());
	}

	@Override
	public double getArea() {
		/**
		 * ���س�����GeometricObject��getArea()�������������
		 */
		BigDecimal s= BigDecimal.valueOf(side);
		return  s.multiply(s).doubleValue();
	}

	@Override
	public double getPerimeter() {
		/**
		 * ���س�����GeometricObject��getPerimeter()�����������ܳ�
		 */
		return 4*side;
	}
	
}
