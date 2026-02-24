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

    public static void solve(TreeNode root , List<String> paths , String num){

        if(root == null) return;

        num = num + root.val;

        if(root.left == null && root.right == null){

            paths.add(num);
            return;

        }
       
        solve(root.left , paths , num);
        solve(root.right , paths , num);

    }

    public int sumRootToLeaf(TreeNode root) {

        List<String> paths = new ArrayList<>();

        solve(root , paths , "");

        long sum = 0;

        for(String x : paths){

            long DRoX = Long.parseLong(x , 2);

            sum = sum + DRoX;

        }  

        return (int) sum;

    }
}