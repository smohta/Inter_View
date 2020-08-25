import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Scanner;

public abstract class palindrome {

	public static void main(String[] args) {
		Scanner scanString=new Scanner(new BufferedInputStream(System.in));
		String inputString=null;
	    while(!scanString.hasNext("end")){
	      inputString = scanString.nextLine();    	
		}
	    if(isPalindrome(inputString))
	    	System.out.println("The string:yaay");
	    else
	    	System.out.println("The String:Nay");
	    ListNode inputList=null;
	    if(inputString!=null){
	    	for(int i=0;i<inputString.length();i++)
	    	inputList.add(inputString.charAt(i));
	    }
	    if(isPalindrome(inputList))
	    	System.out.println("The list:yaay");
	    else
	    	System.out.println("The list:Nay");
	}
	public static boolean isPalindrome(String str)
	{
		if(str==null || str.length()==0)
		  return false;
		int length=str.length();
		for(int i=0,j=length-1;i<j;i++,j--) {
		  if(str.charAt(i)!=str.charAt(j))
			  return false;
		}
		return true;	
	}
	public static boolean isPalindrome(LinkedList<Character> list)
	{
		if(list.size()==0)
			return false;
		LinkedList ptr1=list;
		LinkedList ptr2=list;
		while(ptr2.!=null) {
			
		}
		return true;
	}
}
