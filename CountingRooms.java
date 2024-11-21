package PracticeGraphs;

import java.util.Scanner;

public class CountingRooms {


    public static void dfs(int row , int col , char[][] buildingMap , boolean vis[][]){
        vis[row][col] = true;
        int n = buildingMap.length;
        int m = buildingMap[0].length;

        int delrow[] = {-1, 0 , 1, 0};
        int delcol[] = {0 , 1 , 0, -1};

        for(int i = 0; i < 4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && buildingMap[nrow][ncol] == '.' && !vis[nrow][ncol]){
                dfs(nrow, ncol, buildingMap, vis);
            }
        }

    }
    public static void bfs(int row , int col , char[][] buildingMap){
        int n = buildingMap.length;
        int m = buildingMap[0].length;

       
    }


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] buildingMap = new char[n][m];

        for(int i = 0; i < n; i++){
            String row = sc.next();
            for(int j = 0; j < m; j++){
                buildingMap[i][j] = row.charAt(j);
            }
        }

         boolean vis[][] = new boolean[n][m];

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(buildingMap[i][j] == '.' && vis[i][j] != true){
                    dfs(i , j , buildingMap , vis);
                    count++;
                    bfs(i, j, buildingMap);
                }
            }
        }
        System.out.println(count);
    }
}
