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
    public int maxLevelSum(TreeNode root){

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> temp = new LinkedList<>();

        if(root == null) return 0;

        temp.add(root);

        int level = 0;
        int max = Integer.MIN_VALUE;
        int idx = 1;

        while(temp.size() > 0){

            int lvl = temp.size();
            List<Integer> child = new ArrayList<>();

            int sum = 0;
            level++;

            for(int i = 1 ; i <= lvl ; i++){

                TreeNode ele = temp.remove();
                child.add(ele.val);

                sum = sum + ele.val;

                if(ele.left != null) temp.add(ele.left);
                if(ele.right != null) temp.add(ele.right);

            }

            ans.add(child);

            if(sum > max){

                max = sum;
                idx = level;

            }
        }

        return idx;
        
    }

}