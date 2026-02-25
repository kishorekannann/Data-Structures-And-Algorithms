class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        Set<Integer> stt = new HashSet<>();
        for(int i=0;i<n;i++){
            stt.add(nums[i]);
        }
        int max = 0;
        for(Integer el : stt){
            if(!stt.contains(el -1 )){
                int cnt = 1;
                int ele = el + 1 ;
                while(stt.contains(ele)){
                    cnt++;
                    ele = ele + 1;
                }
                max = Math.max(max,cnt);
            }
        }
        return max;
    }
}


/*
  TC : O(n) + O(2n) ~ O(3n)
  SC : O(n)
*/