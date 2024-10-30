package BinarySearch;

import java.util.Scanner;

public class Floor{
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for(int  i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int key = sc.nextInt();

        int left = 0;
        int right = n-1;

        int res = -1;

        while(left <= right){
            int mid = (left + right)/2;

            if(arr[mid] == key){
                res = mid;
                return;
            }

            else if(arr[mid] < key){
                res = mid;
                left = mid + 1;
            }
            else{
                res = left;
                right = mid - 1;
            }
        }
        System.out.println(res);

        left = 0;
        res = 0;
        right = n-1;

        while(left <= right){
            int mid = (left + right)/2;

            if(arr[mid] == key){
                res = mid;
                return;
            }
            else if(arr[mid] < key){
                res = right;
                left = mid + 1;
            }else{
                res = mid;
                right = mid -1;
            }
        }
        System.out.println(res);
    }
}