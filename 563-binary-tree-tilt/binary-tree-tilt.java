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

    public int sum = 0;

    public int DFS(TreeNode root){

        if(root == null) return 0;

        int left = DFS(root.left);
        int right = DFS(root.right);

        int tilt = Math.abs(left - right); 

        sum = sum + tilt;

        return left + right + root.val; 

    }

    public int findTilt(TreeNode root) {

        DFS(root);

        return sum;       
        
    }
}