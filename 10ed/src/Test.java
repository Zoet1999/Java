public class Test {
  public static void main(String[] args) {
    int x; // x has no default value
    String y; // y has no default value
    System.out.println("x is " + x); 
    System.out.println("y is " + y); 
    
    // Get current date and time
    java.util.Date date = new java.util.Date();
    
    // Displays a string like:
		// Sun Mar 09 13:50:19 EST 2003
    System.out.println(date.toString());

  }
}
