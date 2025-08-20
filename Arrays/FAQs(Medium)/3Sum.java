// Problem Link: https://leetcode.com/problems/3sum/

// Approach 1: Brute Force
// TC: O(n^3*log(k)) + O(nlog(n)) + O(k), k = no. of unique triplets (logk for adding k unique triplets in set, can be ignored)
// SC: O(2*k)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        HashSet<List<Integer>> tripletSet = new HashSet<>(); // To avoid duplicate triplets
        
        Arrays.sort(nums); // Sort so that all possible elements appear in sorted order so that set can detect duplicates
        
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int k=j+1; k<n; k++) {
                    if(nums[i]+nums[j]+nums[k] == 0) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        tripletSet.add(triplet);
                    }
                }
            }
        }

        List<List<Integer>> triplets = new ArrayList<>();
        for(List<Integer> triplet : tripletSet) {
            triplets.add(triplet);
        }
        return triplets;


    }
}
// Improvement in Approach 1
// Instead of sorting whole array just sort triplet list and add it in set to avoid duplicate
// Improved Approach 1: Brute Force
// TC: O(n^3*log(k)) + O(k), k = no. of unique triplets (logk for adding k unique triplets in set, can be ignored)
// SC: O(2*k)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        HashSet<List<Integer>> tripletSet = new HashSet<>(); // To avoid duplicate triplets
        
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int k=j+1; k<n; k++) {
                    if(nums[i]+nums[j]+nums[k] == 0) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        Collections.sort(triplet); // Sort triplet so that element appear in sorted order and set can detect duplicate
                        tripletSet.add(triplet);
                    }
                }
            }
        }

        List<List<Integer>> triplets = new ArrayList<>(tripletSet);
        return triplets;


    }
}

// Approach 2: Better (Using Complementary Set, same as 2Sum)
// TC: O(n^2*log(k)) + O(k), k = no. of unique triplets (logk for adding k unique triplets in set, can be ignored)
// SC: O(2*k) + O(n) = for complimentary set
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        HashSet<List<Integer>> tripletSet = new HashSet<>();
        HashSet<Integer> complement = new HashSet<>();

        for(int i=0; i<n; i++) {
            int target = -(nums[i]);
            complement.clear();

            for(int j=i+1; j<n; j++) {
                int comp = target - nums[j];
                if(complement.contains(comp)) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(comp);
                    triplet.add(nums[j]);
                    Collections.sort(triplet);
                    tripletSet.add(triplet);
                }
                complement.add(nums[j]);
            }
        }

        List<List<Integer>> triplets = new ArrayList<>(tripletSet);
 
        return triplets;

    }
}

// Approach 3: Optimal (2-Pointers Approach + Sorting)
// // TC: O(n^2*log(k)) + O(nlog(n)) + O(k), k = no. of unique triplets (logk for adding k unique triplets in set, can be ignored)
// SC: O(2*k)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        HashSet<List<Integer>> tripletSet = new HashSet<>();

        Arrays.sort(nums);

        for(int i=0; i<n; i++) {
            int target = -(nums[i]);
            int left = i+1;
            int right = n-1;

            while(left < right) {
                int sum = nums[left] + nums[right];
                if(sum == target) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    tripletSet.add(triplet);
                    
                    left++;
                }else if(sum > target) {
                    right--;
                }else {
                    left++;
                }
            }
        }

        List<List<Integer>> triplets = new ArrayList<>(tripletSet);

        return triplets;


    }
}


// Improvement in Approach 3: Optimal
// Instead of using set to avoid duplicate, if we are using sorted array just skip the duplicate element once used
// // TC: O(n^2) + O(k), k = no. of unique triplets
// SC: O(k)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        int n = nums.length;
        
        Arrays.sort(nums);
        for(int i=0; i<n; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            
            int left = i+1;;
            int right = n-1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0) {
                    right--;
                }else if(sum < 0) {
                    left++;
                }else {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    triplets.add(triplet);
                    left++;
                    right--;

                    while(left < right && nums[left] == nums[left-1]) left++;
                    while(left < right && nums[right] == nums[right+1]) right--;
                }
            }

        }

        return triplets;
    }
}
