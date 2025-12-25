class Solution {

    public static int dp[];

    public static int solve(int[] days, int[] costs , int idx){

        if(idx >= days.length) return 0;

        if(dp[idx] != -1) return dp[idx];

        int oneday = costs[0] + solve(days , costs , idx + 1);

        int temp = idx;
        int maxDay = days[idx] + 7;

        while(temp < days.length && days[temp] < maxDay){

            temp++;
            
        }

        int sevendays = costs[1] + solve(days , costs , temp);

        temp = idx;
        maxDay = days[idx] + 30;

        while(temp < days.length && days[temp] < maxDay){

            temp++;

        }

        int thirtydays = costs[2] + solve(days , costs , temp);

        int firstTwo = Math.min(oneday , sevendays);

        return dp[idx] = Math.min(firstTwo , thirtydays);

    }

    public int mincostTickets(int[] days, int[] costs) {

        dp = new int[366];

        Arrays.fill(dp , -1);

        return solve(days , costs , 0);
        
    }
}