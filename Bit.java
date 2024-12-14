import java.util.Scanner;

public class Bit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner to read input
        int n = sc.nextInt(); // Number of operations
        int x = 0; // Initialize x to 0

        while (n-- > 0) { // Loop n times
            String s = sc.next(); // Read each operation as a string
            if (s.charAt(1) == '+') { // Check if the second character is '+'
                ++x; // Increment x
            } else {
                --x; // Decrement x
            }
        }


        
        System.out.println(x); // Output the final value of x
        sc.close(); // Close the scanner
    }
}
