import java.util.Scanner;

public class Total_ways{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t >0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int res = 1;
            

            while(a  > 0 || b > 1){
                if((a & 1) == 1){
                    if((b & 1) == 1){
                        res = res * 2;
                    }else{
                        res = 0;
                        break;
                    }
                }
                a>>=1;
                b>>=1;
            }
            System.out.println(res);

            t--;
        }
    }
}