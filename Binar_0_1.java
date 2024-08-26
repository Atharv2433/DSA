public class Binar_0_1{
    public static void add_str(int n,int last_place,String s){
        if(n == 0){
             System.err.println(s);
             return ;
        }
        add_str(n-1,0,s+'0');
        if(last_place == 0){
            add_str(n-1,1,s+'1');
        }
    }
    public static void main(String[] args){
        int n = 3;
        String s = "";
        add_str(n,0,s);
    }
}