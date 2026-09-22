class Solution {

    public boolean isCycleDFS(int src, boolean[] visited, boolean[] recPath, int[][] prerequisites) {
        visited[src] = true;
        recPath[src] = true;

        for(int i = 0; i < prerequisites.length; i++) {
            int v = prerequisites[i][0];
            int u = prerequisites[i][1];

            if(src == u) {
                if(!visited[v]) {
                    if(isCycleDFS(v, visited, recPath, prerequisites)) {
                        return true;
                    }
                } else if(recPath[v]){
                    return true;
                }
            }
        }

        recPath[src] = false;
        return false;
    }

    void topoOrder(int src, boolean[] visited, Stack<Integer> stack, int[][] prerequisites) {
        visited[src] = true;

        for(int i = 0; i < prerequisites.length; i++) {
            int v = prerequisites[i][0];
            int u = prerequisites[i][1];

            if(u == src) {
                if(!visited[v]){
                    topoOrder(v, visited, stack, prerequisites);
                }
            }
        }

        stack.push(src);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] recPath = new boolean[numCourses];
        int[] ans = new int[numCourses];
        int index = 0;

        for(int i = 0; i < numCourses; i++) {
            if(!visited[i]) {
                if(isCycleDFS(i, visited, recPath, prerequisites)) {
                    return new int[]{};
                }
            }
        }

        // Topological sort
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(visited, false);

        for(int i = 0; i < numCourses; i++) {
            if(!visited[i]){
                topoOrder(i, visited, stack, prerequisites);
            }
        }

        while(stack.size() > 0) {
            ans[index++] = stack.pop();
        }

        return ans;
    }
}