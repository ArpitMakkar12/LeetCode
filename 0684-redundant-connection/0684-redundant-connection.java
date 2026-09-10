class Solution {

    int V;
    ArrayList<ArrayList<Integer>> list;

    boolean isCycleUnderBFS(int src, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, -1});
        visited[src] = true;

        while(q.size() > 0) {
            int[] curr = q.poll();
            int u = curr[0];
            int par = curr[1];

            for(int neighbor : list.get(u)) {
                if(!visited[neighbor]) {
                    q.add(new int[]{neighbor, u});
                    visited[neighbor] = true;
                } else if(neighbor != par) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean isCycleBFS() {
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(isCycleUnderBFS(i, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    void addEdge(int u, int v) {
        list.get(u).add(v);
        list.get(v).add(u);
    }

    public int[] findRedundantConnection(int[][] edges) {
        V = edges.length + 1;

        list = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            addEdge(u,v);

            if(isCycleBFS()){
                return edge;
            }
        }

        return new int[]{};
    }
}