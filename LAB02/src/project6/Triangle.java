package project6;

public class Triangle extends  GeometricObject{
	/**
	 * �������࣬�̳��ڼ�����
	 * ���������ε����߳�������
	 * ����������������ܳ�
	 */
	private double side1;//���������ߵ�����
	private double side2;
	private double side3;
	
	public Triangle() {
		/*
		 * �޲ι��캯��
		 * ��ʼ������������Ϊ1.0
		 */
		super();
		side1=1.0;
		side2=1.0;
		side3=1.0;
	}
	public Triangle(double side1,double side2,double side3) {
		/**
		 * �вι��캯��
		 * ����Ϊ�����ε����߳���
		 */
		super();
		this.side1=side1;
		this.side2=side2;
		this.side3=side3;
	}
	

	@Override
	public double getArea() {
		/**
		 * ���س�����GeometricObject��getArea()�������������
		 * ���ݹ�ʽ�����߳���������������
		 */
		double P=(side1+side2+side3)/2;
		 P=P*(P-side1)*(P-side2)*(P-side3);
		P=Math.sqrt(P);
		return P;
	}

	@Override
	public double getPerimeter() {
		/**
		 * ���س�����GeometricObject��getPerimeter()�����������ܳ�
		 */
		return side1+side2+side3;
	}

	@Override
	public String toString() {
		/**
		 * ������ʾ���������߳����ַ���
		 */
	    return "Tri: side1 = " + side1 + " side2 = " + side2 +  " side3 = " + side3;
	  }
}
