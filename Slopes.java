package Patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Slopes {

    public static class Pair {
        int src, dest;

        public Pair(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return src == pair.src && dest == pair.dest;
        }

        @Override
        public int hashCode() {
            int result = Integer.hashCode(src);
            result = 31 * result + Integer.hashCode(dest);
            return result;
        }
    }

    // Function to calculate GCD
    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    // Function to calculate the maximum number of points on a line
    public static int fun(int arr[][]) {
        int n = arr.length;
        int maxi = 0;

        for (int i = 0; i < n; i++) {
            Map<Pair, Integer> mpp = new HashMap<>();
            int dup = 0;

            for (int j = i + 1; j < n; j++) { // Start from j = i + 1
                int dy = arr[j][1] - arr[i][1];
                int dx = arr[j][0] - arr[i][0];

                // Check for duplicate points
                if (dx == 0 && dy == 0) {
                    dup++;
                } else {
                    // Normalize the slope using GCD
                    int gc = gcd(Math.abs(dx), Math.abs(dy)); // Avoid negative GCD
                    dx /= gc;
                    dy /= gc;

                    // Ensure a consistent representation of the slope
                    if (dx < 0) {
                        dx = -dx;
                        dy = -dy;
                    } else if (dx == 0) { // Vertical line, normalize dy to positive
                        dy = Math.abs(dy);
                    }

                    Pair slope = new Pair(dx, dy);
                    mpp.put(slope, mpp.getOrDefault(slope, 0) + 1);
                }
            }

            // Calculate the maximum points on a line through point i
            for (int count : mpp.values()) {
                maxi = Math.max(maxi, count + dup + 1); // Include duplicates and the current point
            }

            maxi = Math.max(maxi, dup + 1); // Handle all points being duplicates
        }

        return maxi;
    }

    public static void main(String[] args)
    throws ArithmeticException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        System.out.println(fun(arr));
    }
}
