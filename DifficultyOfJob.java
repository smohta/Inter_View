package DynamicProgramming;

import java.util.Arrays;

public class DifficultyOfJob {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty==null||d>jobDifficulty.length)
            return -1;
        int n=jobDifficulty.length;
        //dp[i][j] represent the min job difficulty for completing jobs starting at index i in d-j+1 days
        int dp[][]=new int[n][d+1];
        for (int[] row: dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int hardest=Integer.MIN_VALUE;
        dp[n-1][d]=jobDifficulty[n-1];
        for(int i=n-2;i>=0;i--){
            dp[i][d]= Math.max(dp[i+1][d],jobDifficulty[i]);
        }
        for(int day=d-1;day>0;day--){
            for(int i=day-1;i<=n-1-(d-day);i++){
                hardest=0;
                for(int k=i;k<=n-1-(d-day);k++){
                    hardest=Math.max(hardest,jobDifficulty[k]);
                    dp[i][day]=Math.min(dp[k+1][day+1]+hardest,dp[i][day]);
                }
            }
        }
        return dp[0][1];
    }
    public static void main(String args[]){
        DifficultyOfJob job=new DifficultyOfJob();
        System.out.println(job.minDifficulty(new int[]{2,3,4,3,2},4));
    }
}


