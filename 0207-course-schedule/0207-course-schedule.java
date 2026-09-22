class Solution {

    public boolean isCycleDFS(int src, boolean[] visited, boolean[] recPath, int[][] prerequisites) {
        visited[src] = true;
        recPath[src] = true;

        for(int i = 0; i < prerequisites.length; i++) {
            int v = prerequisites[i][0];
            int u = prerequisites[i][1];

            if(u == src) {
                if(!visited[v]) {
                    if(isCycleDFS(v, visited, recPath, prerequisites)) {
                        return true;
                    }
                } else if(recPath[v]) {
                    return true;
                }
            }
        }

        recPath[src] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] recPath = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(!visited[i]){
                if(isCycleDFS(i, visited, recPath, prerequisites)) {
                    return false;
                }
            }
        }

        return true;
    }
}