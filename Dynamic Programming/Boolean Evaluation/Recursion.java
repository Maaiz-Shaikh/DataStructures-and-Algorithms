/*
Problem Statement Link : https://www.codingninjas.com/codestudio/problems/problem-name-boolean-evaluation_1214650?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1
TC: Exponential
SC: O(n) = Stack Space 
*/
import java.util.* ;
import java.io.*; 
public class Solution {
    static int mod = 1000000007;
    
    public static int intBool(boolean bool){
        if(bool) return 1;
        else return 0;
    }
    
    public static long f(int i, int j, int isTrue, String exp){
        if(i>j) return 0;
        if(i==j){
            if(isTrue==1) return intBool(exp.charAt(i)=='T');
            else return intBool(exp.charAt(i)=='F');
        }
        
        long ways = 0;
        for(int ind=i+1; ind<=j-1; ind+=2){
            long LT = f(i, ind-1, 1, exp);
            long LF = f(i, ind-1, 0, exp);
            long RT = f(ind+1, j, 1, exp);
            long RF = f(ind+1, j, 0, exp);
            
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
        
        return ways;
    }
    
    public static int evaluateExp(String exp) {
        int n = exp.length();
        return (int)f(0, n-1, 1, exp);
    }
}
