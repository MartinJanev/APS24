package Labs.Kolokvium2.GraphAlgoritms;

import java.util.*;

public class ModuleTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        Map<String, Integer> moduleTimes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String module = input[0];
            int time = Integer.parseInt(input[1]);

            graph.addVertex(module);
            moduleTimes.put(module, time);
        }

        int m = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < m; i++) {
            String[] dependency = scanner.nextLine().split(" ");
            String dependent = dependency[0];
            String prerequisite = dependency[1];
            graph.addEdge(prerequisite, dependent);
        }

        int maxCompilationTime = calculateMaxCompilationTime(graph, moduleTimes);
        System.out.println(maxCompilationTime);
    }

    private static int calculateMaxCompilationTime(AdjacencyListGraph<String> graph, Map<String, Integer> moduleTimes) {
        Map<String, Integer> maxTimes = new HashMap<>();

        List<String> sortedModules = graph.topologicalSort();

        int maxTime = 0;
        for (String module : sortedModules) {
            int currentTime = moduleTimes.get(module);

            for (String prerequisite : graph.getIncomingNeighbors(module)) {
                currentTime = Math.max(currentTime, maxTimes.get(prerequisite) + moduleTimes.get(module));
            }

            maxTimes.put(module, currentTime);
            maxTime = Math.max(maxTime, currentTime);
        }

        return maxTime;
    }

    static class AdjacencyListGraph<T> {
        private Map<T, Set<T>> adjacencyList;
        private Map<T, Set<T>> incomingEdges;

        public AdjacencyListGraph() {
            this.adjacencyList = new HashMap<>();
            this.incomingEdges = new HashMap<>();
        }

        // Add a vertex to the graph
        public void addVertex(T vertex) {
            adjacencyList.putIfAbsent(vertex, new HashSet<>());
            incomingEdges.putIfAbsent(vertex, new HashSet<>());
        }

        // Add an edge to the graph
        public void addEdge(T source, T destination) {
            addVertex(source);
            addVertex(destination);
            adjacencyList.get(source).add(destination);
            incomingEdges.get(destination).add(source);
        }

        // Get all neighbors of a vertex
        public Set<T> getNeighbors(T vertex) {
            return adjacencyList.getOrDefault(vertex, new HashSet<>());
        }

        // Get all incoming neighbors of a vertex
        public Set<T> getIncomingNeighbors(T vertex) {
            return incomingEdges.getOrDefault(vertex, new HashSet<>());
        }

        // Perform topological sort
        public List<T> topologicalSort() {
            Map<T, Integer> inDegree = new HashMap<>();
            for (T vertex : adjacencyList.keySet()) {
                inDegree.put(vertex, 0);
            }
            for (T vertex : adjacencyList.keySet()) {
                for (T neighbor : adjacencyList.get(vertex)) {
                    inDegree.put(neighbor, inDegree.get(neighbor) + 1);
                }
            }

            Queue<T> queue = new LinkedList<>();
            for (T vertex : inDegree.keySet()) {
                if (inDegree.get(vertex) == 0) {
                    queue.add(vertex);
                }
            }

            List<T> sorted = new ArrayList<>();
            while (!queue.isEmpty()) {
                T current = queue.poll();
                sorted.add(current);

                for (T neighbor : adjacencyList.getOrDefault(current, new HashSet<>())) {
                    inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                    if (inDegree.get(neighbor) == 0) {
                        queue.add(neighbor);
                    }
                }
            }

            return sorted;
        }
    }
}
