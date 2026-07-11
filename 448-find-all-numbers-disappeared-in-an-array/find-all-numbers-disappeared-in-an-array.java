class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disAppeared = new ArrayList<>();
        int n = nums.length;
        boolean[] isAppeared = new boolean[n];

        for(int i = 0; i < n; i++) {
            isAppeared[nums[i] - 1] = true;
        }

        for(int i = 0; i < n; i++) {
            if(isAppeared[i] == false) {
                disAppeared.add(i + 1);
            }
        }

        return disAppeared;
    }
}