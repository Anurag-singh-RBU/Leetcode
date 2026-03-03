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

    public void DFS(TreeNode root , StringBuilder path , List<String> paths){

        if(root == null) return;

        path.append((char) (root.val + 'a')) ;

        if(root.left == null && root.right == null){

            String updated = path.reverse().toString();

            paths.add(updated);

            path.reverse();

        }

        DFS(root.left , path , paths);
        DFS(root.right , path , paths);

        path.deleteCharAt(path.length() - 1);

    }

    public String smallestFromLeaf(TreeNode root) {

        ArrayList<String> paths = new ArrayList<>();

        DFS(root , new StringBuilder() , paths);

        String min = paths.get(0);

        for(String ite : paths){

            String path = ite;

            if(path.compareTo(min) < 0){

                min = path;

            }

        }

        return min;
        
    }
}