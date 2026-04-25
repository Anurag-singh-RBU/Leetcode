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

    private TreeNode prev;
    private TreeNode first;
    private TreeNode last;
    private TreeNode mid;

    public void intrv(TreeNode root){

        if(root == null) return;

        intrv(root.left);

        if(prev != null && (root.val < prev.val)){

            if(first == null){

                first = prev;
                mid = root;

            }

            else last = root;

        }

        prev = root;
        intrv(root.right);

    }

    public void recoverTree(TreeNode root) {

       first = mid = last = null;
       prev = new TreeNode(Integer.MIN_VALUE);

       intrv(root);

       if(first != null && last != null){

            int t = first.val;
            first.val = last.val;
            last.val = t;

       }

        else if(first != null && mid != null){

            int t = first.val;
            first.val = mid.val;
            mid.val = t;

       }
       
    }
}