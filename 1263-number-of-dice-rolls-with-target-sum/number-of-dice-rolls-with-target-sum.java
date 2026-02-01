class Solution {

    static final int MOD = (int) 1e9 + 7;
    static int[][] dp;

    public static int solve(int n , int k , int target , int cv , int not){

        if(cv > target) return 0;

        if(not == n){

            return cv == target ? 1 : 0;

        };

        if(dp[not][cv] != -1) return dp[not][cv];

        int ans = 0;

        for(int i = 1 ; i <= k ; i++){

            ans = (ans + solve(n , k , target , cv + i , not + 1)) % MOD;

        }

        return dp[not][cv] = ans;

    }

    public int numRollsToTarget(int n, int k, int target) {

        dp = new int[31][1001];

        for(int i = 0 ; i < 31 ; i++){

            Arrays.fill(dp[i] , -1);

        }

        return solve(n , k , target , 0 , 0);

    }
}