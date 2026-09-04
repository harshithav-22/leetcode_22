class Solution {
    public int splitArray(int[] nums, int k) {

        int left = 0;
        int right = 0;

        // Find largest element and total sum
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        // Binary search
        while (left < right) {

            int mid = left + (right - left) / 2;

            int parts = 1;
            int currentSum = 0;

            for (int num : nums) {

                if (currentSum + num > mid) {
                    parts++;
                    currentSum = num;
                } else {
                    currentSum += num;
                }
            }

            if (parts <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}