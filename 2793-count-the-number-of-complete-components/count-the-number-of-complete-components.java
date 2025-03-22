import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Set<Integer> component = new HashSet<>();
                dfs(i, graph, visited, component);

                if (isComplete(component, graph)) {
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int node, List<Integer>[] graph, boolean[] visited, Set<Integer> component) {
        visited[node] = true;
        component.add(node);

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }

    private boolean isComplete(Set<Integer> component, List<Integer>[] graph) {
        int size = component.size();
        for (int node : component) {
            if (graph[node].size() != size - 1) {
                return false;
            }
        }
        return true;
    }
}
