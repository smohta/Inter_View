import java.io.BufferedInputStream;
import java.util.Scanner;
public class rotateArray {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner scanString=new Scanner(new BufferedInputStream(System.in));
		System.out.println("Enter the string to rotate");
		String inputString=null;
		while(!scanString.hasNext("end")){
			inputString=scanString.nextLine();
		}
		if(inputString==null){ 
			return;
		}
		int rotateAt=6;
		inputString=reverseInPlace(inputString,0,rotateAt-1);
		inputString=reverseInPlace(inputString,rotateAt,inputString.length()-1);
		inputString=reverseInPlace(inputString,0,inputString.length()-1);
		System.out.println("Rotated string="+inputString);
	}
	public static String reverseInPlace(String a, int startIndex, int endIndex)
	{
		int i=startIndex;
		int j=endIndex;
		char tempArray[]=a.toCharArray();
		while(i<j)
		{
			char temp=tempArray[i];
			tempArray[i]=tempArray[j];
			tempArray[j]=temp;
			i++;
			j--;
		}
		return String.valueOf(tempArray);
	}
}
