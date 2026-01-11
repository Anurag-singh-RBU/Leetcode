class Solution {

    static int[][] dp;

    public static int solve(int[] cuts , int lft , int rgt){

        if(rgt - lft == 1) return 0;

        if(dp[lft][rgt] != -1) return dp[lft][rgt];

        int ans = Integer.MAX_VALUE;

        for(int idx = lft + 1 ; idx < rgt ; idx++){

            int cost = (cuts[rgt] - cuts[lft]) + solve(cuts , lft , idx) + solve(cuts , idx , rgt);

            ans = Math.min(ans , cost);

        }

        return dp[lft][rgt] = ans;

    }

    public int minCost(int n , int[] cuts) {

        Arrays.sort(cuts);

        dp = new int[cuts.length + 2][cuts.length + 2];

        for(int[] row : dp) Arrays.fill(row , -1);

        List<Integer> temp = new ArrayList<>();

        temp.add(0);

        for(int i = 0 ; i < cuts.length ; i++){

            temp.add(cuts[i]);

        }

        temp.add(n);

        int[] nums = new int[temp.size()];

        for(int i = 0 ; i < temp.size() ; i++){

            nums[i] = temp.get(i);

        }

        return solve(nums , 0 , nums.length - 1);
        
    }
}