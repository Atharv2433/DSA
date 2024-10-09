import java.util.Scanner;

public class MinimumOperations {
    public static int fun(int n,int k){

        if(k == 1){
            return n;
        }
        int sum = 0;
        while(n > 0){
            sum += n % k;
            n /=k;
        }
       return sum;
    }
    public static void main(String args[]){
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        while(t != 0){
            int n,k;
            n = sc.nextInt();
            k = sc.nextInt();

            int res = fun(n,k);
            System.out.println(res);
        }
    }
}
