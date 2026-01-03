class Solution {

    static int N;
    static final int MOD = (int) 1e9 + 7;
    static int dp[];

    public static int solve(String s , int k , int idx){

        if(idx == N) return 1;

        if(s.charAt(idx) == '0') return 0;

        if(dp[idx] != -1) return dp[idx];

        int ans = 0;
        long num = 0;

        for(int end = idx ; end < N ; end++){

            num = (long) num * 10 + (s.charAt(end) - '0');

            if(num > k) break;

            ans = (ans % MOD + solve(s , k , end + 1)) % MOD;

        }

        return dp[idx] = ans % MOD;

    }

    public int numberOfArrays(String s, int k) {

        N = s.length();

        dp = new int[N + 1];

        Arrays.fill(dp , -1);

        return solve(s , k , 0);
        
    }
}