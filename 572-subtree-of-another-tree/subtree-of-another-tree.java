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

    public String build(TreeNode root){

        if(root == null) return "N";

        String left = build(root.left);
        String right = build(root.right);

        String target = root.val + "," + left + "," + right;

        return target;

    }

    public boolean solve(TreeNode root , String target){

        if(root == null) return false;

        String subTree = build(root);

        if(subTree.equals(target)) return true;

        return solve(root.left , target) || solve(root.right , target);

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        String target = build(subRoot);

        return solve(root , target);
        
    }
}