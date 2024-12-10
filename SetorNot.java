import java.util.Scanner;

public class SetorNot{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            int i = sc.nextInt();

            if((n & (1<<(i-1))) != 0){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
            t--;
        }
    }
}