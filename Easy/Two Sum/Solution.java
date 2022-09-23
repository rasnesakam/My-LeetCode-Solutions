import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i],i);
        for (int j = 0; j < nums.length;j++){
            int k = target - nums[j];
            if (k == 0 && map.containsKey(target))
                return new int[]{j, map.get(target)};
            else if (map.containsKey(k) && map.get(k) != j)
                return new int[]{j, map.get(k)};
        }
        return new int[0];
    }
}