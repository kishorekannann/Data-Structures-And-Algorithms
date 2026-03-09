/*
Find minimum in Rotated Sorted Array
Easy

Hints
Company
Given an integer array nums of size N, sorted in ascending order with distinct values, and then rotated an unknown number of times (between 1 and N), find the minimum element in the array.


Example 1

Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]

Output: 0

Explanation: Here, the element 0 is the minimum element in the array.

Example 2

Input : nums = [3, 4, 5, 1, 2]

Output: 1

Explanation:Here, the element 1 is the minimum element in the array.

Example 3

Input : nums = [4, 5, 6, 7, -7, 1, 2, 3]

Output:

-7
Constraints

n == nums.length
 1 <= n <= 104
 -104 <= nums[i] <= 104
 All the integers of nums are unique.
 nums is sorted and rotated between 1 and n times. */

 class Solution {
    public int findMin(int[] nums) {
     int low = 0;
     int high = nums.length -1 ;
     int ans = Integer.MAX_VALUE;
     while(low <= high){
        int mid = low + (high - low)/2;
        if(nums[low] <= nums[mid]){
            ans = Math.min(ans , nums[low]);
            low = mid + 1;
        }else{
            ans = Math.min(ans , nums[mid]);
            high = mid - 1;
        }
     } 

    return ans;   
    }
}

/*
TC : O(log n)
sc : O(1)
 */