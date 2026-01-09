class Solution {

    static final int MOD = (int) 1e9 + 7;
    static int[] dp;

    public static int solve(int len , int low , int high , int zero , int one){

        int ans = 0;

        if(len > high) return 0;

        if(len >= low && len <= high) ans = 1;

        if(dp[len] != -1) return dp[len];

        ans = (ans + solve(len + zero , low , high , zero , one)) % MOD;
        ans = (ans + solve(len + one , low , high , zero , one)) % MOD;

        return dp[len] = ans % MOD;

    }

    public int countGoodStrings(int low, int high, int zero, int one) {

        dp = new int[high + 1];

        Arrays.fill(dp , -1);

        return solve(0 , low , high , zero , one);
        
    }
}