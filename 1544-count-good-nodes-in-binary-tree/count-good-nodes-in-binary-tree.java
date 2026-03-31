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

    public int count = 0;

    public void DFS(TreeNode root , int MSF){

        if(root == null) return;

        if(root.val >= MSF){

            count++;

        }

        if(root.left != null) DFS(root.left , Math.max(root.left.val , MSF));
        if(root.right != null)  DFS(root.right , Math.max(root.right.val , MSF));

    }

    public int goodNodes(TreeNode root) {

        DFS(root , root.val);

        return count;
        
    }
}