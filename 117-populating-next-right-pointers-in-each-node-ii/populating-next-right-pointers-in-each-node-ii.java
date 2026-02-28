/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {

        if(root == null) return null;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(q.size() > 0){

            int size = q.size();

            Node prev = null;

            while(size-- > 0){

                Node cnt = q.poll();

                if(size == 1){

                    cnt.next = null;

                }

                if(prev != null){

                    prev.next = cnt;

                }

                prev = cnt;

                if(cnt.left != null) q.offer(cnt.left);
                if(cnt.right != null) q.offer(cnt.right);

            }
        }

        return root;
        
    }
}