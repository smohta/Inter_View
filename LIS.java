/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 */
/*
TEST CASES:
1. null string
2. string of length 0
3. string where longest subsequence keeps on changinG
      1,3,2,4,2,3,4,5
4. check if its returning strictly increasing subsequence
    1,4,2,5,3,3
 */
package DynamicProgramming;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class LIS{
    //Using DP
    public static int lengthOfLIS_DP(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int max=1;//min length is one
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    //Another approach, will not work if asked to print the subsequence too
    public static int lengthOfLIS(int[] nums){
        if(nums==null||nums.length==0)
            return 0;
        List<Integer> subsequence=new ArrayList<>();
        subsequence.add(nums[0]);
        for(int i=1;i<nums.length;i++) {
            int last = subsequence.size() - 1;
            if (nums[i] > subsequence.get(last))
                subsequence.add(nums[i]);
            else {
                int j = 0;
                while (j <= last && subsequence.get(j) < nums[i])
                    j++;

                subsequence.set(j, nums[i]);
            }
        }
        return subsequence.size();
    }
    public static void main(String args[]){
        int nums[]=new int[]{1,4,2,5,3,3};
        System.out.println("The length of longest increasing subsequence is: "+ lengthOfLIS(nums));
        System.out.println("The length of longest increasing subsequence is: "+ lengthOfLIS_DP(nums));
    }
}
