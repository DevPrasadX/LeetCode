class Solution {
    private static final int MAX_DEPTH = 1000;
    HashMap<Node, Node> map = new HashMap<>();

    public Node dfs(Node node, int depth) {
        if (node == null) return null;

        if (map.containsKey(node)) {
            return map.get(node);
        }

        if (depth > MAX_DEPTH) {
            return bfsClone(node); // fallback
        }

        Node copy = new Node(node.val, new ArrayList<>());
        map.put(node, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor, depth + 1));
        }

        return copy;
    }

    public Node bfsClone(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        map.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (Node nei : curr.neighbors) {
                if (!map.containsKey(nei)) {
                    map.put(nei, new Node(nei.val, new ArrayList<>()));
                    queue.add(nei);
                }
                map.get(curr).neighbors.add(map.get(nei));
            }
        }

        return map.get(node);
    }

    public Node cloneGraph(Node node) {
        return dfs(node, 0);
    }
}