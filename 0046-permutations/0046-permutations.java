class Solution {
    public static List<List<Integer>> permute(int[]nums){
        List<List<Integer>> result = new ArrayList<>();
        boolean [] visited = new boolean[nums.length];
        backtracking(nums, new ArrayList<>(), visited, result);
        return result ; 
    }
    public static void backtracking(int[]nums , List<Integer> current ,boolean [] visited, List<List<Integer>> result ){
        //Base case
        if(current.size()==nums.length){
            result.add(new ArrayList<>(current));
            return ;
        }

        //try all Unused
        for(int i =0;i<nums.length;i++){
            if(visited[i]){
                continue;
            }
            visited[i]=true;
            //choose
            current.add(nums[i]);
            backtracking(nums, current,visited,result);
            //unchoose
            current.remove(current.size()-1);
            visited[i] = false;
        }
    }
}