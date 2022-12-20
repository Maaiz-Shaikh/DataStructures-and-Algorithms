/*
Problem Statement Link : https://www.codingninjas.com/codestudio/problems/problem-name-boolean-evaluation_1214650?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1
TC: O(n^3)
SC: O(n*n*2)
*/
import java.util.* ;
import java.io.*; 
public class Solution {
    static int mod = 1000000007;
    
    public static int intBool(boolean bool){
        if(bool) return 1;
        else return 0;
    }
    
    public static long f(int i, int j, int isTrue, String exp, long[][][] dp){
        if(i>j) return 0;
        if(i==j){
            if(isTrue==1) return intBool(exp.charAt(i)=='T');
            else return intBool(exp.charAt(i)=='F');
        }
        
        if(dp[i][j][isTrue]!=-1) return dp[i][j][isTrue];
        
        long ways = 0;
        for(int ind=i+1; ind<=j-1; ind+=2){
            long LT = f(i, ind-1, 1, exp, dp);
            long LF = f(i, ind-1, 0, exp, dp);
            long RT = f(ind+1, j, 1, exp, dp);
            long RF = f(ind+1, j, 0, exp, dp);
            
            if(exp.charAt(ind)=='&'){
                if(isTrue==1) ways = (ways + (LT*RT)%mod)%mod;
                else ways = (ways + (LT*RF)%mod + (LF*RT)%mod + (LF*RF)%mod)%mod;
            }else if(exp.charAt(ind)=='|'){
                if(isTrue==1) ways = (ways + (LT*RF)%mod + (LF*RT)%mod + (LT*RT)%mod)%mod;
                else ways = (ways + (LF*RF)%mod)%mod;
            }else{
                if(isTrue==1) ways = (ways + (LT*RF)%mod + (LF*RT)%mod)%mod;
                else ways = (ways + (LF*RF)%mod + (LT*RT)%mod)%mod;  
            }
            
        }
        
        return dp[i][j][isTrue] = ways;
    }
    
    public static int evaluateExp(String exp) {
        int n = exp.length();
        long[][][] dp = new long[n][n][2];
        
        for(int i=0; i<n; i++){
            dp[i][i][0] = intBool(exp.charAt(i)=='F');
            dp[i][i][1] = intBool(exp.charAt(i)=='T');
        }
        
        for(int i=n-1; i>=0; i--){
            for(int j=i+1; j<n; j++){
                for(int isTrue=0; isTrue<2; isTrue++){
                    long ways = 0;
                    for(int ind=i+1; ind<=j-1; ind+=2){
                        long LT = dp[i][ind-1][1];
                        long LF = dp[i][ind-1][0];
                        long RT = dp[ind+1][j][1];
                        long RF = dp[ind+1][j][0];

                        if(exp.charAt(ind)=='&'){
                            if(isTrue==1) ways = (ways + (LT*RT)%mod)%mod;
                            else ways = (ways + (LT*RF)%mod + (LF*RT)%mod + (LF*RF)%mod)%mod;
                        }else if(exp.charAt(ind)=='|'){
                            if(isTrue==1) ways = (ways + (LT*RF)%mod + (LF*RT)%mod + (LT*RT)%mod)%mod;
                            else ways = (ways + (LF*RF)%mod)%mod;
                        }else{
                            if(isTrue==1) ways = (ways + (LT*RF)%mod + (LF*RT)%mod)%mod;
                            else ways = (ways + (LF*RF)%mod + (LT*RT)%mod)%mod;  
                        }
                    }
                    dp[i][j][isTrue] = ways;
                }
            }
        }
        
        return (int)dp[0][n-1][1];
    }
}
