class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtracking(0, nums, current, result);
        return result;
    }

    public static void backtracking(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            //choose
            current.add(nums[i]);
            backtracking(i + 1, nums, current, result);

            //unchoose
            current.remove(current.size() - 1);
        }
    }
}