class Solution {

    public static String dec_to_bin(int num){

        if(num == 0) return "0";

        StringBuilder sb = new StringBuilder();

        while(num > 0){

            sb.append(num % 2);  
            num = num / 2;

        }

        return sb.reverse().toString();  

    }

    public boolean hasAlternatingBits(int n) {

        String bin = dec_to_bin(n);

        for(int i = 1 ; i < bin.length() ; i++){

            if(bin.charAt(i) == bin.charAt(i - 1)) return false;

        }

        return true;
        
    }
}