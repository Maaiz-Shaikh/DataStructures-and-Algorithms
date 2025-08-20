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
