package Problem12;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountInversions {

    int seg[];

    // Constructor to initialize segment tree
    public CountInversions(int n) {
        seg = new int[4 * n];
    }

    // Update the Segment Tree
    public void update(int ind, int low, int high, int i, int val) {
        if (low == high) {
            seg[ind] += val;
            return;
        }

        int mid = (low + high) / 2;
        if (i <= mid) {
            update(2 * ind + 1, low, mid, i, val); // Update left child
        } else {
            update(2 * ind + 2, mid + 1, high, i, val); // Update right child
        }

        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2]; // Merge results
    }

    // Query to find the sum in a given range
    public int query(int ind, int low, int high, int l, int r) {
        if (r < low || l > high) {
            return 0; // Out of range
        }

        if (l <= low && high <= r) {
            return seg[ind]; // Completely within range
        }

        int mid = (low + high) / 2;
        int left = query(2 * ind + 1, low, mid, l, r); // Query left subtree
        int right = query(2 * ind + 2, mid + 1, high, l, r); // Query right subtree

        return left + right;
    }

    // Count inversions in the array
    public int countInversions(int[] arr) {
        // Step 1: Coordinate Compression
        int n = arr.length;
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(sortedArr[i], i + 1); // Map original values to compressed values
        }

        // Step 2: Process the array in reverse order
        int inversions = 0;
        for (int i = n - 1; i >= 0; i--) {
            int compressedValue = map.get(arr[i]);

            // Count elements less than the current element
            inversions += query(0, 0, n - 1, 0, compressedValue - 1);

            // Insert the current element into the Segment Tree
            update(0, 0, n - 1, compressedValue, 1);
        }

        return inversions;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Initialize Segment Tree
        CountInversions ci = new CountInversions(n);

        // Count inversions
        int result = ci.countInversions(arr);
        System.out.println("Number of inversions: " + result);
    }
}
