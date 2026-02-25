/* Count subarrays with given sum
Medium

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.


Example 1

Input: nums = [1, 1, 1], k = 2

Output: 2

Explanation: In the given array [1, 1, 1], there are two subarrays that sum up to 2: [1, 1] and [1, 1]. Hence, the output is 2.

Example 2

Input: nums = [1, 2, 3], k = 3

Output: 2

Explanation: In the given array [1, 2, 3], there are two subarrays that sum up to 3: [1, 2] and [3]. Hence, the output is 2.

Example 3

Input: nums = [3, 1, 2, 4], k = 6

Output:

2
Constraints

   1 <= nums.length <= 105
   -1000 <= nums[i] <= 1000
   -107 <= k <= 107 */

class Solution {
    public int subarraySum(int[] nums, int k) {
       int n = nums.length;
       int prefixsum = 0;
       HashMap<Integer,Integer> mpp = new HashMap<>();
       mpp.put(0,1);
       int cnt = 0;
       for(int i = 0;i < n;i++){
            prefixsum += nums[i];
            int rem = prefixsum - k;

            if(mpp.containsKey(rem)) cnt += mpp.get(rem);

            mpp.put(prefixsum , mpp.getOrDefault(prefixsum,0)+1);
            
       }
       return cnt;
    }
}

/*
TC : O(n)
SC : O(n)
 */