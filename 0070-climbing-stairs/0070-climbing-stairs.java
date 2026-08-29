class Solution {
    public int climbStairs(int n) {

        if(n == 0 || n == 1){
            return 1;
        }
        List<Integer> dp = new ArrayList<>();
        dp.add(1);
        dp.add(1);
        for(int i=2;i<=n;i++){
            int current= dp.get(i-1)+dp.get(i-2);
            dp.add(current);
        }
        return dp.get(n);
    }
}