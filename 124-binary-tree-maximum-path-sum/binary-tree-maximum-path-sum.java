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

    public int max = Integer.MIN_VALUE;

    public int DFS(TreeNode root){

        if(root == null) return 0;

        int left = Math.max(0 , DFS(root.left));
        int right = Math.max(0 , DFS(root.right));

        int sum = root.val + left + right;
        max = Math.max(max , sum);

        return root.val + Math.max(left , right);

    }

    public int maxPathSum(TreeNode root) {

        DFS(root);

        return max;
        
    }
}