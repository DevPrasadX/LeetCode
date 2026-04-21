import java.util.*;

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;

        // Build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] swap : allowedSwaps) {
            graph.get(swap[0]).add(swap[1]);
            graph.get(swap[1]).add(swap[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> group = new ArrayList<>();
                dfs(i, graph, visited, group);

                Map<Integer, Integer> freq = new HashMap<>();

                for (int idx : group) {
                    freq.put(source[idx], freq.getOrDefault(source[idx], 0) + 1);
                }

                for (int idx : group) {
                    if (freq.getOrDefault(target[idx], 0) > 0) {
                        freq.put(target[idx], freq.get(target[idx]) - 1);
                    } else {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited, List<Integer> group) {
        visited[node] = true;
        group.add(node);

        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                dfs(nei, graph, visited, group);
            }
        }
    }
}