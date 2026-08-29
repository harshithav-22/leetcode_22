class Solution {
    public int numDecodings(String s) {
        if(s.isEmpty()||s.charAt(0)=='0'){
            return 0;
        }
        int [] dp= new int[s.length()+1];

        //Initialization
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<=s.length();i++){
            //Single
            int singleDigit = s.charAt(i-1)-'0';
            if(singleDigit >= 1 && singleDigit <= 9){
                dp[i] = dp[i] + dp[i-1];
            }
            //Two digits
            int doubleDigit = Integer.parseInt(s.substring(i-2, i));
            if(doubleDigit >= 10 && doubleDigit <= 26){
                dp[i] = dp[i] + dp[i-2];
            }
        }
        return dp[s.length()];
    }
}