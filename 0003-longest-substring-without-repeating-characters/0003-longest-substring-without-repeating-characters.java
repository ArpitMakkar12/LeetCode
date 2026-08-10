class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count = 0;

        Set<Character> set = new HashSet<>();
        int L = 0;

        for(int R = 0; R < s.length(); R++){
            while(set.contains(s.charAt(R))){
                set.remove(s.charAt(L));
                L++;
            }
            set.add(s.charAt(R));
            count = Math.max(count, set.size());
        }
        return count;
    }
}