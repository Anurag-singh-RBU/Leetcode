/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public int idx = 0;

    public TreeNode solve(String[] parts){

        if(parts[idx].equals("null")){
            
            idx++;
            return null;
        
        }

        TreeNode root = new TreeNode(Integer.parseInt(parts[idx]));
        idx++;

        if(idx >= parts.length) return root;

        root.left = solve(parts);
        root.right = solve(parts);

        return root;

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root == null) return "null";

        String left = serialize(root.left);
        String right = serialize(root.right);

        String seq = root.val + "," + left + "," + right;

        return seq;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] parts = data.split(",");
        idx = 0;
        return solve(parts);
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));