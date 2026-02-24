class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1, j = n - 1;
    int ind = m + n - 1;

    // Until all the elements from nums2 are placed
    while (j >= 0) {
      // If nums1[i] >= nums2[j]
      if (i >= 0 && nums1[i] >= nums2[j]) {
        // Place the element
        nums1[ind] = nums1[i];

        // Move both indices back by one place
        ind--;
        i--;
      }
      // Otherwise
      else {
        // Place the element
        nums1[ind] = nums2[j];

        // Move both indices back by one place
        ind--;
        j--;
      }
    }
  }
}

/*
TC : O(n+m)
SC : O(1)
 */