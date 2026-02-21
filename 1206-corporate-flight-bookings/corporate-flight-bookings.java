class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] events = new int[n + 2];

        for(int[] row : bookings){

            int start = row[0];
            int end = row[1];
            int count = row[2];

            events[start] = events[start] + count;
            events[end + 1] = events[end + 1] - count;

        }

        int[] ans = new int[n];
        int sum = 0;

        for(int i = 1 ; i <= n ; i++){

            sum = sum + events[i];
            ans[i - 1] = sum;

        }

        return ans;
        
    }
}