class Solution {

    public static int[][][] dp;
    static int MOD = (int) 1e9 + 7;

    public static int solve(int n , int CoA , int CoL){

        if(CoA > 1 || CoL > 2) return 0;

        if(n == 0) return 1;

        if(dp[n][CoA][CoL] != -1) return dp[n][CoA][CoL];

        int A = solve(n - 1 , CoA + 1 , 0);
        int L = solve(n - 1 , CoA , CoL + 1) % MOD;
        int P = solve(n - 1 , CoA , 0);

        return dp[n][CoA][CoL] = ((A + L) % MOD + P) % MOD;

    }

    public int checkRecord(int n) {

        dp = new int[n + 1][2][3];

        for(int i = 0 ; i < n + 1 ; i++){

            for(int j = 0 ; j < 2 ; j++){

                Arrays.fill(dp[i][j] , -1);

            }

        }

        return solve(n , 0 , 0);

    }
}