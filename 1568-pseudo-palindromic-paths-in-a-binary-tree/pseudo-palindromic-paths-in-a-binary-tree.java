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

    public int ans = 0;

    public void DFS(TreeNode root , int[] freq){
         
        if(root == null) return;

        freq[root.val]++;

        if(root.left == null && root.right == null){

            int oddFreq = 0;

            for(int i = 1 ; i <= 9 ; i++){

                if(freq[i] % 2 != 0){

                    oddFreq++;

                }
            }

            if(oddFreq <= 1){

                ans = ans + 1;

            } 

        }

        DFS(root.left , freq);
        DFS(root.right , freq);

        freq[root.val]--;
        
    }

    public int pseudoPalindromicPaths (TreeNode root) {

        int[] freq = new int[10];

        DFS(root , freq);

        return ans;
        
    }
}