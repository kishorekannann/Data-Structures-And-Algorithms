public class bubbleSort {

    public int[] bubbleSort(int[] nums) {
        int n = nums.length;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=i-1;j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }
}

/*Complexity Analysis:  
Time Complexity: O(N2) for the worst and average cases and O(N) for the best case. Here, N is the size of the array.

Space Complexity: O(1), because Bubble Sort is an in-place sorting algorithm, meaning it only requires a constant amount of extra space for its operations, regardless of the size of the input array.
*/