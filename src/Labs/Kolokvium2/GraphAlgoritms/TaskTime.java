package Labs.Kolokvium2.GraphAlgoritms;


import java.util.*;

public class TaskTime {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        AdjacencyListGraph g = new AdjacencyListGraph();
        Map<String, Integer> timesForTask = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            String task = tokens[0];
            int time = Integer.parseInt(tokens[1]);

            g.addVertex(task);
            timesForTask.put(task, time);
        }

        int m = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            String dependent = tokens[0];
            String taskToBeDoneFirst = tokens[1];

            g.addEdge(taskToBeDoneFirst, dependent);
        }

        System.out.println(calculate(g, timesForTask));
    }


//    public static List<String> topological(AdjacencyListGraph<String> g) {
//        Map<String, Integer> inDegree = new HashMap<>();
//        for (String vertex : g.adjacencyList.keySet()) {
//            inDegree.put(vertex, 0);
//        }
//        for (String vertex : g.adjacencyList.keySet()) {
//            for (String neighbor : g.adjacencyList.get(vertex)) {
//                inDegree.put(neighbor, inDegree.get(neighbor) + 1);
//            }
//        }
//
//        Queue<String> queue = new LinkedList<>();
//        for (String vertex : inDegree.keySet()) {
//            if (inDegree.get(vertex) == 0) {
//                queue.add(vertex);
//            }
//        }
//
//        List<String> result = new ArrayList<>();
//        while (!queue.isEmpty()) {
//            String current = queue.poll();
//            queue.add(current);
//
//            for (String neighbor : g.adjacencyList.getOrDefault(current, new HashSet<>())) {
//                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
//                if (inDegree.get(neighbor) == 0) {
//                    queue.add(neighbor);
//                }
//            }
//        }
//        return result;
//    }

    @SuppressWarnings("unchecked")
    private static int calculate(AdjacencyListGraph<String> g, Map<String, Integer> timesForTask) {
        //Za sekoj task, sumarno kolku e da se zavrsi
        Map<String, Integer> maxTimes = new HashMap<>();

        //topolosko na grafot i se cuva tuka
        List<String> sorted = g.topologicalSortNew();
//        List<String> sorted = topological(g);

        //krajniot rezultat
        int maxTime = 0;

        //za sekoj task pocnuvajki od temeto od koja zavisat "site" (poslednata tehnicki)
        for (String task : sorted) {
            //vremeto nejzino
            int curr = timesForTask.get(task);
            //za site sosedi, najdi go onaj sto kosta najmnogu da trosi
            for (String uslovTask : g.getIncomingNeighbors(task)) {
                //max od segasnoto vreme i maxTime za uslovniot task i vremeto da se izvrsi taskot
                //sto se ispituva
                curr = Math.max(curr, maxTimes.get(uslovTask) + timesForTask.get(task));
            }
            //obnovi za sekoe zafateno teme i vremeto
            maxTimes.put(task, curr);
            maxTime = Math.max(maxTime, curr);
        }
        //na kraj se prakja minimalnoto vreme da zavrsat site
        return maxTime;
    }

    @SuppressWarnings("unchecked")
    static class AdjacencyListGraph<T> {
        private Map<T, Set<T>> adjacencyList;
        private Map<T, Set<T>> incomingEdges;

        public AdjacencyListGraph() {
            this.adjacencyList = new HashMap<>();
            this.incomingEdges = new HashMap<>();
        }

        // Add a vertex to the graph
        public void addVertex(T vertex) {
            if (!adjacencyList.containsKey(vertex)) {
                adjacencyList.put(vertex, new HashSet<>());
            }
            if (!incomingEdges.containsKey(vertex)) {
                incomingEdges.put(vertex, new HashSet<>());
            }
        }

        // Remove a vertex from the graph
        public void removeVertex(T vertex) {
            // Remove the vertex from all adjacency lists
            for (Set<T> neighbors : adjacencyList.values()) {
                neighbors.remove(vertex);
            }
            // Remove the vertex's own entry in the adjacency list
            adjacencyList.remove(vertex);
        }

        // Add an edge to the graph
        public void addEdge(T source, T destination) {
            addVertex(source);
            addVertex(destination);

            adjacencyList.get(source).add(destination);
            incomingEdges.get(destination).add(source);
        }

        // Remove an edge from the graph
        public void removeEdge(T source, T destination) {
            if (adjacencyList.containsKey(source)) {
                adjacencyList.get(source).remove(destination);
            }
        }

        // Get all neighbors of a vertex
        public Set<T> getNeighbors(T vertex) {
            return adjacencyList.getOrDefault(vertex, new HashSet<>());
        }

        public Set<T> getIncomingNeighbors(T vertex) {
            return incomingEdges.getOrDefault(vertex, new HashSet<>());
        }

        //Kahn’s Algorithm (First Implementation)
        public List<T> topologicalSortNew() {
            Map<T, Integer> inDegree = new HashMap<>();
            //Inicijalizacija na site teminja na 0
            for (T vertex : adjacencyList.keySet()) {
                inDegree.put(vertex, 0);
            }
            //Za sekoj sosed na dadeno teme, ako pokazuva kon sosedot
            //zgolemi za 1
            for (T vertex : adjacencyList.keySet()) {
                for (T neighbor : adjacencyList.get(vertex)) {
                    inDegree.put(neighbor, inDegree.get(neighbor) + 1);
                }
            }

            //Inicijaliziraj redica, kade se procesiraat
            //tie sto nemaat zavisnosti
            Queue<T> queue = new LinkedList<>();
            for (T vertex : inDegree.keySet()) {
                if (inDegree.get(vertex) == 0) {
                    queue.add(vertex);
                }
            }
            //Lista za topolosko sortiranje
            List<T> sorted = new ArrayList<>();
            while (!queue.isEmpty()) {
                //prviot sto e nezavisen
                T current = queue.poll();
                sorted.add(current);

                //za negovite sosedi, gi odzemame zavisnostite, ako
                //stanuvaat nezavisni, i niv vo redicata
                for (T neighbor : adjacencyList.getOrDefault(current, new HashSet<>())) {
                    inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                    if (inDegree.get(neighbor) == 0) {
                        queue.add(neighbor);
                    }
                }
            }
            //Vrati topolosko sortirana niza
            return sorted;
        }

        public void DFS(T startVertex) {
            Set<T> visited = new HashSet<>();
            DFSUtil(startVertex, visited);
        }

        private void DFSUtil(T vertex, Set<T> visited) {
            // Mark the current node as visited and print it
            visited.add(vertex);
            System.out.print(vertex + " ");

            // Recur for all the vertices adjacent to this vertex
            for (T neighbor : getNeighbors(vertex)) {
                if (!visited.contains(neighbor)) {
                    DFSUtil(neighbor, visited);
                }
            }
        }


        public void DFSNonRecursive(T startVertex) {
            Set<T> visited = new HashSet<>();
            Stack<T> stack = new Stack<>();

            stack.push(startVertex);
            while (!stack.isEmpty()) {
                T vertex = stack.pop();
                if (!visited.contains(vertex)) {
                    visited.add(vertex);
                    System.out.print(vertex + " ");
                    for (T neighbor : getNeighbors(vertex)) {
                        if (!visited.contains(neighbor)) {
                            stack.push(neighbor);
                        }
                    }
                }
            }
        }

        public void printPath(T source, T destination) {
            Set<T> visited = new HashSet<>();
            Stack<T> stack = new Stack<>();

            stack.push(source);
            visited.add(source);
            while (!stack.isEmpty() && !stack.peek().equals(destination)) {
                T vertex = stack.peek();

                boolean f = true;
                for (T neighbor : getNeighbors(vertex)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                        visited.add(neighbor);
                        f = false;
                        break;
                    }
                }

                if (f) {
                    stack.pop();
                }
            }

            Stack<T> path = new Stack<>();

            while (!stack.isEmpty()) {
                path.push(stack.pop());
            }

            while (!path.isEmpty()) {
                System.out.print(path.pop() + " ");
            }
        }

        public void BFS(T startVertex) {
            Set<T> visited = new HashSet<>();
            Queue<T> queue = new LinkedList<>();

            visited.add(startVertex);
            queue.add(startVertex);

            while (!queue.isEmpty()) {
                T vertex = queue.poll();
                System.out.print(vertex + " ");

                for (T neighbor : getNeighbors(vertex)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }


        //Depth-First Search (DFS) Based Topological Sort (Second Implementation)
        public List<T> topologicalSort() {
            Stack<T> stack = new Stack<>();
            Set<T> visited = new HashSet<>();

            for (T vertex : adjacencyList.keySet()) {
                if (!visited.contains(vertex)) {
                    topologicalSortUtil(vertex, visited, stack);
                }
            }

            List<T> order = new ArrayList<>();
            while (!stack.isEmpty()) {
                order.add(stack.pop());
            }
            return order;
        }

        // DFS utility function used for topological sorting
        // recursive + stack - for order of execution
        private void topologicalSortUtil(T vertex, Set<T> visited, Stack<T> stack) {
            visited.add(vertex);
            for (T neighbor : getNeighbors(vertex)) {
                if (!visited.contains(neighbor)) {
                    topologicalSortUtil(neighbor, visited, stack);
                }
            }
            stack.push(vertex);
        }


        @Override
        public String toString() {
            String ret = new String();
            for (Map.Entry<T, Set<T>> vertex : adjacencyList.entrySet())
                ret += vertex.getKey() + ": " + vertex.getValue() + "\n";
            return ret;
        }


    }
}
