/*Floor and Ceil in Sorted Array

Given a sorted array nums and an integer x. Find the floor and ceil of x in nums. The floor of x is the largest element in the array which is smaller than or equal to x. The ceiling of x is the smallest element in the array greater than or equal to x. If no floor or ceil exists, output -1.


Example 1

Input : nums =[3, 4, 4, 7, 8, 10], x= 5

Output: 4 7

Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.

Example 2

Input : nums =[3, 4, 4, 7, 8, 10], x= 8

Output: 8 8

Explanation: The floor of 8 in the array is 8, and the ceiling of 8 in the array is also 8.

Example 3

Input : nums = [2, 4, 6, 8, 10, 12, 14], x= 1

Output:

[-1, 2]
Constraints

  1 <= nums.length <= 105 
  0 < nums[i], x < 105 
  nums is sorted in ascending order.
*/

class Solution {
    private int findFloor(int[] nums, int n, int x) {
        int low = 0, high = n - 1;

        // Stores the floor value
        int ans = -1;

        // Perform binary search to find the floor value
        while (low <= high) {
            int mid = (low + high) / 2;

             /*Check if mid element lesser than 
			      or equal to x, if it is update ans 
		        and eliminate the left half */
            if (nums[mid] <= x) {
                ans = nums[mid];
                low = mid + 1;
            }
            /*If mid element greater than x, 
            then eliminate the right half */
            else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private int findCeil(int[] nums, int n, int x) {
        int low = 0, high = n - 1;
        int ans = -1;

        // Perform binary search to find ceil value
        while (low <= high) {
            int mid = (low + high) / 2;

            /*Check if mid element greater than 
			      or equal to x, if it is update ans 
		        and eliminate the left half */
            if (nums[mid] >= x) {
                ans = nums[mid];
                high = mid - 1;
            }
            /*If mid element lesser than x, 
            then eliminate the left half */
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // Function to find both floor and ceil of x 
    public int[] getFloorAndCeil(int[] nums, int x) {
        int n = nums.length;

        /*Function call to find the floor 
        value using helper functions*/
        int floor = findFloor(nums, n, x);

        /* Function call to find the ceil 
        value using helper functions*/
        int ceil = findCeil(nums, n, x);

        return new int[] {floor,ceil};
    }
}

/*
TC : O(log n)
SC : O(1)
*/