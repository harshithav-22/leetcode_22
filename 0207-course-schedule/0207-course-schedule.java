class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        //Add values src->des
        int [] indegree = new int[numCourses];
        for(int [] p : prerequisites){
            int course = p[0];
            int prev = p[1];
            graph.get(prev).add(course);
            indegree[course]++;
        }

        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        //Evaluate the courses
        int count = 0;
        while(!q.isEmpty()){
            int course =q.poll();
            count++;

            //Remove the current course as prev
            for(int i:graph.get(course)){
                indegree[i] --;
                if(indegree[i] ==0){
                    q.offer(i);
                }
            }
        }
        return count==numCourses;
    }
}