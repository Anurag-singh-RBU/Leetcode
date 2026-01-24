class Solution {

    public static int[][] dp;

    public static int solve(int amount , int[] coins , int idx , int ca){

        if(idx >= coins.length) return 0;

        if(ca > amount) return 0;

        if(ca == amount) return 1;

        if(dp[idx][ca] != -1) return dp[idx][ca];

        if(coins[idx] > amount) return solve(amount , coins , idx + 1 , ca);

        int take = solve(amount , coins , idx , ca + coins[idx]);
        int skip = solve(amount , coins , idx + 1 , ca);

        return dp[idx][ca] = take + skip;
        
    }

    public int change(int amount , int[] coins) {

        dp = new int[301][5001];

        for(int i = 0 ; i < 301 ; i++){

            Arrays.fill(dp[i] , -1);

        }

        return solve(amount , coins , 0 , 0);
        
    }
}