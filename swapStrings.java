import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

public class swapStrings {
	static String str;
	static String str1;
	public static void main(String[] args) throws IOException {
	  Scanner scanString=new Scanner(new BufferedInputStream(System.in));
	  String inputString;
	  String outputString=null;
      while(scanString.hasNextLine()){
        inputString = scanString.nextLine();
        if(inputString.equalsIgnoreCase("end"))
          break;
        else
          outputString = inputString;
      }        
		reverseWords1(outputString);
		System.out.println(reverseWords(outputString));
		
	} 
	
	public static void swap(String string1, String string2)
	{
		str=string2;
		str1=string1;
	}
	public static String reverseWords(String s) {
	        s=s.trim();
	        int i=0;
	        int j;
	        for(j=0;j<s.length();j++)
	        {
	            if(s.charAt(j)==' ')
	            {
	                s=reverse(s,i,j-1);
	                i=j+1;
	             }
	          
	        }
	        s=reverse(s,i,j-1);
	        s=reverse(s,0,s.length()-1);
	        return s;
	    }
	public static String reverse(String s, int i, int j)
	    {
	        char temp;
	        char[] tempArray=s.toCharArray();
	        while(i<j)
	        {  temp=tempArray[i];
	         tempArray[i]=tempArray[j];
	           tempArray[j]=temp;
	            i++;
	            j--;
	        }
	        return String.valueOf(tempArray);
	    } 
	public static void reverseWords1(String s)
	{
		StringBuilder sBuilder=new StringBuilder(s);
		sBuilder=sBuilder.reverse();
		StringBuilder finalStr=new StringBuilder();
		for(String str:sBuilder.toString().split(" "))
		{
			StringBuilder str1=new StringBuilder(str);
			str1=str1.reverse();
			finalStr.append(str1);
			finalStr.append(" ");
		}
		
		System.out.println(finalStr.toString().trim());
	}

}
