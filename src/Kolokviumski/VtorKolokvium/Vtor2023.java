package Kolokviumski.VtorKolokvium;

    /*
    8
    carrot
    dog
    banana

    elephant
    cherry
    boat
    dolphin
    cat

    result:
    4

    carrot banana cherry - same num -> 3 pairs
    dog cat -> same num -> 4 pair
    */


import Packages.GraphsAlgos.matrica_tezinski_nenasocen.AdjacencyMatrixGraph;
import Packages.GraphsAlgos.matrica_tezinski_nenasocen.Edge;

import java.util.*;

public class Vtor2023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        AdjacencyMatrixGraph<String> graph = new AdjacencyMatrixGraph<>(N);

        Map<String, Integer> vertices = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int fromIndex = sc.nextInt();
            String fromName = sc.next();
            int toIndex = sc.nextInt();
            String toName = sc.next();
            int distance = sc.nextInt();

            vertices.put(fromName, fromIndex);
            vertices.put(toName, toIndex);

            graph.addVertex(fromIndex, fromName);
            graph.addVertex(toIndex, toName);
            graph.addEdge(fromIndex, toIndex, distance);
        }

        String startName = sc.next();
        int startIndex = vertices.get(startName);

        List<Edge> result = graph.prim(startIndex);

        int sum = 0;
        for (Edge edge : result) {
            sum += edge.getWeight();
        }
        System.out.println(sum);
    }
}
