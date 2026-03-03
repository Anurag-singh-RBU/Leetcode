class Solution {

    public String revOfInvSn(String s){

        StringBuilder sb = new StringBuilder();
    
        for(char ch : s.toCharArray()){

            if(ch == '0'){

                sb.append('1');

            } 
            
            else{

                sb.append('0');

            }

        }
    
        sb.reverse();
        
        return sb.toString();

    }

    public String solve(int n){

        if(n == 1) return "0";

        String prev = solve(n - 1);

        String Sn = prev + "1" + revOfInvSn(prev);

        return Sn;

    }

    public char findKthBit(int n, int k) {

        String Sn = solve(n);

        return Sn.charAt(k - 1);
        
    }
}