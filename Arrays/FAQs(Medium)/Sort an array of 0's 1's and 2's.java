// Approach 2: Frequency Count
// TC: O(2*n)
// SC: O(1)
class Solution {
    public void sortZeroOneTwo(int[] nums) {
        int[] frequency = new int[3];
        int n = nums.length;

        for(int num : nums) {
            frequency[num]++;
        }

        int index = 0;
        while(index < n && frequency[0] > 0) {
            nums[index++] = 0;
            frequency[0]--;
        }

        while(index < n && frequency[1] > 0) {
            nums[index++] = 1;
            frequency[1]--;
        }

        while(index < n && frequency[2] > 0) {
            nums[index++] = 2;
            frequency[2]--;
        }
    }
}

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
