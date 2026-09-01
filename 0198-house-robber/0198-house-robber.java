class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int pointer1=0;
        int pointer2=0;

        for(int i=0;i<n;i++){
            int current = Math.max(pointer1, pointer2+nums[i]);
            pointer2=pointer1;
            pointer1=current;
        }
        return pointer1;
    }
}