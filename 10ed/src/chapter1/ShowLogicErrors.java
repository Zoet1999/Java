package chapter1;

/*
 * 华氏度(℉)=32+摄氏度(℃)×1.8
 * 摄氏度(℃)=(华氏度(℉)-32)÷1.8
 */
public class ShowLogicErrors {
  public static void main(String[] args) {
    System.out.println("Celsius 35 is Fahrenheit degree ");
    System.out.println((9 / 5) * 35 + 32); //should use double
  }
}
