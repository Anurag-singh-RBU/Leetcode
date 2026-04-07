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

    public static long total = 0;
    public static long ans = 0;
    public static int MOD = (int) 1e9 + 7;

    public static long totalSum(TreeNode root){

        if(root == null) return 0;

        return root.val + totalSum(root.left) + totalSum(root.right);

    } 

    public static long DFS(TreeNode root){

        if(root == null) return 0;

        long left = DFS(root.left);
        long right = DFS(root.right);

        long sum = left + root.val + right;
        ans = Math.max(ans , (total - sum) * sum);

        return sum;

    }

    public int maxProduct(TreeNode root) {

        total = 0;
        ans = 0;

        total = totalSum(root);

        DFS(root);

        return (int) (ans % MOD);
        
    }
}