package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Kmul {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i = 0; i < n; i++){
            pq.add(arr[i]);

            if(pq.size() > k){
                pq.poll();
            }
        }

        int total = 1;
        while(!pq.isEmpty()){
             total *= pq.poll(); 
        }

        System.out.println(total);
    }
}
