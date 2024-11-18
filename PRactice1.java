package BitManipulation;

import java.util.ArrayList;
import java.util.Scanner;

public class PRactice1 {

    public static void swap(int a , int b){
        a = a ^ b;
        b = a ^ b;
        a = b ^ a;
        
        System.out.println(a);
        System.out.println(b);
    }

    public static boolean isSet(int n , int k){
        if((n & 1 << k) != 0){
            return true;
        }
        return false;
    }

    public static ArrayList<ArrayList<Integer>> generate(int arr[] , int n){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(n == 0){
            return ans;
        }
        int subsets = 1 << n;

        for(int i = 0; i < subsets; i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j = 0; j < n ; j++){
                if((i & (1 << j)) != 0){
                    row.add(arr[j]);
                }
            }
            ans.add(row);
        }
        return ans;
    }

    public static boolean isPower(int n){

        if((n & n - 1) == 0){
            return true;
        }
        return false;
    }
    
    public static void setKthbit(int n, int k){

        int newn = n | (1 << k);

        System.out.println(newn);
    }

    public static void clearBit(int n , int k){
        int newn = n & ~(1 << k);

        System.out.println(newn);
    }

    public static void countBits(int n){
        int count = 0;

        while(n > 0){
            if((n & 1) == 1){
                count++;
            }
            n = n >> 1;
        }
        System.out.println(count);
    }

    public static void countBits2(int n){
        int count = 0;

        while(n > 0){
            n = (n & n - 1);
            count++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }


        swap(n, m);
        System.out.println(isSet(n, m));

        

        ArrayList<ArrayList<Integer>> ans = generate(arr,n);

        for(int i = 0; i < ans.size(); i++){
            for(int it : ans.get(i)){
                System.out.print(it);
            }
            System.out.println();
        }
        System.out.println(isPower(n));

        setKthbit(n, m);
        clearBit(n, m);
        countBits(n);
        countBits2(n);
    }
}
