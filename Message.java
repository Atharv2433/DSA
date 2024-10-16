import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Message {
    private int vertices;
    private List<List<Integer>> adjList;

    public Message(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source); // For undirected graph
    }

    public void dfs(int start, int end, boolean[] vis, int current, int[] minCount) {
        vis[start] = true; // Mark the current node as visited

        // If the current node is the end node
        if (start == end) {
            minCount[0] = Math.min(minCount[0], current); // Update the minimum count
        }

        // Explore neighbors
        for (int neighbor : adjList.get(start)) {
            if (!vis[neighbor]) {
                dfs(neighbor, end, vis, current + 1, minCount); // Recursive DFS call
            }
        }

        vis[start] = false; // Backtrack
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();
        Message graph = new Message(n);

        System.out.print("Enter the number of edges: ");
        int m = scanner.nextInt();

        System.out.println("Enter the edges (source destination):");
        for (int i = 0; i < m; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        // Input for start and end nodes
        System.out.print("Enter the start node: ");
        int start = scanner.nextInt();
        System.out.print("Enter the end node: ");
        int end = scanner.nextInt();

        // Validate start and end nodes
        if (start < 0 || start >= n || end < 0 || end >= n) {
            System.out.println("Invalid start or end node.");
            return; // Exit if input is invalid
        }

        boolean[] vis = new boolean[n];
        int[] minCount = {Integer.MAX_VALUE};

        graph.dfs(start, end, vis, 0, minCount);

        // Output the minimum path length found
        if (minCount[0] == Integer.MAX_VALUE) {
            System.out.println("No path found from " + start + " to " + end);
        } else {
            System.out.println("Minimum path length from " + start + " to " + end + " is: " + (minCount[0] + 1)); // +1 to include the start node
        }

        scanner.close();
    }
}
