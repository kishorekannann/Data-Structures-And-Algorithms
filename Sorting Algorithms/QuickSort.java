
public class QuickSort {
    public int[] quickSort(int[] nums) {
    int n = nums.length;
    quicksortHelper(nums,0,n-1);
    return nums;
    }
    public void quicksortHelper(int[] nums,int low, int high){
        if(low >= high) return;
        int randomIndex = low + new Random().nextInt(high - low + 1);
        swap(nums, low, randomIndex);
        int partition = partition(nums,low,high);
        quicksortHelper(nums, low ,partition-1);
        quicksortHelper(nums, partition+1 ,high);
    }
    public int partition(int[] nums,int low ,int high){
        int pivot = nums[low];
        int i = low ;
        int j = high;
        while(i < j){
            while(i <= high && nums[i] <= pivot) i++;
            while(j >= low && nums[j] > pivot) j--;
            if(i < j) swap(nums,i,j);
        }
        swap(nums,low,j);
        return j;
    }
    public void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

/*Complexity Analysis:  
Time Complexity: O(N*logN), where N = size of the array. At each step, we divide the whole array, which takes logN steps, and n steps are taken for the partition() function, so overall time complexity will be N*logN.

The following recurrence relation can be written for Quick sort:

F(n) = F(k) + F(n-1-k)

Here, k is the number of elements smaller or equal to the pivot and n-1-k denotes elements greater than the pivot.

There can be 2 cases:

Worst Case: This case occurs when the pivot is the greatest or smallest element of the array. If the partition is done and the last element is the pivot, then the worst case would be either in the increasing order of the array or in the decreasing order of the array.

Recurrence:

F(n) = F(0) + F(n-1) or F(n) = F(n-1) + F(0)

Worst Case Time Complexity: O(n2)

Best Case: This case occurs when the pivot is the middle element or near to middle element of the array.

Recurrence:

F(n) = 2F(n/2)

Time Complexity for the best and average case: O(N*logN)

Space Complexity: O(1) + O(N) auxiliary stack space, where N = size of the array.

*/