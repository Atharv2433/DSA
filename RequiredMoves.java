package Strings;

import java.util.Scanner;

public class RequiredMoves {

    public static int fun(String s){
        int tm = 0;
        char prev = 'a';
        char arr[] = s.toCharArray();

        for(char ch : arr){
            int mini2 = Math.min(prev - 'a' + 'z' - ch + 1 ,  'z' - prev +  ch  - 'a' + 1);
            System.out.println(mini2);
            int mini = Math.min(Math.abs(ch - prev) , mini2);
            
            tm += mini + 1; 
            prev = ch;
        }
        return tm;
    }
    public static void main(String args[]){


        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(fun(s));

    }

}
