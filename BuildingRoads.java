import java.util.ArrayList;
import java.util.Scanner;

public class BuildingRoads {
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

    public BuildingRoads(int n) {
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // DFS to find components
    public void dfs(int node, ArrayList<Integer> components, boolean[] vis) {
        vis[node] = true;
        components.add(node);
        for (int neighbor : adjList.get(node)) { // Use adjList
            if (!vis[neighbor]) {
                dfs(neighbor, components, vis); // Corrected the parameter
            }
        }
    }

    // Find all components in the graph
    public ArrayList<ArrayList<Integer>> component(int n) {
        boolean[] vis = new boolean[n];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ArrayList<Integer> arr = new ArrayList<>();
                dfs(i, arr, vis); // Corrected the parameter
                res.add(arr);
            }
        }
        return res;
    }

    // Function to add an edge
    public void addEdge(int u, int v) {
        adjList.get(u - 1).add(v - 1);
        adjList.get(v - 1).add(u - 1);
    }

    // Print the graph
    public void printGraph() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print("Node " + (i + 1) + ": ");
            for (int j : adjList.get(i)) {
                System.out.print((j + 1) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of nodes
        int m = sc.nextInt(); // Number of edges

        BuildingRoads b = new BuildingRoads(n);

        // System.out.println("Enter the edges (u v) for the graph:");

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            b.addEdge(u, v);
        }
        // b.printGraph();

        // Finding the components
        ArrayList<ArrayList<Integer>> res = b.component(n);

        ArrayList<Integer> representatives = new ArrayList<>();

        if (res.size() > 1) {
            for (ArrayList<Integer> part : res) {
                representatives.add(part.get(0)); // Take one representative from each component
            }
            for (int i = 1; i < representatives.size(); i++) {
                System.out.print( (representatives.get(0) + 1));
                System.out.println( (representatives.get(i) + 1));
            }
        } else {
            System.out.println("IMPOSSIBLE");
            
        }

        sc.close(); // Close the scanner to prevent resource leaks
    }
}
