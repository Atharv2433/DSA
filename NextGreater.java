package Stack;

import java.util.Scanner;
import java.util.Stack;

public class NextGreater {
    

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new   int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int nextInd[] = new int[n];

        Stack<Integer> st = new Stack<>();

        int size = 0;
        for(int i = 0 ; i <= arr.length - 1; i++){

            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                nextInd[i] = 0;
            }
            else{
                nextInd[i] = st.size();
            }
            
            st.push(i);
        }

        for(int i = 0; i < n; i++){
            System.out.print(nextInd[i] + " ");
        }
        System.out.println();
    }
}
