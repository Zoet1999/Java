package project6;

public class Main {
	public static void main(String[] args) {
		long t1=System.currentTimeMillis();
		
		Triangle triangle= new Triangle(1.0,1.5,1.0);	//���������ζ��� �߳�Ϊ1��1.5��1
		triangle.setColor("Yellow");					//������ɫΪ��Yellow��
		triangle.setFilled(true);						//����Ϊ�����
		System.out.println(triangle.toString());		//�������������߳�
		System.out.println("Area:"+triangle.getArea()+" Perimeter:"+triangle.getPerimeter()
					+"\nColor:"+triangle.getColor()+" Filled:"+triangle.isFilled());///���������ε��ܳ����������ɫ���Ƿ�������Ϣ��
		long t2=System.currentTimeMillis();
		System.out.println("����ʱ��"+(t2-t1)+"ms");
	}
}
