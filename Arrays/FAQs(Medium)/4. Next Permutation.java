// Approach 2: Optimal (Based on observations)
// TC: O(3*n) SC: O(1) {No Extra space is used, modifying array in-place
class Solution {
    public void nextPermutation(int[] nums) {
        // Step 1: Longest Common Prefix
        // Find the break point
        int ind = -1;
        int n = nums.length;

        for(int i=n-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                ind = i;
                break;
            }
        }

        // Edge Case: if ind == -1
        // means given num is the largest permutation 
        // so return the sorted one (smallest permutation)
        if(ind == -1) {
            for(int i=0; i<nums.length/2; i++) {
                swap(nums, i, nums.length-1-i);
            }
            return;
        }

        // Step 2: Find the smallest element which is just greater
        // than break point element i.e. element at ith index
        // since from last to ind+1 element will be in descending order
        // iterate from end
        for(int i=n-1; i>ind; i--) {
            if(nums[i] > nums[ind]) {
                swap(nums, i, ind);
                break;
            }
        }

        // Step 3: Now sort the remaining elements in ascending order
        // you know that remaining elements are already in descending order
        // just reverse them and you will get next permutation
        int length = nums.length - 1 - ind;
        for(int i=0; i<length/2; i++) {
            swap(nums, ind+1+i, nums.length-1-i);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

