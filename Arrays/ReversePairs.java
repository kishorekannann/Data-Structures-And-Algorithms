class Solution {

  public int mergehelper(int[] nums, int low, int high) {
    int cnt = 0;
    if (low >= high) return cnt;
    int mid = (low + high) / 2;
    cnt += mergehelper(nums, low, mid);
    cnt += mergehelper(nums, mid + 1, high);
    cnt += countpairs(nums, low, mid, high);
    merge(nums, low, mid, high);
    return cnt;
  }

  public int countpairs(int[] nums, int low, int mid, int high) {
    int right = mid + 1;
    int cnt = 0;
    for (int i = low; i <= mid; i++) {
      while (right <= high && nums[i] > 2L * nums[right]) right++;

      cnt += right - (mid + 1);
    }
    return cnt;
  }

  public void merge(int[] nums, int low, int mid, int high) {
    List<Integer> tempArr = new ArrayList<>();
    int left = low;
    int right = mid + 1;
    while (left <= mid && right <= high) {
      if (nums[left] <= nums[right]) {
        tempArr.add(nums[left++]);
      } else {
        tempArr.add(nums[right++]);
      }
    }
    while (left <= mid) {
      tempArr.add(nums[left++]);
    }
    while (right <= high) {
      tempArr.add(nums[right++]);
    }
    for (int i = low; i <= high; i++) {
      nums[i] = tempArr.get(i - low);
    }
  }

  public int reversePairs(int[] nums) {
    return mergehelper(nums, 0, nums.length - 1);
  }
}

/* 
TC : O(2n * logn)
SC : O(n)
*/