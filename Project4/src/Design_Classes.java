import java.math.BigDecimal;

public class Design_Classes {
	public static void main(String[] args) {
			times();
	
	}
	public static void times() {
		Times t= new Times(555550000 );
		System.out.println(t.getHour()+":"+t.getMinute()+":"+t.getSecond());
	}
	public static void rectangle() {
		Rectangle r1=new Rectangle(4,40);
		Rectangle r2=new Rectangle(3.5,35.9);
		Rectangle.setColor("red");
		System.out.println("R1: Height:"+r1.getHeight()+" Width:"+r1.getWidth()
		+" Color:"+Rectangle.getColor()+" Area:"+r1.getArea()+" Perimeter:"+r1.getPerimeter());
		System.out.println("R2: Height:"+r2.getHeight()+" Width:"+r2.getWidth()
		+" Color:"+Rectangle.getColor()+" Area:"+r2.getArea()+" Perimeter:"+r2.getPerimeter());		

	}
}



class Rectangle{
	private double width;
	private double height;
	private static String color="white";
	public Rectangle(){
		width=1;
		height=1;	
	}
	public Rectangle(double width,double height){
		this.width=width;
		this.height=height;
	}
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
	public double getArea(){
		BigDecimal h= BigDecimal.valueOf(height);
		BigDecimal w= BigDecimal.valueOf(width);
		return h.multiply(w).doubleValue();
	}
	public double getPerimeter(){
		return 2*(height+width);
	}
}

class Times{
	private int hour;
	
	private int minute;
	private int second;
	public Times() {
		hour=0;
		minute=0;
		second=0;
	}
	public Times(int mm) {
		this.hour=mm/(1000*60*60)%24;
		this.minute=mm%(1000*60*60)/(1000*60);
		this.second=mm%(1000*60*60)%(1000*60)/1000;
	}
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
