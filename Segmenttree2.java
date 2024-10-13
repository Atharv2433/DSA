import java.util.ArrayList;
import java.util.Scanner;

public class Segmenttree2 {
    ArrayList<Integer> seg;

    // Constructor to initialize the segment tree array list
    Segmenttree2(int n) {
        seg = new ArrayList<>(4 * n);
        for (int i = 0; i < 4 * n; i++) {
            seg.add(0); // Initialize with 0s
        }
    }

    // Build tree function (not static, since we're using instance variables)
    public void buildtree(int ind, int low, int high, int arr[]) {
        if (low == high) {
            seg.set(ind, arr[low]);  // Set the leaf node in segment tree
            return;
        }
        int mid = (low + high) / 2;
        buildtree(2 * ind + 1, low, mid, arr);    // Build the left subtree
        buildtree(2 * ind + 2, mid + 1, high, arr); // Build the right subtree

        // Set the current node as the minimum of its two children
        seg.set(ind, Math.min(seg.get(2 * ind + 1), seg.get(2 * ind + 2)));
    }

    // Query function to get the minimum in range [l, r]
    public int query(int ind, int low, int high, int l, int r) {
        if (r < low || l > high) {
            return Integer.MAX_VALUE;  // Outside the range, return infinity
        }
        if (l <= low && high <= r) {
            return seg.get(ind);  // Inside the range, return the node value
        }
        int mid = (low + high) / 2;
        int left = query(2 * ind + 1, low, mid, l, r);  // Query left subtree
        int right = query(2 * ind + 2, mid + 1, high, l, r); // Query right subtree
        return Math.min(left, right);  // Return the minimum of both sides
    }

    // Update function to change value at index i
    public void update(int ind, int val, int i, int low, int high) {
        if (low == high) {
            seg.set(ind, val);  // Set the leaf node with the new value
            return;
        }
        int mid = (low + high) / 2;
        if (i <= mid) {
            update(2 * ind + 1, val, i, low, mid);  // Update the left subtree
        } else {
            update(2 * ind + 2, val, i, mid + 1, high);  // Update the right subtree
        }
        // After update, recalculate the current node's value
        seg.set(ind, Math.min(seg.get(2 * ind + 1), seg.get(2 * ind + 2)));
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // Number of elements in the array
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();  // Input elements
        }

        Segmenttree2 segmentTree = new Segmenttree2(n);
        segmentTree.buildtree(0, 0, n - 1, arr);  // Build the segment tree

        System.out.println("Enter L & R -: ");
        int l = sc.nextInt();
        int r = sc.nextInt();

        int res = segmentTree.query(0, 0, n - 1, l, r);  // Query the minimum value in range [l, r]
        System.out.println("Minimum value in range [" + l + ", " + r + "]: " + res);

        System.out.println("Enter I & Val -: ");
        int i = sc.nextInt();
        int val = sc.nextInt();
        segmentTree.update(0, val, i, 0, n - 1);  // Update the value at index i
        arr[i] = val;

        System.out.println("Updated array:");
        for (int j = 0; j < n; j++) {
            System.out.println(arr[j]);  // Print updated array
        }

        sc.close();
    }
}
