import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class Main {  
  static private final String INPUT = "input.txt";  
  static private final String OUTPUT = "output.txt";  
  
  public static void main(String args[]) {  
      // open I/O files  
      FileInputStream instream = null;  
      PrintStream outstream = null;  
     
      try {  
          instream = new FileInputStream(INPUT);  
          outstream = new PrintStream(new FileOutputStream(OUTPUT));  
          System.setIn(instream);  
          System.setOut(outstream);  
      } catch (Exception e) {  
          System.err.println("Error Occurred.");  
      }  
     
      Scanner in = new Scanner(System.in);  
      for (;in.hasNext();) {  
          int x = in.nextInt();  
          System.out.println(x);  
      }  
     
      System.err.println("done.");  
      return;  
  }  
  
} 