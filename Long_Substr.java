public class Long_Substr{
    public static int lcs(String s1, String s2){
        int n = s1.length();
        int m = s2.length(); 
        int maxLength =0;

        if(n == 0 || m == 0){
            return 0;
        }

        int dp[][] = new int[n+1][m+1];

        for(int i =1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return maxLength;

    }
    public static void main(String[] args){
        String s1 = "ABC";
        String s2 ="AEC";
        
        System.out.println(lcs(s1,s2));
    }
}