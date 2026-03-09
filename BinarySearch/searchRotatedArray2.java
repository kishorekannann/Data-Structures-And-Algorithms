/*
Search in rotated sorted array-II

Given an integer array nums, sorted in ascending order (may contain duplicate values) and a target value k. Now the array is rotated at some pivot point unknown to you. Return True if k is present and otherwise, return False.


Example 1

Input : nums = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 3

Output: True

Explanation: The element 3 is present in the array. So, the answer is True.

Example 2

Input : nums = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 10

Output: False

Explanation:The element 10 is not present in the array. So, the answer is False.

Example 3

Input : nums = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 7

Output:

True
Constraints

  1 <= nums.length <= 104
  -104 <= nums[i] <= 104
  nums is guaranteed to be rotated at some pivot.
  -104 <= k <= 104
 */

class Solution {
    public boolean searchInARotatedSortedArrayII(int[] nums, int k) {
     int low = 0;
     int high = nums.length - 1;

     while(low <= high){
        int mid = low + (high - low) /2;
        if(nums[mid] == k){
            return true;
        }
        if(nums[low] == nums[mid] && nums[mid] == nums[high]){
            low = mid + 1;
            high = mid - 1;
            continue;
        }

        if(nums[low] <= nums[mid]){
            if(nums[low] <= k && k <= nums[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            } 
        }else{
            if(nums[mid] <= k && k <= nums[high]){
                low = mid + 1;
            }else{
                high = mid - 1;
            } 
        }
        
     }
     return false;
    }
}

/*
TC : O(log n) in best and avereage case but in worstcase O(n/2)
SC : O(1)
 */