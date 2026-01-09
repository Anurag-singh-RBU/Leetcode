class Solution {

    public static long[] dp;

    public static long solve(int idx , int[][] q){

        if(idx >= q.length) return 0;

        if(dp[idx] != -1) return dp[idx];

        long take = q[idx][0] + solve(idx + q[idx][1] + 1 , q);
        long skip = solve(idx + 1 , q);

        return dp[idx] = Math.max(take , skip);

    }

    public long mostPoints(int[][] q) {

        dp = new long[q.length + 1];

        Arrays.fill(dp , -1);

        return solve(0 , q);
        
    }
}