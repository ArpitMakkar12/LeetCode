class Solution {
    public int majorityElement(int[] nums) {
        // Moore's Algo

        int freq = 0, ans = 0;
        int n = nums.length;

        for(int i = 0; i < nums.length; i++) {
            if(freq == 0) {
                ans = nums[i];
            }

            if(ans == nums[i]) {
                freq++; 
            } else {
                freq--;
            }
        }

        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(ans == nums[i]) {
                count++;
            }
        }

        if(count >= n / 2) {
            return ans;
        } else {
            return -1;
        }
    }
}