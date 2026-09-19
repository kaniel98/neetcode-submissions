/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>(); // Basically maintain a copy of old -> new for easy reference 
        return clone(map, node);
    }

    private Node clone(Map<Node, Node> map, Node node) {
        if (map.containsKey(node)) {
            // If visited, processing should be done, we can return it directly
            return map.get(node);
        }

        if (node == null) {
            return null;
        }

        // Else at this point, create a new node
        Node newNode = new Node(node.val);
        map.put(node, newNode);

        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(clone(map, neighbor));
        }

        return newNode;
    }
}