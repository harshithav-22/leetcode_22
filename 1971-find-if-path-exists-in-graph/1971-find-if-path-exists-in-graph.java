class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        //direction a->b
        for(int[] i:edges){
            int src_edge = i[0];
            int des_edge = i[1];
            graph.get(src_edge).add(des_edge);
            graph.get(des_edge).add(src_edge);
        }

        boolean [] visited = new boolean[n];

        return dfs(source, destination, graph, visited);
    }
    public boolean dfs ( int current , int des , ArrayList<ArrayList<Integer>> graph,boolean[] visited){
        //Base case
        if(current == des){
            return true;
        }
        visited[current] = true;

        // check neighbours
        for ( int nbr:graph.get(current)){
            if (!visited [nbr]){
                if(dfs(nbr, des, graph, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}