class Solution {
    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;

        int[] t = new int[n];
        int[] count = new int[n];

        Arrays.fill(t , 1);
        Arrays.fill(count , 1);

        for(int i = 0 ; i < n ; i++){

            for(int j = 0 ; j < i ; j++){

                if(nums[j] < nums[i]){

                    if(t[i] == t[j] + 1){

                        count[i] = count[i] + count[j];

                    }
                    
                    else if(t[i] < t[j] + 1){

                        t[i] = t[j] + 1;
                        count[i] = count[j];

                    }

                }
            }
        }

        int max = 0;
        for(int x : t) max = Math.max(max , x);

        int ans = 0;

        for(int i = 0 ; i < n ; i++){

            if(t[i] == max){

                ans = ans + count[i];

            }

        }

        return ans;

    }
}