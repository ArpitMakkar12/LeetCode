class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for(int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int second = target - first;

            if(map.containsKey(second)) {
                ans[0] = i;
                ans[1] = map.get(second);
                break;
            }

            map.put(first, i);
        }

        return ans;
    }
}