import java.util.*;

class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Sort characters based on frequency
        List<Character> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        // Create result
        StringBuilder result = new StringBuilder();

        for (char ch : list) {
            for (int i = 0; i < map.get(ch); i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}