class Solution {

    public static int sumOfDigits(int num){

        int d = 0;
        int sum = 0;

        while(num != 0){

            d = num % 10;

            sum = sum + d;

            num = num / 10;

        }

        return sum;

    }

    public int minElement(int[] nums) {

        int ans = sumOfDigits(nums[0]);

        for(int i = 0 ; i < nums.length ; i++){

            ans = Math.min(ans , sumOfDigits(nums[i]));

        }

        return ans;
        
    }
}