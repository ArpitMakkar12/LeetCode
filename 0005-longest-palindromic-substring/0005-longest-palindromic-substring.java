class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String max = "";
        for(int i = 0; i < n; i++) {
            String odd_string = Expansion(s, i, i);
            String even_string = Expansion(s, i, i + 1);
            if(max.length() < odd_string.length()){
                max = odd_string;
            }
            if(max.length() < even_string.length()){
                max = even_string;
            }
        }

        return max;
    }

    static String Expansion(String s, int L, int R){
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }

        return s.substring(L+1, R);
    }
}