import java.math.BigDecimal;

public class Design_Classes {
	public static void main(String[] args) {
		rectangle();
		times();
	}
	public static void times() {
		/**
		 * 创建time类并且输出
		 */
		Times t1= new Times(555550000 );
		System.out.println(t1.getHour()+":"+t1.getMinute()+":"+t1.getSecond());  
		Times t2= new Times( );
		System.out.println(t2.getHour()+":"+t2.getMinute()+":"+t2.getSecond());  
	}
	public static void rectangle() {
		/**
		 * 创建Rectangle类并且输出
		 */
		Rectangle r1=new Rectangle(4,40);	//创建对象
		Rectangle r2=new Rectangle(3.5,35.9);
		Rectangle.setColor("red");			//设置颜色
		System.out.println("R1: Height:"+r1.getHeight()+" Width:"+r1.getWidth()
		+" Color:"+Rectangle.getColor()+" Area:"+r1.getArea()+" Perimeter:"+r1.getPerimeter());
		System.out.println("R2: Height:"+r2.getHeight()+" Width:"+r2.getWidth()
		+" Color:"+Rectangle.getColor()+" Area:"+r2.getArea()+" Perimeter:"+r2.getPerimeter());		
		
	}
}



class Rectangle{
	/**
	 * 矩形类
	 */
	private double width;				//宽
	private double height;				//高
	private static String color="white";//保存颜色
	public Rectangle(){
		/**
		 * 无参构造函数
		 * 初始化宽高
		 */
		width=1;
		height=1;	
	}
	public Rectangle(double width,double height){
		/**
		 * 构造函数
		 * 设置宽高
		 * @param width  设置宽度
		 * @param height 设置高度
		 */
		this.width=width;
		this.height=height;
	}
	
	//--------------------------------------------------------
	//getter和 setter
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
		 * 得到面积
		 * Area=height*width
		 * 使用BigDecimal是为了防止double相乘失去精准度的问题
		 * @return double 矩形面积
		 */
		BigDecimal h= BigDecimal.valueOf(height);
		BigDecimal w= BigDecimal.valueOf(width);
		return h.multiply(w).doubleValue();
	}
	public double getPerimeter(){
		/**
		 * 得到周长
		 * Perimeter=2*(height+width)
		 * return double 矩形周长
		 */
		return 2*(height+width);
	}
}

class Times{
	/**
	 * 时间类
	 */
	private int hour;//小时
	private int minute;//分钟
	private int second;//秒
	public Times() {
		/**
		 * 无参构造函数
		 * 初始化时间为当前属性
		 */
		double ms= System.currentTimeMillis();//现在的毫秒数
		double h=ms/(1000*60*60)%24;//算出时间小时
		double m=ms%(1000*60*60)/(1000*60);//算出时间分钟
		double s=ms%(1000*60*60)%(1000*60)/1000;//算出时间秒
		this.hour= (int)(h+8)%24;//加8是为了改为中国时区
		this.minute=(int)m;
		this.second=(int)s;
	}
	public Times(int ms) {
		/**
		 * 有参构造函数
		 * 把传入的毫秒数转为小时，分钟，秒
		 * @param ms 毫秒
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
