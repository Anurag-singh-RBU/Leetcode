class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        
        Arrays.sort(happiness); 

        int n = happiness.length;
        int dec = 0;

        for(int i = n - 1 ; i >= n - k ; i--){

            happiness[i] = happiness[i] - dec;

            if(happiness[i] < 0){

                happiness[i] = 0;

            }

            dec++;

        }

        long ans = 0;
        
        for(int i = n - 1 ; i >= n - k ; i--){

            ans = ans + happiness[i];

        }

        return ans;
        
    }
}