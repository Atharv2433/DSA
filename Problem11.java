package Problem11;

import java.util.Scanner;

public class Problem11 {
    
    public static int[] fun(int arr[]){
        int n = arr.length - 1;
        int s2 = (n * (n + 1)) /2;
        int s2n = (n * (n + 1)) * (2 * n + 1) / 6;

        int s = 0;
        int s1 = 0;

        for(int i = 0; i < n; i++){
            s += arr[i];
            s1 += arr[i] * arr[i];
        }   

        int val1 = s - s2;
        int val2 = s1 - s2n;

        val2 = val2 / val1;

        int x = (val1 + val2) / 2;
        int y = x - val1;


        return new int[] {x , y};
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int res[] = fun(arr);

        for(int i = 0; i <res.length; i++){
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
