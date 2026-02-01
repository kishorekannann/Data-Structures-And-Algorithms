
public class InsertionSort {
    
    public int[] insertionSort(int[] nums) {
        int n = nums.length;

        for(int i=0;i<=n-1;i++){
            int j = i;
            while(j > 0 && nums[j-1] > nums[j]){
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
                j--;
            }
        }
        return nums;
    }
}

/*Time Complexity: O(N2) for the worst and average cases, where N is the size of the array. This is because the outer loop runs N times, and for each pass, the inner loop runs up to N times as well, 
resulting in approximately N xN operations, hence O(N2). 
The best-case time complexity occurs when the array is already sorted, in which case the inner loop doesn't run at all, leading to a time complexity of O(N).

Space Complexity: O(1) because Insertion Sort is an in-place sorting algorithm, meaning it sorts the array by modifying the original array without using additional data structures that grow with the size of the input.
*/
