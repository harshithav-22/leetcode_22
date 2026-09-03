class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
                int n = rooms.size();
        boolean [] visited = new boolean[n];

        Queue<Integer> q = new LinkedList<>();

        //Start 
        q.offer(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int current = q.poll();
            for( int key:rooms.get(current)){
                if(!visited[key]){
                    visited[key] = true;
                    q.offer(key);
                }
            }
        }

        for(boolean room:visited){
            if(!room){
                return false;
            }
        }
        return true;
    }
}