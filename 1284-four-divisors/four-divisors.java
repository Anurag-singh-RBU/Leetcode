class Solution {

    public static int findDivs(int num){

        int divs = 0;
        int sum = 0;

        for(int i = 1 ; i * i <= num ; i++){

            if(num % i == 0){

                int other = num / i;

                if(other == i){

                    divs = divs + 1;
                    sum = sum + i;

                }

                else{
                    
                    divs = divs + 2;
                    sum = sum + (i + other);

                }

            }

            if(divs > 4) return 0;

        }

        return divs == 4 ? sum : 0;

    }

    public int sumFourDivisors(int[] nums) {

        int ans = 0;

        for(int num : nums){

            ans = ans + findDivs(num);

        }

        return ans;
        
    }
}