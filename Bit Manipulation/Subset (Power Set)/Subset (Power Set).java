class Solution {
    /*
     * Finding all possible subset using bit manipulation
     * We know that 2^n are the possible subset for n length set or array
     * index : 0 1 2
     * array : 1 2 3
     * 
     * indexing in Binary 2 1 0 { from right to left}
     * 5(in Binary) :     1 0 1 { 1 means picking element and 0 means not picking element}
     * This implies picking element at 0th and 2nd index from given set or array
    */
    
    /*
     * Time Complexity  : O(n * 2^n)
     * Space Complexity : O(1)
    */
    
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>(); // to store all possible subsets
        
        int n = nums.length;
        
        int numOfSubset = 1<<n; // equals to 2^n 
        
        for(int i=0; i<numOfSubset; i++){ // runs for 2^n times
            
            List<Integer> subset = new ArrayList<Integer>(); // store subset
            
            for(int j=0; j<n; j++){ // runs for n times to check the jth bit of i
                
                if((i & (1<<j))!=0){ // if jth bit is set(means 1), pick the jth element from nums
                    subset.add(nums[j]);
                }
            }
            
            result.add(new ArrayList<Integer>(subset)); // store every subset
        }
        
        return result;
    }
}
