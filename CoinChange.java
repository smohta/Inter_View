package DynamicProgramming;
import java.util.Arrays;
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if(coins==null||coins.length==0)
            return -1;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int coin:coins){
                int remaining=i-coin;
                if(remaining>=0&&dp[remaining]!=amount+1)
                    dp[i]=Math.min(1+dp[remaining],dp[i]);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
    public static void main(String args[]){
        int[] coins=new int[]{4,5,6};
        int amount=3;
        System.out.println("The amount can be formed from "+coinChange(coins,amount)+" coins");
    }
}
