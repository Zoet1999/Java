package project7;

public class Octagon  extends GeometricObject implements Comparable<Octagon> ,Cloneable{
	/**
	 * �˱����࣬�̳г��󼸺��࣬ʵ��Comparable ,Cloneable�ӿ�
	 * �洢�˰˱��εı߳�
	 * �ɼ���˱��ε�������ܳ�
	 */
	double side;
	public Octagon() {
		/**
		 * �޲ι��캯������ʼ���˱��εı߳�Ϊ1.0
		 */
		super();
		this.side = 1.0;
	}
	public Octagon(double side) {
		/**
		 * �вι��캯����
		 * ����Ϊ�˱��α߳�
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
		 * ʵ��Cloneable�ӿڵ�clone()����¡ԭ���Ķ������Ϣ���µĶ���
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
		 * ʵ��Comparable�ӿڵ�compareTo()������һ��������бȽϡ�
		 * ��ȷ���0�����ڷ���1��С�ڷ���-1
		 */
		if(this.side>o.getSide())
		return 1;
		else if(this.side<o.getSide())
		return -1;
		else 
		return 0;//��ȷ���0
	}

	@Override
	public double getArea() {
		/**
		 * ���س�����GeometricObject��getArea()�������������
		 */
		return (2+4*Math.sqrt(2))*side*side;
	}

	@Override
	public double getPerimeter() {
		/**
		 * ���س�����GeometricObject��getPerimeter()�����������ܳ�
		 */
		return 8*side;
	}

}
