// Approach 3: Optimal (Dutch National Flag Algorithm)
// TC: O(n)
// SC: O(1)

class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortZeroOneTwo(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high) {
            if(nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            }else if(nums[mid] == 1) {
                mid++;
            }else {
                swap(nums, mid, high);
                high--;
            }
        }
    }
}
