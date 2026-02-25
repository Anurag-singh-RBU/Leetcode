class Solution {

    public static int countOnes(int num){
        
        int count = 0;
        
        while(num > 0){
            
            if((num & 1) == 1){

                count++;

            }
            
            num = num >> 1;

        }
        
        return count;

    }

    public int[] sortByBits(int[] arr) {

        int n = arr.length;
        
        for(int i = 0 ; i < n - 1 ; i++){
            
            for(int j = 0 ; j < n - i - 1 ; j++){
                
                int count1 = countOnes(arr[j]);
                int count2 = countOnes(arr[j + 1]);
                
                if(count1 > count2 || (count1 == count2 && arr[j] > arr[j + 1])){
                    
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    
                }
            }
        }
        
        return arr;
        
    }
}