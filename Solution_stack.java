import java.util.Stack;

public class Solution_stack {
public static void push_at_bottom(Stack<Integer> st , int data){
        if(st.empty()){
            st.push(data);
            return;
        }
        int top = st.pop();
        push_at_bottom(st,data);
        st.push(top);
    }

public static String rev_using_stack(String str){
    Stack<Character> s = new Stack<>();
    int index = 0;
    int n = str.length();
    while (index<n) {
        s.push(str.charAt(index));
        index++;    
    }

    StringBuilder sb = new StringBuilder("");
    while (!s.empty()) {
        char st = s.pop();
        sb.append(st); 
    }
    return sb.toString();
}

public static void rev_stack(Stack<Integer> s){
    if(s.empty()){
        return;
    }
    int top = s.pop();
    rev_stack(s);
    push_at_bottom(s,top);
}


    public static void main(String[] args){
        Stack<Integer> st = new Stack<Integer>();
        st.push(1);
        st.push(2);
        st.push(3);
    
        push_at_bottom(st,4);
    
        while(!st.empty()){
            System.out.println(st.pop()); 
        }
        String s = "Hello";
        String str_1 = rev_using_stack(s);

        System.out.println(str_1);

        rev_stack(st);

        while (st.empty()) {
            System.out.println(st.pop());    
        }

     
    }


}

