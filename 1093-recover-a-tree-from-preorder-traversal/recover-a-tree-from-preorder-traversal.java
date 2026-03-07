/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    class Pair{

        TreeNode node;
        int depth;

        Pair(TreeNode node , int depth){

            this.node = node;
            this.depth = depth;

        }

    }

    public TreeNode recoverFromPreorder(String traversal){

        Stack<Pair> st = new Stack<>();

        int idx = 0;

        while(idx < traversal.length()){

            int depth = 0;

            while(idx < traversal.length() && traversal.charAt(idx) == '-'){

                depth++;
                idx++;

            }

            int num = 0;

            while(idx < traversal.length() && Character.isDigit(traversal.charAt(idx))){

                num = num * 10 + (traversal.charAt(idx) - '0');
                idx++;

            }

            TreeNode node = new TreeNode(num);

            while(!st.isEmpty() && st.peek().depth >= depth){

                st.pop();

            }

            if(!st.isEmpty()){

                TreeNode parent = st.peek().node;

                if(parent.left == null){

                    parent.left = node;

                }

                else{

                    parent.right = node;

                }

            }

            st.push(new Pair(node , depth));

        }

        while(st.size() > 1){

            st.pop();

        }

        return st.peek().node;
        
    }
}
