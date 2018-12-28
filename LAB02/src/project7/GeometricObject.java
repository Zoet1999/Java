package project7;


public abstract class GeometricObject {
	/**
	 * ���󼸺���
	 * ӵ�б�ʾ��ɫ���Ƿ���������
	 */
  private String color;					//��ɫ
  private boolean filled;				//�Ƿ����
  protected GeometricObject() {
	  /**
		 * �޲ι��캯��
		 * Ĭ��Ϊ��ɫ��white���������
		 */
	    color="white";
	    filled=false;
  }
  protected GeometricObject(String color, boolean filled) {
	  /**
	   * �вι��캯��
	   * String color   ��ɫ
	   * boolean filled �Ƿ����
	   */
	this.color = color;
	this.filled = filled;
  }
  
//getter and setter
  public String getColor() {	
	return color;
  }
  public void setColor(String color) {
   this.color = color;
  }
  public boolean isFilled() {
   return filled;
  }
  public void setFilled(boolean filled) {
	this.filled = filled;
  }
  
  
  public String toString() {
	  /**
	   * ���ر�ʾ��ɫ���Ƿ������ַ���
	   */
	  return "color: " + color + " and filled: " + filled;
  }

  public abstract double getArea();//�õ�����ĳ�����

  public abstract double getPerimeter();//�õ��ܳ��ĳ�����
}
