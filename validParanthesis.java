import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class validParanthesis {
  public static void main(String[] args) {
    Scanner scanString=new Scanner(new BufferedInputStream(System.in));
	String inputString=null;
    while(!scanString.hasNext("end")){
      inputString = scanString.nextLine();    	
	}
    if(isValidParenthesis(inputString))
      System.out.println("Class over");
    else
      System.out.println("Nay");
  }
  public static boolean isValidParenthesis(String str) {
    Stack<Character> paranthesis = new Stack<Character>();
    HashMap<Character,Character> hm = new HashMap<Character, Character>();
    hm.put(')','(');
    hm.put('}','{');
    hm.put(']','[');
    for(int i=0; i<str.length(); i++) {
      char current=str.charAt(i);
      if((current=='(') || (current=='[') || (current=='{')) {
        paranthesis.push(current);
      }
      else if((current==')') || (current==']') || (current=='}')) {
        if(paranthesis.isEmpty() || paranthesis.pop()!=hm.get(current))
          return false;
      }
    }
    if(!paranthesis.isEmpty())
      return false;
    else
      return true;
  }
}