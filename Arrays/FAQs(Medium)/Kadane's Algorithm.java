// Approach 2: Kadane's Algorithm
// TC: O(n) SC: O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            maxSum = Math.max(maxSum, sum);
            if(sum < 0) sum = 0;
        }

        return maxSum;
    }
}


// Follow up question: Print longest sum subarray
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int startInd = 0;
        int endInd = 0;
        
        for(int i=0; i<nums.length; i++) {
            if(sum == 0) startInd = i;
            sum+=nums[i];
            if(sum > maxSum) {
                maxSum = sum;
                endInd = i;
            }

            if(sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }
}
