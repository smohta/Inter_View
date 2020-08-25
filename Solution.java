
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("715K 2009-09-23 system.sip~\n179K 2013-08-14 to-do-list.xml~"));
	}
	public static String solution(String S)
	{
		String[] listOfFiles=S.split(Character.toString(10));
		int minSize=255;
		for (String temp:listOfFiles)
			{
				String[] fileDetails=temp.split(" ");
				int currSize=0;
				if(checkFileSize(fileDetails[0])&&checkDate(fileDetails[1])&&isBackupFile(fileDetails[2]))
					currSize=getFileNameSize(fileDetails[2]);
				if(minSize>currSize)
					minSize=currSize;
			}
		if(minSize==0)
			return ("NO FILES");
		else
			return (Integer.toString(minSize));
	
	}
	public static boolean checkFileSize(String S)
	{
		String fileSize=S.trim();
		String byteType=fileSize.substring(fileSize.length() - 1);
		String numberOfBytes=fileSize.substring(0,fileSize.length() - 1);
		if(((byteType.equals("M"))&&(Integer.parseInt(numberOfBytes)<14))||(byteType.contentEquals("K")))
			return true;
		return false;
	}
	public static boolean checkDate(String S)
	{
		String[] dateValues=S.split("-");
		int year=Integer.parseInt(dateValues[0]);
		int month=Integer.parseInt(dateValues[1]);
		int day=Integer.parseInt(dateValues[2]);
		if(year<1990)
			return false;
		else if (year>1990)
			return true;
		else
			{
				if(month>1)
					return true;
				else
					return false;
			}	
	}
	public static boolean isBackupFile(String S)
	{
		if(S.substring(S.length() - 1).contentEquals("~"))
			return true;
		return false;
	}
	public static int getFileNameSize(String S)
	{
		int dot=S.lastIndexOf('.');
		String fileName=S.substring(0, dot);
		System.out.println(fileName);
		return fileName.length();
	}
}
