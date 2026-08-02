class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] ans = new int[n];
        int lastLogTimeStamp = -1;
        Stack<Integer> callStack = new Stack<>();

        for(String log : logs){
            String[] str = log.split(":");
            int funcId = Integer.parseInt(str[0]);
            boolean isStart = "start".equals(str[1]);
            int timestamp = Integer.parseInt(str[2]);

            if(!isStart){
                timestamp += 1;
            }

            if(!callStack.isEmpty()){
                int currentFunc = callStack.peek();
                ans[currentFunc] += timestamp - lastLogTimeStamp;
            }

            if(isStart){
                callStack.push(funcId);
            } else {
                callStack.pop();
            }

            lastLogTimeStamp = timestamp;
        }
        return ans;
    }
}