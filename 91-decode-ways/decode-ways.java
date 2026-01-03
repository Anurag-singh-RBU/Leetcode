class Solution {

    public static int N;
    public static int dp[];

    public static int solve(String s , int idx){

        if(idx == N) return 1;

        if(s.charAt(idx) == '0') return 0;

        if(dp[idx] != -1) return dp[idx];

        int ans = 0;
        int num = 0;

        for(int end = idx ; end < N ; end++){

            num = num * 10 + (s.charAt(end) - '0');

            if(num > 26) break;

            ans = ans + solve(s , end + 1);

        }

        return dp[idx] = ans;

    }

    public int numDecodings(String s) {

        N = s.length();

        dp = new int[N + 1];

        Arrays.fill(dp , -1);

        return solve(s , 0);

    }
}