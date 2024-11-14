package BitManipulation;

import java.util.Scanner;

public class PowerOf2 {

    public static boolean check(int n){
        if((n & n - 1) == 0){
            return true;
        }
        return false;
    }
    

    public static void main(String[] args) {
        
        Scanner  sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(check(n));
    }
}
