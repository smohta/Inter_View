/*Leetcode#121
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Test Cases:
1. all increaing slope
2. all decreasing slope
3. increasing and decreasing
[1,2,3,4,3]
4. increasing and decreasing slight and then again increasing
[1,2,3,4,3,5,6,9]
*/
package DynamicProgramming;

public class StockMarket {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1)
            return 0;
        int maxProfit=0;
        int buyPrice=prices[0];
        for(int i=1;i<prices.length;i++){
            buyPrice=Math.min(prices[i],buyPrice);
            maxProfit=Math.max(maxProfit,prices[i]-buyPrice);
        }
        return maxProfit;
    }
    public static void main(String args[]){
        StockMarket stock=new StockMarket();
        int[] prices=new int[]{1,2,3,4,3,5,6,9};
        System.out.println(stock.maxProfit(prices));
    }
}
