import java.math.BigDecimal;

public class Design_Classes {
	public static void main(String[] args) {
		rectangle();
		times();
	}
	public static void times() {
		/**
		 * ����time�ಢ�����
		 */
		Times t1= new Times(555550000 );
		System.out.println(t1.getHour()+":"+t1.getMinute()+":"+t1.getSecond());  
		Times t2= new Times( );
		System.out.println(t2.getHour()+":"+t2.getMinute()+":"+t2.getSecond());  
	}
	public static void rectangle() {
		/**
		 * ����Rectangle�ಢ�����
		 */
		Rectangle r1=new Rectangle(4,40);	//��������
		Rectangle r2=new Rectangle(3.5,35.9);
		Rectangle.setColor("red");			//������ɫ
		System.out.println("R1: Height:"+r1.getHeight()+" Width:"+r1.getWidth()
		+" Color:"+Rectangle.getColor()+" Area:"+r1.getArea()+" Perimeter:"+r1.getPerimeter());
		System.out.println("R2: Height:"+r2.getHeight()+" Width:"+r2.getWidth()
		+" Color:"+Rectangle.getColor()+" Area:"+r2.getArea()+" Perimeter:"+r2.getPerimeter());		
		
	}
}



class Rectangle{
	/**
	 * ������
	 */
	private double width;				//��
	private double height;				//��
	private static String color="white";//������ɫ
	public Rectangle(){
		/**
		 * �޲ι��캯��
		 * ��ʼ�����
		 */
		width=1;
		height=1;	
	}
	public Rectangle(double width,double height){
		/**
		 * ���캯��
		 * ���ÿ��
		 * @param width  ���ÿ��
		 * @param height ���ø߶�
		 */
		this.width=width;
		this.height=height;
	}
	
	//--------------------------------------------------------
	//getter�� setter
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public static String getColor() {
		return color;
	}
	public static void setColor(String color) {
		Rectangle.color = color;
	}
	
	//----------------------------------------------------------
	public double getArea(){
		/**
		 * �õ����
		 * Area=height*width
		 * ʹ��BigDecimal��Ϊ�˷�ֹdouble���ʧȥ��׼�ȵ�����
		 * @return double �������
		 */
		BigDecimal h= BigDecimal.valueOf(height);
		BigDecimal w= BigDecimal.valueOf(width);
		return h.multiply(w).doubleValue();
	}
	public double getPerimeter(){
		/**
		 * �õ��ܳ�
		 * Perimeter=2*(height+width)
		 * return double �����ܳ�
		 */
		return 2*(height+width);
	}
}

class Times{
	/**
	 * ʱ����
	 */
	private int hour;//Сʱ
	private int minute;//����
	private int second;//��
	public Times() {
		/**
		 * �޲ι��캯��
		 * ��ʼ��ʱ��Ϊ��ǰ����
		 */
		double ms= System.currentTimeMillis();//���ڵĺ�����
		double h=ms/(1000*60*60)%24;//���ʱ��Сʱ
		double m=ms%(1000*60*60)/(1000*60);//���ʱ�����
		double s=ms%(1000*60*60)%(1000*60)/1000;//���ʱ����
		this.hour= (int)(h+8)%24;//��8��Ϊ�˸�Ϊ�й�ʱ��
		this.minute=(int)m;
		this.second=(int)s;
	}
	public Times(int ms) {
		/**
		 * �вι��캯��
		 * �Ѵ���ĺ�����תΪСʱ�����ӣ���
		 * @param ms ����
		 */
		this.hour=ms/(1000*60*60)%24;
		this.minute=ms%(1000*60*60)/(1000*60);
		this.second=ms%(1000*60*60)%(1000*60)/1000;
	}
	
	//getter 
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public int getSecond() {
		return second;
	}
}
