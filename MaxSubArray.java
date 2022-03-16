/*Leetcode 53
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

TEST CASES:
1. where least negative is better answer
[-5,-4,-3]
2. Include all negative in between
[4,5,8,-2,-6,9]
*/
package DynamicProgramming;

public class MaxSubArray {

    public int maxSubArray_Brute(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int currSum=0;
            for(int j=i;j<nums.length;j++){
                currSum+=nums[j];
                maxSum=Math.max(maxSum,currSum);
            }
        }
        return maxSum;
    }
    //dp approach
    public int maxSubArray_DP(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int maxSum=nums[0];
        int currSum=nums[0];
        for(int i=1;i<nums.length;i++){
            currSum=Math.max(nums[i],currSum+nums[i]);
            maxSum=Math.max(maxSum,currSum);
        }
        return maxSum;
    }
    public static void main(String args[]){
        MaxSubArray obj=new MaxSubArray();
        int[] nums=new int[]{4,5,8,-2,-6,9};
        System.out.println(obj.maxSubArray_DP(nums));
    }
}
