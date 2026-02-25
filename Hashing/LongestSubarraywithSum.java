/*Longest subarray with sum K
Medium
 
Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k. If no such sub-array exists, return 0.


Example 1

Input: nums = [10, 5, 2, 7, 1, 9],  k=15

Output: 4

Explanation:

The longest sub-array with a sum equal to 15 is [5, 2, 7, 1], which has a length of 4. This sub-array starts at index 1 and ends at index 4, and the sum of its elements (5 + 2 + 7 + 1) equals 15. Therefore, the length of this sub-array is 4.

Example 2

Input: nums = [-3, 2, 1], k=6

Output: 0

Explanation:

There is no sub-array in the array that sums to 6. Therefore, the output is 0.

Example 3

Input: nums = [-1, 1, 1], k=1

Output:

3
Constraints

 1<=n<=105
 -105<=nums[i]<=105
 -109<= k<=109 */

class Solution {
    public int longestSubarray(int[] nums, int k) {
      int n = nums.length;
      int prefixsum = 0;
      HashMap<Integer,Integer> prefixSumMap = new HashMap<>();
      int maxlen = 0;
      for(int i=0;i<n;i++){
        prefixsum += nums[i];
        if(prefixsum == k){
            maxlen = Math.max(maxlen,i+1);
        }
        int rem = prefixsum - k;
        if(prefixSumMap.containsKey(rem)){
            maxlen = Math.max(maxlen , i - prefixSumMap.get(rem));
        }
        if(!prefixSumMap.containsKey(prefixsum)){
            prefixSumMap.put(prefixsum , i);
        }
      }  
      return maxlen;
    }
}