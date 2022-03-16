/* Leetcode 91
A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The test cases are generated so that the answer fits in a 32-bit integer.

Constraints:
s contains only digits and may contain leading zero(s).

Test cases
1. string is null or empty
2. string is invalid:
    starts with '0':Result:0
    have more than one '0' in between like 100006: Result:0
3. multiple ways to decode
    1206: 1
    1226: 5
*/
package DynamicProgramming;
import java.util.Set;
import java.util.HashSet;

public class DecodeWays {
    Set<String> digitSet=new HashSet<String>();
    public int numDecodings_1(String s) {
        if(s==null||s.length()==0||s.charAt(0)=='0')
            return 0;
        for(int i=1;i<=26;i++)
            digitSet.add(Integer.toString(i));
        int strLen=s.length();
       int[] dp=new int[strLen+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=strLen;i++){
            if(digitSet.contains(s.substring(i-1,i)))
                dp[i]+=dp[i-1];
            if(digitSet.contains(s.substring(i-2,i)))
                dp[i]+=dp[i-2];
        }
        return dp[strLen];
    }
    /* Approach without using extra space
    We can remove the set as we just need to see if single digit is not zero and if the two digits are between 10 and 26
    We can use constant space as we just need the previous two values
    */
    public int numDecodings_2(String s) {
        if(s==null||s.length()==0||s.charAt(0)=='0')
            return 0;
        int strLen=s.length();
        int prevToPrev=1;
        int prev=1;
        for(int i=2;i<=strLen;i++){
            int curr=0;
            if(Integer.valueOf(s.substring(i-1,i))!=0)
                curr=prev;
            int twoDigit=Integer.valueOf(s.substring(i-2,i));
            if(twoDigit>=10 &&twoDigit<=26)
                curr+=prevToPrev;
            prevToPrev=prev;
            prev=curr;
        }
        return prev;
    }
    public static void main(String args[]){
        DecodeWays obj=new DecodeWays();
        String str=new String("1226");
        System.out.println(obj.numDecodings_2(str));
    }
}
