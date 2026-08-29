class Solution {
    public int trap(int[] height) {
        int n = height.length;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        left.add(height[0]);
        //Find the left data
        for (int i = 1; i < n; i++) {
            left.add(Math.max(left.get(i - 1), height[i]));
        }

        //Init
        for (int i = 0; i < n; i++) {
            right.add(0);
        }

        right.set(n - 1, height[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            right.set(i, Math.max(right.get(i + 1), height[i]));
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            int units = Math.min(left.get(i), right.get(i)) - height[i];
            result = result + units;
        }
        return result;
    }
}