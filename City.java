import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int destination;
    int distance;

    Pair(int destination, int distance) {
        this.destination = destination;
        this.distance = distance;
    }
}

public class City {
    public Map<Integer, ArrayList<Pair>> adj;

    public City() {
        adj = new HashMap<>(); // Use a HashMap for dynamic sizing
    }

    public void addedge(int source, int destination, int distance) {
        // Ensure both nodes are in the map
        adj.putIfAbsent(source, new ArrayList<>());
        adj.putIfAbsent(destination, new ArrayList<>());
        
        // Add edges in both directions
        adj.get(source).add(new Pair(destination, distance));
        adj.get(destination).add(new Pair(source, distance)); // Undirected graph
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of nodes (can be any value)

        City c = new City();
        int m = sc.nextInt(); // Number of edges

        for (int i = 0; i < m; i++) {
            // Read 1-based indexed nodes
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int distance = sc.nextInt();
            c.addedge(source, destination, distance);
        }

        // Debugging output: print the adjacency list
        System.out.println("Adjacency List:");
        for (Map.Entry<Integer, ArrayList<Pair>> entry : c.adj.entrySet()) {
            System.out.print("Node " + entry.getKey() + ": ");
            for (Pair pair : entry.getValue()) {
                System.out.print("(to " + pair.destination + ", distance " + pair.distance + ") ");
            }
            System.out.println();
        }

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> dis = new ArrayList<>();
        
        // Initialize distances (1-based, so we add one extra slot)
        for (int i = 0; i <= n; i++) {  // Change from < n to <= n to accommodate 1-based index
            dis.add(Integer.MAX_VALUE);
        }

        // Set the distance for the starting node (1)
        int startNode = 1; // Start from node 1
        dis.set(startNode, 0); 
        q.offer(startNode);

        // BFS or Dijkstra's algorithm
        while (!q.isEmpty()) {
            int node = q.poll(); // Get the front node

            // Traverse through all adjacent nodes (neighbors)
            for (Pair pair : c.adj.getOrDefault(node, new ArrayList<>())) {
                int neighbor = pair.destination;
                int edgeDistance = pair.distance;

                // Check if a shorter path to neighbor has been found
                if (dis.get(node) + edgeDistance < dis.get(neighbor)) {
                    dis.set(neighbor, dis.get(node) + edgeDistance); // Update distance
                    q.offer(neighbor); // Offer the neighbor to the queue
                }
            }
        }

        // Output the shortest distances from the starting node
        System.out.println("Shortest distances from node " + startNode + ":");
        for (int i = 1; i <= n; i++) { // Iterate from 1 to n for 1-based index
            System.out.println("Distance to node " + i + ": " + dis.get(i));
        }

        sc.close(); // Close the scanner
    }
}
