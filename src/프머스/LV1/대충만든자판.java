package 프머스.LV1;

import java.util.*;
class 대충만든자판 {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();
        int length = keymap.length;
        int[] answer = new int[targets.length];

        for (int i = 0; i < length; i++) {
            int keyLength = keymap[i].length();
            String key = keymap[i];
            for (int j = 0; j < keyLength; j++) {
                char c = key.charAt(j);

                int min = Math.min(map.getOrDefault(c, j + 1), j + 1);
                map.put(c, min);
            }
        }
        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            for (char c : targets[i].toCharArray()) {
                if (map.containsKey(c)) {
                    sum += map.get(c);
                } else {
                    sum = -1;
                    break;
                }
            }
            answer[i] = sum;
        }
        return answer;
    }
}
