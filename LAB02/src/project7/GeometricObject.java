package project7;


public abstract class GeometricObject {
	/**
	 * 抽象几何类
	 * 拥有表示颜色与是否填充的数据
	 */
  private String color;					//颜色
  private boolean filled;				//是否填充
  protected GeometricObject() {
	  /**
		 * 无参构造函数
		 * 默认为颜色“white”，不填充
		 */
	    color="white";
	    filled=false;
  }
  protected GeometricObject(String color, boolean filled) {
	  /**
	   * 有参构造函数
	   * String color   颜色
	   * boolean filled 是否填充
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
	   * 返回表示颜色和是否填充的字符串
	   */
	  return "color: " + color + " and filled: " + filled;
  }

  public abstract double getArea();//得到面积的抽象函数

  public abstract double getPerimeter();//得到周长的抽象函数
}
