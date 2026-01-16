class Solution {

    public static int[][] dp;

    public static int getNext(int[][] events , int idx){

        int l = idx + 1;
        int r = events.length - 1;

        int ans = events.length;
        int end = events[idx][1];

        while(l <= r){

            int mid = l + (r - l) / 2;

            if(events[mid][0] > end){

                ans = mid;
                r = mid - 1;

            } 
            
            else{

                l = mid + 1;

            }

        }

        return ans;

    }

    public static int solve(int[][] events , int idx , int k){

        if(k == 0 || idx >= events.length) return 0;

        if(dp[idx][k] != -1) return dp[idx][k];

        int skip = solve(events , idx + 1 , k);

        int nextIdx = getNext(events , idx);

        int take = events[idx][2] + solve(events , nextIdx , k - 1);

        return dp[idx][k] = Math.max(take , skip);

    }

    public int maxValue(int[][] events, int k) {

        dp = new int[events.length + 1][k + 1];

        for(int i = 0 ; i < dp.length ; i++){

            Arrays.fill(dp[i] , -1);

        }

        Arrays.sort(events , (a, b) -> Integer.compare(a[0] , b[0]));

        return solve(events , 0 , k);
        
    }
}