class MajorityElement1 {
    public int majorityElement(int[] nums) {
    int n = nums.length;
    int cnt = 0;
    int ele = -1;
    for(int i=0;i<n;i++){
        if(cnt == 0){
            cnt++;
            ele = nums[i];
        }else if(nums[i] == ele){
            cnt++;
        }else{
            cnt--;
        }
    }  
    int cnt1 = 0;
    for(int j=0;j<n;j++){
        if(nums[j] == ele) cnt1++;
    } 
    if(cnt1 > n/2) return ele;
    return -1;
    }
}