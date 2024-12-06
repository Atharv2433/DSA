package PracticeGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Islands2 {

    public static int findParent(int node, int parent[]) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findParent(parent[node], parent);
    }

    public static void union(int u, int v, int parent[]) {
        int ulp = findParent(u, parent); // Find parent of u
        int vlp = findParent(v, parent); // Find parent of v
        if (ulp != vlp) {
            parent[ulp] = vlp; // Union
        }
    }

    public static List<Integer> fun(int[][] arr, int[][] arr2) {
        int n = arr.length;
        int m = arr[0].length;

        int parent[] = new int[n * m];
        Arrays.fill(parent, -1);

        int components = 0;
        List<Integer> islands = new ArrayList<>();

        // Directions for exploring neighbors (up, right, down, left)
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};

        for (int[] it : arr2) {
            int x = it[0];
            int y = it[1];
            int cell = x * m + y;

            // If already land, return current number of components
            if (parent[cell] != -1) {
                islands.add(components);
                continue;
            }

            // Add new land
            parent[cell] = cell;
            components++;

            // Check neighbors
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int neighbor = nx * m + ny;

                    if (parent[neighbor] != -1) { // Neighbor is part of the grid
                        int parentCell = findParent(cell, parent);
                        int parentNeighbor = findParent(neighbor, parent);

                        if (parentCell != parentNeighbor) {
                            union(cell, neighbor, parent);
                            components--; // Merge reduces the number of components
                        }
                    }
                }
            }
            islands.add(components);
        }

        return islands;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[][] = new int[n][m]; // Initial grid

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int n2 = sc.nextInt();
        int arr2[][] = new int[n2][2];

        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < 2; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }

        System.out.println(fun(arr, arr2));
        sc.close();
    }
}
