/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ints = new ArrayList<>();
        if (root != null){
            List<Integer> al = new ArrayList<>();
            al.add(root.val);
            ints.add(al);
            if (root.children != null)
                addDepth(ints,root.children,1);
        }
        return ints;
    }
    public void addDepth(List<List<Integer>> ints, List<Node> nodes, int depth){
        List<Integer> nl = new ArrayList<>();
        if (ints.size() <= depth){
            ints.add(nl);
        }
        for (Node n : nodes){
            ints.get(depth).add(n.val);
            if (n.children != null)
                addDepth(ints, n.children, depth + 1);
        }
        if (nl.size() == 0)
            ints.remove(nl);
    }
}