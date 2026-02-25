/*Count subarrays with given xor K

Given an array of integers nums and an integer k, return the total number of subarrays whose XOR equals to k.


Example 1

Input : nums = [4, 2, 2, 6, 4], k = 6



Output : 4



Explanation : The subarrays having XOR of their elements as 6 are [4, 2],  [4, 2, 2, 6, 4], [2, 2, 6], and [6]

Example 2

Input :nums = [5, 6, 7, 8, 9], k = 5



Output : 2



Explanation : The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]

Constraints

  1 <= nums.length <= 105
  1 <= nums[i] <= 109
  1 <= k <= 109
*/ 

class Solution {
    public int subarraysWithXorK(int[] nums, int k) {
    int n = nums.length;
    int cnt = 0;
    HashMap<Integer,Integer> mpp = new HashMap<>();
    mpp.put(0,1);
    int xr = 0;
    for(int i=0;i<n;i++){
        xr ^= nums[i];
        int x = xr ^ k ;
        cnt += mpp.getOrDefault(x,0);
        mpp.put(xr , mpp.getOrDefault(xr,0)+1);
    }
    return cnt;
    }
}

// TC : O(n)
// SC : O(n)