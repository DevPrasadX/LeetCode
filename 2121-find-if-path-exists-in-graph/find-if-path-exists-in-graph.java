class Solution {
    private boolean dfs(int i, int destination, 
                        Map<Integer, List<Integer>> map, Set<Integer> set) {
        if (i == destination) return true;

        for (int neighbour : map.getOrDefault(i, new ArrayList<>())) {
            if (!set.contains(neighbour)) {
                set.add(neighbour);
                
                if (dfs(neighbour, destination, map, set)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        Set<Integer> set = new HashSet<>();
        set.add(source);

        return dfs(source, destination, map, set);
    }
}