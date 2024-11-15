package Strings;

import java.util.Scanner;

public class LargestOddNumber {

    public static String largetsOdd(String s){
        int n = s.length() - 1;

        while(n >= 0){
            if((s.charAt(n) - '0') % 2 != 0){
                return s.substring(0, n + 1);
            }
            n--;
        }
        return "";
    }

    public static String largestEven(String s){
        int n = s.length() - 1;

        while(n >= 0){
            if((s.charAt(n) - '0')% 2 == 0){
                return s.substring(0, n + 1);
            }
        }
        return "";
    }
    

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();

        System.out.println(largetsOdd(s));
        System.out.println(largestEven(s));
    }
}
