class Solution {

    public static int[] solve(int[] num){

        int c = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        
        int LD = num[num.length - 1];

        if(LD < 9){

            num[num.length - 1] = LD + 1;

            for(int digit : num){

                temp.add(digit);

            }

            int[] result = new int[temp.size()];

            for(int i = 0 ; i < temp.size() ; i++){

                result[i] = temp.get(i);

            }

            return result;

        }

        else{

            temp.add((LD + 1) % 10);

            c = 1;

            for(int i = num.length - 2 ; i >= 0 ; i--){ 

                int res = num[i] + c; 

                if(res > 9){

                    c = 1;
                    temp.addFirst((num[i] + 1) % 10);

                }
                    
                else{
                    
                    temp.addFirst(num[i] + c);
                    c = 0;

                }

            }

        }
        
        if(c == 1) temp.addFirst(c);

        int[] result = new int[temp.size()];

        for(int i = 0 ; i < temp.size() ; i++){

            result[i] = temp.get(i);

        }

        return result;

    }

    public int[] plusOne(int[] digits) {

        return solve(digits);
        
    }
}