class Solution {
    public int numberOfSpecialChars(String word) {

        Map<Character , Integer> hm = new HashMap<>();
        Set<Character> hs = new HashSet<>();
        Map<Character , int[]> FnL = new HashMap<>();
        char[] words = word.toCharArray();

        for(int i = 0 ; i < words.length ; i++){

            if(Character.isLowerCase(words[i])){

                if(!FnL.containsKey(words[i])){

                    FnL.put(words[i], new int[]{i, i});

                } 
                
                else{

                    FnL.get(words[i])[1] = i;

                }

            }
            
        }      

        int count = 0;

        for(int i = 0 ; i < words.length ; i++){

            if(Character.isUpperCase(words[i]) && !hm.containsKey(words[i])){

                hm.put(words[i] , i);

            }

        }

        for(int i = 0 ; i < words.length ; i++){

            int idx = -1;

            if(Character.isLowerCase(words[i]) && !hs.contains(words[i])){
              
                idx = hm.getOrDefault(Character.toUpperCase(words[i]) , -1);

                int[] fnlIDXs = FnL.get(words[i]);

                if(idx != -1 && fnlIDXs[0] < idx && fnlIDXs[1] < idx){

                    count++;
                    hs.add(words[i]);

                }

            }

        }

        return count;
        
    }
}
