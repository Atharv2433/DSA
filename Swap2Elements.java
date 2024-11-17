package BitManipulation;

import java.util.Scanner;

public class Swap2Elements {
    
    public static void swap(int a , int b){
        a = a ^ b;
        b = a ^ b;
        a = b ^ a;
        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        swap(n, m);
        
    }
}
