import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Xenia {
    ArrayList<Integer> seg;

    // Constructor to initialize the segment tree
    Xenia(int n) {
        seg = new ArrayList<>(Collections.nCopies(4 * n, 0)); // Initialize with 0s
    }

    public void buildtree(int ind, int low, int high, int arr[], boolean or) {
        if (low == high) {
            seg.set(ind, arr[low]); // Set the leaf node in segment tree
            return;
        }
        int mid = (low + high) / 2;
        buildtree(2 * ind + 1, low, mid, arr, !or);
        buildtree(2 * ind + 2, mid + 1, high, arr, !or);

        // Perform bitwise OR operation
        if (or) {
            seg.set(ind, seg.get(2 * ind + 1) | seg.get(2 * ind + 2));
        } else {
            seg.set(ind, seg.get(2 * ind + 1) ^ seg.get(2 * ind + 2)); // Assuming you want to do AND here
        }
    }

    public int query(int ind, int low, int high, int l, int r, boolean or) {
        // Out of range
        if (r < low || l > high) {
            return (or) ? 0 : Integer.MAX_VALUE; // Identity for OR (0) or AND (MAX_VALUE)
        }
        // Current segment is fully within the range
        if (l <= low && high <= r) {
            return seg.get(ind); // Return the node value
        }
        int mid = (low + high) / 2;
        int left = query(2 * ind + 1, low, mid, l, r, !or);
        int right = query(2 * ind + 2, mid + 1, high, l, r, !or);

        return (or) ? (left | right) : (left ^ right); // Combine results
    }

    public void update(int ind, int i, int val, int low, int high, boolean or) {
        if (low == high) {
            seg.set(ind, val); // Update the leaf node
            return;
        }
        int mid = (low + high) / 2;

        if (i <= mid) {
            update(2 * ind + 1, i, val, low, mid, !or); // Update left subtree
        } else {
            update(2 * ind + 2, i, val, mid + 1, high, !or); // Update right subtree
        }

        // Perform bitwise operation
        if (or) {
            seg.set(ind, seg.get(2 * ind + 1) | seg.get(2 * ind + 2));
        } else {
            seg.set(ind, seg.get(2 * ind + 1) ^ seg.get(2 * ind + 2)); // Assuming you want to do AND here
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // Input elements
        }

        boolean operation = false;
        if(n % 2 != 0){
            operation = true;
        }else{
            operation = false;
        }
       

        // Create the segment tree
        Xenia x = new Xenia(n);
        x.buildtree(0, 0, n - 1, arr, operation);

        // Query the segment tree
        System.out.println("Enter the range [L R] for query (0-indexed): ");
        int l = sc.nextInt();
        int r = sc.nextInt();
        int result = x.query(0, 0, n - 1, l, r, operation);
        System.out.println("Result of the query: " + result);

        // Update the segment tree
        System.out.println("Enter index and new value for update (0-indexed): ");
        int i = sc.nextInt();
        int val = sc.nextInt();
        x.update(0, i, val, 0, n - 1, operation);

        // Print updated segment tree
        System.out.println("Updated segment tree:");
        for (int j = 0; j < x.seg.size(); j++) {
            System.out.println("seg[" + j + "] = " + x.seg.get(j));
        }

        sc.close();
    }
}
