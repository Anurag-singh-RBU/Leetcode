class Solution {

    public static int dp[][];

    public static int solve(int[] satisfaction , int idx , int ptr){

        if(idx >= satisfaction.length){

            return 0;

        }

        if(dp[idx][ptr] != -1) return dp[idx][ptr]; 
            
        int LTC = ptr * satisfaction[idx];
        int take = LTC + solve(satisfaction , idx + 1 , ptr + 1); 

        int skip = solve(satisfaction , idx + 1 , ptr);

        return dp[idx][ptr] = Math.max(take , skip);

    }

    public int maxSatisfaction(int[] satisfaction) {

        dp = new int[501][502];

        for(int i = 0 ; i < 501 ; i++){

            Arrays.fill(dp[i] , -1);

        }

        Arrays.sort(satisfaction);

        return solve(satisfaction , 0 , 1);
        
    }
}