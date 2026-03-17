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
        int idx;

        Pair(TreeNode node , int idx){

            this.node = node;
            this.idx = idx;

        }

    }

    public int update(TreeNode root){

        if(root == null) return 0;

        int idx = 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root , idx));

        int maxWidth = 1;

        while(q.size() > 0){

            int lvl = q.size();

            int leftMost = q.peek().idx;
            int rightMost = 1;

            while(lvl-- > 0){

                Pair cnt = q.poll();

                rightMost = cnt.idx;

                int width = rightMost - leftMost;

                maxWidth = Math.max(maxWidth , width + 1);

                if(cnt.node.left != null){

                    q.offer(new Pair(cnt.node.left , 2 * cnt.idx + 1));

                }

                if(cnt.node.right != null){

                    q.offer(new Pair(cnt.node.right , 2 * cnt.idx + 2));
                    
                }

            }

        }

        return maxWidth;

    }

    public int widthOfBinaryTree(TreeNode root) {
        
        return update(root);

    }
}