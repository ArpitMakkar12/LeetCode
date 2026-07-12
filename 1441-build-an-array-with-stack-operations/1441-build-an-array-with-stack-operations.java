class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> str = new ArrayList<>();

        int j = 0;

        for(int i = 1; i <= n; i++) {
            str.add("Push");

            if(i == target[j]){
                j++;

                if(j == target.length) {
                    break;
                }
            } else {
                str.add("Pop");
            }
        }

        return str;
    }
}