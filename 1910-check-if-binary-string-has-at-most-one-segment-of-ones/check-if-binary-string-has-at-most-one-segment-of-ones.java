class Solution {
    public boolean checkOnesSegment(String s) {

        int idx = 0;

        while(idx != s.length() && s.charAt(idx) == '1'){

            idx++;

        }


        for(int i = idx ; i < s.length() ; i++){

            if(s.charAt(i) == '1'){

                return false;

            }
        }

        return true;
        
    }
}