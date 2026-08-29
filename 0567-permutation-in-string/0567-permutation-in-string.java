class Solution {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Count characters in s1
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {

            // Add right character
            count2[s2.charAt(right) - 'a']++;

            // If window becomes bigger than s1
            if (right - left + 1 > s1.length()) {

                count2[s2.charAt(left) - 'a']--;

                left++;
            }

            // Check when window size is same as s1
            if (right - left + 1 == s1.length()) {

                boolean same = true;

                for (int i = 0; i < 26; i++) {

                    if (count1[i] != count2[i]) {
                        same = false;
                        break;
                    }
                }

                if (same) {
                    return true;
                }
            }
        }

        return false;
    }
}