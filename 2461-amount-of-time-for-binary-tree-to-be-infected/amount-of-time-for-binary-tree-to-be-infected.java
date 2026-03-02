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

    public static TreeNode getNode(TreeNode root , int start){

        if(root == null) return null;
        if(root.val == start) return root;

        TreeNode left = getNode(root.left , start);
        TreeNode right = getNode(root.right , start);

        if(left == null) return right;
        else return left;
    }

    public void preorder(TreeNode root , Map<TreeNode , TreeNode> parent){

        if(root == null) return;

        if(root.left != null) parent.put(root.left , root);
        if(root.right != null) parent.put(root.right , root);

        preorder(root.left , parent);
        preorder(root.right , parent);
    }

    public int amountOfTime(TreeNode root, int start) {

        TreeNode infected = getNode(root , start);

        Map<TreeNode , TreeNode> parent = new HashMap<>();
        preorder(root , parent);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(infected);
        visited.add(infected);

        int time = -1;

        while(!q.isEmpty()){

            int size = q.size();

            while(size-- > 0){

                TreeNode curr = q.remove();

                if(curr.left != null && !visited.contains(curr.left)){
                    q.add(curr.left);
                    visited.add(curr.left);
                }

                if(curr.right != null && !visited.contains(curr.right)){
                    q.add(curr.right);
                    visited.add(curr.right);
                }

                if(parent.containsKey(curr) && !visited.contains(parent.get(curr))){
                    q.add(parent.get(curr));
                    visited.add(parent.get(curr));
                }
            }

            time++;   // ek level complete → 1 minute
        }

        return time;
    }
}