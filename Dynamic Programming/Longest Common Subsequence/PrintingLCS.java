class PrintingLCS {
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "bkdqe";
        int n = str1.length(), m = str2.length();
        
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=m; i++){
            dp[0][i] = 0;
        }
        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }
        
        for(int i1=1; i1<=n; i1++){
            for(int i2=1; i2<=m; i2++){
                if(str1.charAt(i1-1) == str2.charAt(i2-1)){
                    dp[i1][i2] = 1 + dp[i1-1][i2-1];
                }else{
                    dp[i1][i2] = Math.max(dp[i1-1][i2],dp[i1][i2-1]);
                }
            }
        }
        
        String ans = "";
        
        int i = n, j = m;
        
        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
               ans = str1.charAt(i-1) + ans;
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }else{
                j--;
            }
        }
        System.out.println(ans);
    }
}
