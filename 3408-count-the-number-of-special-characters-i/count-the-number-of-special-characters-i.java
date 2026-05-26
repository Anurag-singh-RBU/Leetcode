class Solution {
    public int numberOfSpecialChars(String word) {

        Set<Character> hs = new HashSet<>();

        char[] words = word.toCharArray();

        int count = 0;

        for(char ch : words){

            if(!hs.contains(ch) && Character.isLowerCase(ch) && word.contains(String.valueOf(Character.toUpperCase(ch)))){

                hs.add(ch);
                count++;

            }

            else if(!hs.contains(ch) && Character.isUpperCase(ch) && word.contains(String.valueOf(Character.toLowerCase(ch)))){

                hs.add(ch);
                count++;

            }

        }

        return count / 2;
        
    }
}