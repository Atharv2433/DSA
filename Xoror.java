import java.util.ArrayList;
import java.util.Scanner;

public class Xoror {
    ArrayList<Integer> seg;

    public Xoror(int n) {
        seg = new ArrayList<>(n * 4);
        for (int i = 0; i < n * 4; i++) {
            seg.add(0);
        }
    }

    public void buildtree(int ind, int low, int high, int arr[], boolean or) {
        if (low == high) {
            seg.set(ind, arr[low]);
            return;
        }
        int mid = (low + high) / 2;
        buildtree(2 * ind + 1, low, mid, arr, !or);
        buildtree(2 * ind + 2, mid + 1, high, arr, !or);
        if (or) {
            seg.set(ind, seg.get(2 * ind + 1) | seg.get(2 * ind + 2));
        } else {
            seg.set(ind, seg.get(2 * ind + 1) ^ seg.get(2 * ind + 2));
        }
    }

    public int query(int ind, int low, int high, int l, int r, boolean or) {
        if (r < low || l > high) {
            return or ? 0 : Integer.MAX_VALUE;
        }
        if (l <= low && high <= r) {
            return seg.get(ind);
        }
        int mid = (low + high) / 2;
        int left = query(2 * ind + 1, low, mid, l, r, !or);
        int right = query(2 * ind + 2, mid + 1, high, l, r, !or);
        return or ? (left | right) : (left ^ right);
    }

    public void update(int ind, int i, int val, int low, int high, boolean or) {
        if (low == high) {
            seg.set(ind, val);
            return;
        }
        int mid = (low + high) / 2;
        if (i <= mid) {
            update(2 * ind + 1, i, val, low, mid, !or);
        } else {
            update(2 * ind + 2, i, val, mid + 1, high, !or);
        }
        if (or) {
            seg.set(ind, seg.get(2 * ind + 1) | seg.get(2 * ind + 2));
        } else {
            seg.set(ind, seg.get(2 * ind + 1) ^ seg.get(2 * ind + 2));
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Xoror x = new Xoror(n);
        boolean flag = (n % 2 != 0);
        x.buildtree(0, 0, n - 1, arr, flag);

        System.out.print("Enter number of updates: ");
        int t = sc.nextInt();
        while (t > 0) {
            System.out.print("Enter index to update and new value: ");
            int i = sc.nextInt();
            int val = sc.nextInt();
            i--; // Convert to 0-based index
            
            if (i >= 0 && i < n) {
                x.update(0, i, val, 0, n - 1, flag);
                arr[i] = val; // Update the array

                // Output the updated segment tree root value (as an example)
                System.out.println("Updated segment tree root value: " + x.seg.get(0));
            } else {
                System.out.println("Index out of bounds. Try again.");
            }
            t--;
        }

        // Example query after updates
        System.out.print("Enter query range (l r): ");
        int l = sc.nextInt() - 1; // Convert to 0-based index
        int r = sc.nextInt() - 1; // Convert to 0-based index
        System.out.println("Query result: " + x.query(0, 0, n - 1, l, r, flag));

        sc.close();
    }
}
