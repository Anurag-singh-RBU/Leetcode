class Solution {

    public static int calWvy(String s){

        char[] ch = s.toCharArray();
        int count = 0;

        for(int i = 1 ; i < ch.length - 1 ; i++){

            if(ch[i] - '0' > ch[i - 1] - '0' && ch[i] - '0' > ch[i + 1] - '0'){

                count++;

            }

            else if(ch[i] - '0' < ch[i - 1] - '0' && ch[i] - '0' < ch[i + 1] - '0'){

                count++;

            }

        }

        return count;

    }

    public int totalWaviness(int num1, int num2) {

        int ans = 0;

        for(int i = num1 ; i <= num2 ; i++){

            int num = i;
            String s = String.valueOf(num);
            
            ans = ans + calWvy(s);

        }

        return ans;
        
    }
}