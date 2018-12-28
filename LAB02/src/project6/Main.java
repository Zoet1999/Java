package project6;

public class Main {
	public static void main(String[] args) {
		long t1=System.currentTimeMillis();
		
		Triangle triangle= new Triangle(1.0,1.5,1.0);	//创建三角形对象 边长为1，1.5，1
		triangle.setColor("Yellow");					//设置颜色为“Yellow”
		triangle.setFilled(true);						//设置为可填充
		System.out.println(triangle.toString());		//返回三角形三边长
		System.out.println("Area:"+triangle.getArea()+" Perimeter:"+triangle.getPerimeter()
					+"\nColor:"+triangle.getColor()+" Filled:"+triangle.isFilled());///返回三角形的周长，面积，颜色，是否填充等信息。
		long t2=System.currentTimeMillis();
		System.out.println("运行时间"+(t2-t1)+"ms");
	}
}
