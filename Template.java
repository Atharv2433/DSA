package Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Template {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            pq.offer(arr[i]);

            if(pq.size() > 2){
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
        
    }
    
}
