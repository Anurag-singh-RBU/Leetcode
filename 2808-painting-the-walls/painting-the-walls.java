class Solution {

    public static int[][] dp;

    public static int solve(int idx , int RW , int[] cost , int[] time){

        if(RW <= 0) return 0;

        if(idx >= cost.length) return Integer.MAX_VALUE;

        if(dp[idx][RW] != -1) return dp[idx][RW];

        int take = solve(idx + 1 , RW - 1 - time[idx] , cost , time);

        if(take != Integer.MAX_VALUE){

            take = take + cost[idx];

        }

        int skip = solve(idx + 1 , RW , cost , time);

        return dp[idx][RW] = Math.min(take , skip);

    }

    public int paintWalls(int[] cost, int[] time) {

        dp = new int[501][501];

        for(int i = 0 ; i < 501 ; i++){

            Arrays.fill(dp[i] , -1);

        }

        return solve(0 , cost.length , cost , time);
        
    }
}