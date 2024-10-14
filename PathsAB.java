import java.util.HashMap;
import java.util.Scanner;

public class PathsAB{
    public void dfs(int row ,int col ,int grid[][],boolean vis[][]){
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = true;

        HashMap<Character,Integer> mpp = new HashMap<>();
        mpp.put('L',-1);
        mpp.put('R',0);
        mpp.put('U',1);
        mpp.put('D',0);
        

       
            if(nrow >= 0 && nrow  < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '.'){
               
                dfs(nrow,ncol,grid,vis,flag);
            }
        }
    
    public static  void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();


        while(t > 0){
            int n = sc.nextInt(); 
            int m = sc.nextInt();
            sc.nextLine();

            char[][] grid = new char[n][m];
            boolean[][] vis = new boolean[n][m];

            for(int i = 0; i < n; i++){

                String line = sc.nextLine().trim();
    
                grid[i] = line.toCharArray();
            }

            for(int i =0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(grid[i][j] == 'A' && !vis[i][j]){
                        dfs(i,j,grid,vis);
                    }
                }
            }


            t--;
        }
    }
}