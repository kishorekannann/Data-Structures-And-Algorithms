import java.util.*;
class Solution {

  public int[] selectionSort(int[] nums) {
    // Loop through unsorted part of the array (0 to n-2)
    for (int i = 0; i < nums.length - 1; i++) {
      /*Assume current element 
      is the minimum*/
      int minIndex = i;

      // Find actual minimum in unsorted part (i+1 to n-1)
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] < nums[minIndex]) {
          minIndex = j;
        }
      }

      // Swap only if minIndex changed
      if (minIndex != i) {
        int temp = nums[i];
        nums[i] = nums[minIndex];
        nums[minIndex] = temp;
      }
    }

    return nums;
  }
}

/*Complexity Analysis  
Time Complexity: O(N2) where N is the length of the input array. The outer loop runs through each element, and the inner loop finds the smallest element in the unsorted portion of the array.

Space Complexity: O(1) as it is an in-place sorting algorithm and does not require additional storage proportional to the input size.8 */