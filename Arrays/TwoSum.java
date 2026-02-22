import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    
    public int[] twoSum(int[] nums, int target) {

    int n = nums.length;

    Map<Integer,Integer> seennNumbers = new HashMap<>();
    for(int i=0;i<n;i++){
        int moreneeded = target - nums[i];
        if(seennNumbers.containsKey(moreneeded)){
            return new int[]{seennNumbers.get(moreneeded),i};
        }
        seennNumbers.put(nums[i],i);
    }

    return new int[]{-1,-1};
    }
}

/* 
TimeComplexity : O(n);
SpaceComplexity : O(n);
*/

