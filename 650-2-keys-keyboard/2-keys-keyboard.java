class Solution {

    static final int INF = (int) 1e9;

    public static int solve(int n , int len , int clip){

        if(len > n) return INF;

        if(len == n){

            return 0;

        }

        int ans = INF;

        if(clip != len) ans = Math.min(ans , 1 + solve(n , len , len));

        if(clip > 0){

            ans = Math.min(ans , 1 + solve(n , len + clip , clip));

        } 

        return ans;

    }

    public int minSteps(int n) {

        return solve(n , 1 , 0);
        
    }
}