class Solution {

    public int helper(int[] nums, int st, int end){

        int n = nums.length;
        if(n == 1) return nums[0];

        int[] dp = new int[n - 1];

        dp[0] = nums[st];
        dp[1] = Math.max(nums[st], nums[st + 1]);

        for(int i = st + 2, j = 2; i <= end; i++, j++) {
            dp[j] = Math.max(dp[j - 1], dp[j - 2] + nums[i]);
        }

        return dp[n - 2];
    }

    public int rob(int[] nums) {

        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }
}