/*Leetcode 256
There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.

For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
Return the minimum cost to paint all houses.

 */
package DynamicProgramming;

import java.util.Arrays;

public class PaintHouses {
    int[][] dp;
    int[][] costs;
    public int minCost_topDown(int[][] costs) {
        if(costs==null||costs.length==0)
            return 0;
        int m=costs.length;
        int n=costs[0].length;
        this.costs=costs;
        dp=new int[m][n];
        return Math.min(getCost(0,0),Math.min(getCost(0,1),getCost(0,2)));
    }
    public int getCost(int house, int color){
        if(house==costs.length)
            return 0;
        //max cost to paint current house red
        if(dp[house][color]==0)
            dp[house][color]=costs[house][color]+Math.min(getCost(house+1,(color+1)%3),getCost(house+1,(color+2)%3));
        return dp[house][color];
    }
    //Bottom UP
    public int minCost_bottomUp(int[][] costs) {
        if(costs==null||costs.length==0)
            return 0;
        int m=costs.length;
        int[] prev_row= Arrays.copyOf(costs[0],3);
        for(int i=1;i<m;i++){
            int[] curr_row=new int[3];
            curr_row[0]=costs[i][0]+Math.min(prev_row[1],prev_row[2]);
            curr_row[1]=costs[i][1]+Math.min(prev_row[0],prev_row[2]);
            curr_row[2]=costs[i][2]+Math.min(prev_row[0],prev_row[1]);
            prev_row=curr_row;
        }
        return Math.min(prev_row[0],Math.min(prev_row[1],prev_row[2]));
    }
    //Test
    public static void main(String args[]){
        PaintHouses obj=new PaintHouses();
        int[][] costs=new int[][]{{17,2,17},{16,16,5},{14,3,19}};
        System.out.println("Bottom Up "+obj.minCost_bottomUp(costs));
        System.out.println("Top Down "+obj.minCost_bottomUp(costs));

    }
}
