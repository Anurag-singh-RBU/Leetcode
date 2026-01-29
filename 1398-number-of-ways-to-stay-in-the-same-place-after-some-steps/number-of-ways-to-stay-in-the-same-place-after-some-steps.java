class Solution {

    public static final int MOD = (int) 1e9 + 7;
    static int dp[][];

    public static int solve(int steps , int len , int idx){

        if(idx < 0 || idx >= len) return 0;

        if(steps == 0) return idx == 0 ? 1 : 0;

        if(dp[idx][steps] != -1) return dp[idx][steps];

        int ans = solve(steps - 1 , len , idx - 1) % MOD;
        ans = (ans + solve(steps - 1 , len , idx))% MOD;
        ans = (ans + solve(steps - 1 , len , idx + 1)) % MOD;

        return dp[idx][steps] = ans % MOD;

    }

    public int numWays(int steps, int arrLen) {

        dp = new int[501][501];

        for(int i = 0 ; i < 501 ; i++){

            Arrays.fill(dp[i] , -1);

        }
        
        return solve(steps , arrLen , 0);

    }
}