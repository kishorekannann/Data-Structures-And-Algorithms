public class MergeSort {
    public int[] mergeSort(int[] nums) {
    int n = nums.length;
    mergehelper(nums,0,n-1);
    return nums;
    }

    public void mergehelper(int[] nums,int low,int high){
        if(low >= high) return;
        int mid = (low + high)/2;
        mergehelper(nums,low ,mid);
        mergehelper(nums,mid+1,high);
        merge(nums,low,mid,high);
    }

    public void merge(int[] nums,int low,int mid ,int high ){
        List<Integer> tempArr = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                tempArr.add(nums[left++]);
            }else{
                tempArr.add(nums[right++]);
            }
        }
        while(left <= mid){
            tempArr.add(nums[left++]);
        }
        while(right <= high){
            tempArr.add(nums[right++]);
        }
        for(int i=low;i<=high;i++){
            nums[i] = tempArr.get(i - low);
        }
        }
}

/* 
Complexity Analysis:  
Time Complexity: O(nlogn). At each step, we divide the whole array, which takes logn steps, and we assume n steps are taken to sort the array. So, the overall time complexity is nlogn.

Space Complexity: O(n). We are using a temporary array to store elements in sorted order.

*/