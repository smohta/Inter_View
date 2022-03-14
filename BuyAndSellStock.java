/*You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
*/
 /*TEST CASES
 1.if prices is null or empty array or number of transactions=0
 2.test case with multiple selling options
 k=3
 prices={1,3,5,2,4,6,8}

 k=2
 prices={1,3,5,2,4,6,8}

 2. test case where it's better to not buy today
 k=2
 prices={1,6,5,4,3,2,1}


  */

package DynamicProgramming;

public class BuyAndSellStock {
    static int[] prices;
    int[][][] memo;
    public int maxProfit(int k, int[] prices) {
        if(prices==null||prices.length==0||k==0)
            return 0;
        this.prices=prices;
        this.memo=new int[prices.length][k+1][2];
        return getStateValue(0,k,0);
    }
    //holding:1: have a stock
    //holding:0: do not have a stock
    public int getStateValue(int i, int transactionsRemaining, int holding){
        if(i==this.prices.length||transactionsRemaining==0)
            return 0;
        if(memo[i][transactionsRemaining][holding]==0)
        {
            int doNothing=getStateValue(i+1,transactionsRemaining,holding);
            int doSomething=0;
            if(holding==1)
                doSomething=this.prices[i]+getStateValue(i+1,transactionsRemaining-1,0);//sell a stock
            else
                doSomething=-this.prices[i]+getStateValue(i+1,transactionsRemaining,1);//buy a stock
            memo[i][transactionsRemaining][holding]=Math.max(doNothing,doSomething);
        }
        return memo[i][transactionsRemaining][holding];
    }
    public static void main(String args[]){
        BuyAndSellStock stock=new BuyAndSellStock();
        System.out.println(stock.maxProfit(3, new int[]{1,3,5,2,4,6,8}));
    }
}

