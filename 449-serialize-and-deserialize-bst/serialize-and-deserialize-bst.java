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

    int idx;

    public TreeNode solve(String[] parts){

        if(idx >= parts.length) return null;

        if(parts[idx].equals("N")){

            idx++;
            return null;

        }

        TreeNode root = new TreeNode(Integer.parseInt(parts[idx]));
        idx++;

        root.left = solve(parts);
        root.right = solve(parts);

        return root;

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root == null) return "N";

        String left = serialize(root.left);
        String right = serialize(root.right);

        String ans = root.val + "," + left + "," + right;

        return ans;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] nodes = data.split(",");

        idx = 0;

        return solve(nodes);
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;