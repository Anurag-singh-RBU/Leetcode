class Solution {

    static int dp[][][];

    public static boolean solve(int i , int j , int k , String s1 , String s2 , String s3){

        if(i == s1.length() && j == s2.length() && k == s3.length()) return true;

        if(k >= s3.length()) return false;

        if(dp[i][j][k] != -1) return dp[i][j][k] == 1;

        boolean ans = false;

        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)) ans = ans || solve(i + 1 , j , k + 1 , s1 , s2 , s3);
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)) ans = ans || solve(i , j + 1 , k + 1 , s1 , s2 , s3);

        dp[i][j][k] = ans ? 1 : 0;

        return ans;

    }

    public boolean isInterleave(String s1, String s2, String s3) {

        dp = new int[101][101][201];

        for(int i = 0 ; i <= s1.length() ; i++){

            for(int j = 0 ; j <= s2.length() ; j++){

                for(int k = 0 ; k <= s3.length() ; k++){

                    dp[i][j][k] = -1;

                }
            }
        }

        if(s1.length() + s2.length() != s3.length()) return false;

        return solve(0 , 0 , 0 , s1 , s2 , s3);

    }
}