class Solution {

    public static int dp[][];

    public static boolean solve(int idx , int pjump , HashMap<Integer , Integer> hm , int[] stones){

        if(idx == stones.length - 1) return true;

        if(dp[idx][pjump] != -1){

            return dp[idx][pjump] == 1;

        }

        boolean ans = false;

        if(pjump - 1 > 0 && hm.containsKey(stones[idx] + (pjump - 1))){
            
            ans = ans || solve(hm.get(stones[idx] + (pjump - 1)) , pjump - 1 , hm , stones);

        }

        if(hm.containsKey(stones[idx] + pjump)){
            
            ans = ans || solve(hm.get(stones[idx] + pjump) , pjump , hm , stones);

        }

        if(pjump + 1 < stones.length && hm.containsKey(stones[idx] + (pjump + 1))){
            
            ans = ans || solve(hm.get(stones[idx] + (pjump + 1)) , pjump + 1 , hm , stones);

        }

        dp[idx][pjump] = ans ? 1 : 0;
        
        return ans;

    }

    public boolean canCross(int[] stones) {

        dp = new int[2001][2001];

        for(int i = 0 ; i < 2001 ; i++){

            Arrays.fill(dp[i] , -1);

        }

        HashMap<Integer , Integer> hm = new HashMap<>();

        for(int i = 0 ; i < stones.length ; i++){

            hm.put(stones[i] , i);

        }

        if(stones.length > 0 && stones[1] != 1) return false;

        return solve(1 , 1 , hm , stones);
        
    }
}