class Solution {
    public int binaryGap(int n) {

        String bin = Integer.toBinaryString(n);
        int ptr = -1;
        int max = 0;

        for(int i = 0 ; i < bin.length() ; i++){

            if(bin.charAt(i) == '1'){

                if(ptr != -1){

                    max = Math.max(max , i - ptr);

                }

                ptr = i;

            }
        }

        return max;
        
    }
}