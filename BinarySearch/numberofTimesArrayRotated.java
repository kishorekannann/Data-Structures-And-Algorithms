/*
Find out how many times the array is rotated

Given an integer array nums of size n, sorted in ascending order with distinct values. The array has been right rotated an unknown number of times, between 0 and n-1 (including). Determine the number of rotations performed on the array.


Example 1

Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]

Output: 4

Explanation: The original array should be [0, 1, 2, 3, 4, 5, 6, 7]. So, we can notice that the array has been rotated 4 times.

Example 2

Input: nums = [3, 4, 5, 1, 2]

Output: 3

Explanation: The original array should be [1, 2, 3, 4, 5]. So, we can notice that the array has been rotated 3 times.

Example 3

Input: nums = [4, 5, 1, 2]

Output:

2
Constraints

 n == nums.length
 1 <= n <= 104
 -104 <= nums[i] <= 104
 All the integers of nums are unique.
 */

class Solution {
    public int findKRotation(ArrayList<Integer> arr) {
     int n = arr.size();
     int low = 0;
     int high = arr.size() -1 ;
     int ans = Integer.MAX_VALUE;
     int idx = -1;
     while(low <= high){
        int mid = low + (high - low)/2;
        if(arr.get(low) <= arr.get(mid)){
            if(arr.get(low) < ans){
                ans  = arr.get(low);
                idx = low;
            }
            low = mid + 1;
        }else{
            if(arr.get(mid) < ans){
                ans  = arr.get(mid);
                idx = mid;
            }
            high = mid - 1;
        }
     } 
     return idx;
    }
}

/*
TC :O(log n)
SC : O(1)
 */