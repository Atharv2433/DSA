package Ecluers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class ValidArrangeMent {

    Map<Integer, ArrayList<Integer>> adj;  // Adjacency list map (node -> list of outgoing nodes)
    Map<Integer, Integer> indegree;         // In-degree map (node -> in-degree)
    Map<Integer, Integer> outdegree;        // Out-degree map (node -> out-degree)

    public ValidArrangeMent() {
        adj = new HashMap<>();
        indegree = new HashMap<>();
        outdegree = new HashMap<>();
    }

    // Add edge from src to dest
    public void addEdge(int src, int dest) {
        adj.putIfAbsent(src, new ArrayList<>());
        adj.get(src).add(dest);
        
        indegree.put(dest, indegree.getOrDefault(dest, 0) + 1);
        outdegree.put(src, outdegree.getOrDefault(src, 0) + 1);
    }

    // Hierholzer's algorithm to find Eulerian path
    public void findEulerianPath(List<Integer> ans) {
        Stack<Integer> stack = new Stack<>();
        int startNode = -1;

        // Find the starting node: it will have outdegree > indegree
        for (int node : outdegree.keySet()) {
            if (outdegree.getOrDefault(node, 0) - indegree.getOrDefault(node, 0) == 1) {
                startNode = node;
                break;
            }
        }

        // If no start node found, pick any node with outgoing edges
        if (startNode == -1) {
            for (int node : outdegree.keySet()) {
                if (outdegree.getOrDefault(node, 0) > 0) {
                    startNode = node;
                    break;
                }
            }
        }

        stack.push(startNode);

        // Traverse the graph using the stack
        while (!stack.isEmpty()) {
            int current = stack.peek();

            if (adj.containsKey(current) && !adj.get(current).isEmpty()) {
                // Continue to the next node
                int next = adj.get(current).remove(adj.get(current).size() - 1);
                outdegree.put(current, outdegree.get(current) - 1);
                stack.push(next);
            } else {
                ans.add(stack.pop());
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Number of edges
        int[][] edges = new int[n][2];

        // Read edges
        for (int i = 0; i < n; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        // Create graph and add edges
        ValidArrangeMent graph = new ValidArrangeMent();
        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1]);
        }

        // Find Eulerian path
        List<Integer> ans = new ArrayList<>();
        graph.findEulerianPath(ans);

        // Output the result in the correct order
        for (int i = ans.size() - 1; i >= 0; i--) {
            System.out.print(ans.get(i) + (i > 0 ? " " : "\n"));
        }
    }
}
