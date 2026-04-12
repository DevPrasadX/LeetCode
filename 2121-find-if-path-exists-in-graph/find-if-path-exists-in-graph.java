class Solution {
    private boolean dfs(int i, int destination,
                        List<List<Integer>> list, boolean[] visited) {
        if (i == destination) return true;

        for (int neighbour : list.get(i)) {
            if (!visited[neighbour]) {
                visited[neighbour] = true;
                if (dfs(neighbour, destination, list, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;

        // List instead of HashMap
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());   // create empty list for each node
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        // boolean array instead of HashSet
        boolean[] visited = new boolean[n];
        visited[source] = true;

        return dfs(source, destination, list, visited);
    }
}