class Solution {
    public boolean isValidSerialization(String preorder) {

        Stack<String> st = new Stack<>();
        int counter = 2;
   
        String[] chs = preorder.split(",");

        for(int i = 0 ; i < chs.length ; i++){

            String ch = chs[i];

            st.push(ch);

            while(st.size() >= 3 && st.peek().equals("#") && st.get(st.size() - 2).equals("#") && !st.get(st.size() - 3).equals("#")){

                for(int ite = 0 ; ite <= counter ; ite++){

                    st.pop();

                }

                st.push("#");

            }

        }

        return st.size() == 1 && st.peek().equals("#");   
        
    }
}