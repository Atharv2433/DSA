public class Solution_1{
    public static void even_odd(int n){
        int bitmask = 1;
        if((n & bitmask) == 0){
            System.out.println("Even Number ");
        }
        else{
            System.out.println("Odd Number ");
        }
    }

    public static int get_bit(int n , int i){
        int bitmask = 1<<i;
        if((n & bitmask) == 0){
           return 0;
        }
        else{
            return 1;
        }
    }

    public static int set_bit(int n,int i){
        int bitmask =1<<i;
        return n | bitmask;
    }

    public static void main(String[] args){
        even_odd(11);
        even_odd(3);
        int g = get_bit(10,2);
        System.out.println(g);
        int s =set_bit(10,2);
        System.out.println(s);
    }
}