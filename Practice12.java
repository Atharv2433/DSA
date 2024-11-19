package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Practice12 {

    public static void pushAtBottom(Stack<Integer> st , int data){
        if(st.isEmpty()){
            st.push(data);
            return;
        }

        int top = st.pop();
        pushAtBottom(st, data);
        st.push(top);
    }

    public static void reverse(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int top = st.pop();
        reverse(st);
        pushAtBottom(st, top);
    }
    

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);


        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(7);
        st.push(8);

        int data = 9;

        reverse(st);

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
        System.out.println();
    }
}
