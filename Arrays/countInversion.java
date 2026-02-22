class Solution {

  public long mergehelper(int[] nums, int low, int mid, int high) {
    int[] temp = new int[high - low + 1];
    int left = low;
    int right = mid + 1;
    int idx = 0;
    long cnt = 0;
    while (left <= mid && right <= high) {
      if (nums[left] <= nums[right]) {
        temp[idx++] = nums[left++];
      } else {
        cnt += (mid - left + 1);
        temp[idx++] = nums[right++];
      }
    }
    while (left <= mid) {
      temp[idx++] = nums[left++];
    }

    while (right <= high) {
      temp[idx++] = nums[right++];
    }

    for (int i = low; i <= high; i++) {
      nums[i] = temp[i - low];
    }
    return cnt;
  }

  public long mergesort(int[] nums, int low, int high) {
    long cnt = 0;
    if (low >= high) return cnt;
    int mid = low + (high - low) / 2;
    cnt += mergesort(nums, low, mid);
    cnt += mergesort(nums, mid + 1, high);
    cnt += mergehelper(nums, low, mid, high);

    return cnt;
  }

  public long numberOfInversions(int[] nums) {
    return mergesort(nums, 0, nums.length - 1);
  }
}


/*
 
TC : O(nlogn)
SC : O(n);

 */