package Labs.Kolokvium2.GraphAlgoritms;

import java.util.*;

public class Sostojki {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of ingredient pairs
        int N = Integer.parseInt(sc.nextLine());
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        Map<String, String> transformations = new HashMap<>();

        // Read ingredient pairs
        for (int i = 0; i < N; i++) {
            String[] tokens = sc.nextLine().split(" ");
            transformations.put(tokens[0], tokens[1]);
        }

        // Number of possible transformations
        int M = Integer.parseInt(sc.nextLine());

        // Read transformation graph
        for (int i = 0; i < M; i++) {
            String[] tokens = sc.nextLine().split(" ");
            String start = tokens[0];
            String end = tokens[1];
            int price = Integer.parseInt(tokens[2]);
            graph.addEdge(start, end, price);
        }

        // Calculate total cost
        int totalCost = 0;
        for (Map.Entry<String, String> entry : transformations.entrySet()) {
            String available = entry.getKey();
            String needed = entry.getValue();

            // Get shortest path distances from the available ingredient
            Map<String, Integer> distances = graph.shortestPath(available);

            // Add the cost to transform into the needed ingredient
            totalCost += distances.getOrDefault(needed, Integer.MAX_VALUE);
        }

        System.out.println(totalCost);
    }

    static class AdjacencyListGraph<T> {
        private Map<T, Map<T, Integer>> adjacencyList;

        public AdjacencyListGraph() {
            this.adjacencyList = new HashMap<>();
        }

        // Add a vertex to the graph
        public void addVertex(T vertex) {
            if (!adjacencyList.containsKey(vertex)) {
                adjacencyList.put(vertex, new HashMap<>());
            }
        }

        // Add an edge to the graph
        public void addEdge(T source, T destination, int weight) {
            addVertex(source);
            addVertex(destination);
            adjacencyList.get(source).put(destination, weight);
        }


        // Get all neighbors of a vertex
        public Map<T, Integer> getNeighbors(T vertex) {
            return adjacencyList.getOrDefault(vertex, new HashMap<>());
        }

        public Map<T, Integer> shortestPath(T startVertex) {
            Map<T, Integer> distances = new HashMap<>();
            PriorityQueue<T> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
            Set<T> explored = new HashSet<>();

            // Initialize distances
            for (T vertex : adjacencyList.keySet()) {
                distances.put(vertex, Integer.MAX_VALUE);
            }
            distances.put(startVertex, 0);

            queue.add(startVertex);

            while (!queue.isEmpty()) {
                T current = queue.poll();

                if (explored.contains(current)) continue;

                explored.add(current);

                for (Map.Entry<T, Integer> neighborEntry : adjacencyList.get(current).entrySet()) {
                    T neighbor = neighborEntry.getKey();
                    int weight = neighborEntry.getValue();
                    int newDist = distances.get(current) + weight;

                    if (newDist < distances.get(neighbor)) {
                        distances.put(neighbor, newDist);
                        queue.add(neighbor);
                    }
                }
            }

            return distances;
        }

        @Override
        public String toString() {
            String ret = new String();
            for (Map.Entry<T, Map<T, Integer>> vertex : adjacencyList.entrySet())
                ret += vertex.getKey() + ": " + vertex.getValue() + "\n";
            return ret;
        }


    }
}
