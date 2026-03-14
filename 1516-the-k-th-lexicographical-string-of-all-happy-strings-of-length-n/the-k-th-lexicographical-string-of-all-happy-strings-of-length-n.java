class Solution {

    public static void helper(int n , List<List<Character>> ans , List<Character> temp , char[] chs){

        if(temp.size() >= n){

            ans.add(new ArrayList<>(temp));
            return;

        }

        for(char ch : chs){

            if(temp.size() > 0 && temp.get(temp.size() - 1) == ch){

                continue;

            }

            temp.add(ch);
            helper(n , ans , temp , chs);
            temp.remove(temp.size() - 1);

        }

    }

    public String getHappyString(int n, int k) {

        char[] chs = {'a','b','c'};
        List<List<Character>> ans = new ArrayList<>();

        helper(n , ans , new ArrayList<>() , chs);

        if(k > ans.size()) return "";

        StringBuilder sb = new StringBuilder();

        List<Character> chAry = ans.get(k - 1); 

        for(char ch : chAry){

            sb.append(ch);

        }

        return sb.toString();
        
    }
}