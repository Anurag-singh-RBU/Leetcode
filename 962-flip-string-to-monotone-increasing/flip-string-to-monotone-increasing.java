class Solution {

    public static int dp[][];

    public static int solve(String s , int cI , int pI){

        if(cI >= s.length()) return 0;

        if(dp[cI][pI] != -1) return dp[cI][pI];

        int flip = Integer.MAX_VALUE;
        int notFlip = Integer.MAX_VALUE;

        int cIdx = s.charAt(cI) - '0';

        if(cIdx == 1){

            if(pI == 0){

                flip = 1 + solve(s , cI + 1 , 0);
                notFlip = solve(s , cI + 1 , 1);

            }

            else{

                notFlip = solve(s , cI + 1 , 1);

            }
        }

        else if(cIdx == 0){

            if(pI == 0){

                flip = 1 + solve(s , cI + 1 , 1);
                notFlip = solve(s , cI + 1 , 0);

            }

            else{

              flip = 1 + solve(s , cI + 1 , 1);

            }

        }

        return dp[cI][pI] = Math.min(flip , notFlip);

    }

    public int minFlipsMonoIncr(String s) {

        dp = new int[s.length() + 1][2];

        for(int i = 0 ; i < dp.length ; i++){

            Arrays.fill(dp[i] , -1);

        }

        return solve(s , 0 , 0);
        
    }
}