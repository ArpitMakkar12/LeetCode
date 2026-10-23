class Solution {
    public int removeDuplicates(int[] nums) {
        
        int write = 1;
        
        for(int read = 0; read < nums.length; read++) {
            if(nums[read] != nums[write - 1]){
                nums[write] = nums[read];
                write++;
            }
        }
        
        return write;
    }
}