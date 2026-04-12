/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        List<Node> list_p = new ArrayList<>();
        List<Node> list_q = new ArrayList<>();

        if (p == null || q == null) return null; // Node, not int → return null not 0

        // Walk up to root from p
        Node curr = p;
        while (curr != null) {
            list_p.add(curr);
            curr = curr.parent;
        }

        // Walk up to root from q
        curr = q;
        while (curr != null) {
            list_q.add(curr);
            curr = curr.parent;
        }

        // Find last common node
        int i = list_p.size() - 1;
        int j = list_q.size() - 1;
        Node lca = null;
        while (i >= 0 && j >= 0 && list_p.get(i) == list_q.get(j)) {
            lca = list_p.get(i);
            i--;
            j--;
        }

        return lca;
    }
}