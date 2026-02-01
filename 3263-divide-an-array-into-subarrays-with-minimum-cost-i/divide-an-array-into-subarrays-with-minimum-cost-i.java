class Solution {
    public int minimumCost(int[] nums) {

        int first = nums.length > 0 ? nums[0] : 0;

        int[] temp = new int[nums.length - 1];

        for(int i = 1 ; i < nums.length ; i++){

            temp[i - 1] = nums[i];

        }

        Arrays.sort(temp);

        return first + temp[0] + temp[1];

    }
}



