class Solution {

    public static String lps(String s){
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        while(left < right){

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;

        }

        String rev = new String(chars);
        String lps = "";

        for(int i = s.length() ; i >= 1 ; i--){

            String prefix = s.substring(0, i);
            String suffix = rev.substring(rev.length() - i);
            
            if(prefix.equals(suffix)){

                lps = prefix;
                break;

            }
        }

        return lps;

    }
    
    public String longestPalindrome(String s) {

        int i = 0;
        int len = 0;
        int max = 0;
        String ans = "";
        String finalAns = "";

        while(i < s.length()){

            ans = lps(s.substring(i));

            if(ans.length() > max){

                finalAns = lps(s.substring(i));
                max = ans.length();

            } 

            i++;

        }

        return finalAns;
    }
}