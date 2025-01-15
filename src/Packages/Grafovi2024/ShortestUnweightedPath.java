package Packages.Grafovi2024;


import java.util.Scanner;

public class ShortestUnweightedPath {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int edges = sc.nextInt();
        sc.nextLine();
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<String>();
        for (int i = 0; i < edges; i++){
            String[] cities = sc.nextLine().split(",");
            graph.addEdge(cities[0], cities[1]);
        }
        String startCity = sc.nextLine();
        String endCity = sc.nextLine();

        System.out.println("Steps needed to get from " + startCity + " to "
                + endCity + ": " + graph.shortestPath(startCity, endCity));

    }
}
