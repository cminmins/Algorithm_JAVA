package nexon;

import java.util.*;

public class Main_5 {
    public static int distinctMoves(String s, int n, int x, int y) {
        // Write your code here
        Queue<SubSequence> q = new LinkedList<>();
        Set<String> set = new HashSet<>();

        int distance = y - x;
        int result = 0;

        int value = 0;
        for (int idx = 0; idx < s.length(); idx++) {
            if (s.charAt(idx) == 'r') {
                value++;
            } else {
                value--;
            }
        }
        set.add(s);
        q.add(new SubSequence(s, value));

        while (!q.isEmpty()) {
            SubSequence subSequence = q.poll();
            if (subSequence.value == distance && checkSequence(subSequence.sequence, x, n)) {
                result++;
            }
            List<SubSequence> candidates = subSequence.getChildren();
            for (SubSequence candidate : candidates) {
                if (!set.contains(candidate.sequence)) {
                    set.add(candidate.sequence);
                    q.add(candidate);
                }
            }
        }

        return result;
    }

    private static boolean checkSequence(String sequence, int begin, int max) {
        int cur = begin;

        for (int idx = 0; idx < sequence.length(); idx++) {
            if (sequence.charAt(idx) == 'r') {
                cur++;
            } else {
                cur--;
            }

            if (cur < 0 || cur > max) {
                return false;
            }
        }

        return true;
    }

    static class SubSequence {
        String sequence;
        int value;

        public SubSequence(String sequence, int value) {
            this.sequence = sequence;
            this.value = value;
        }

        public List<SubSequence> getChildren() {
            List<SubSequence> result = new ArrayList<>();
            for (int idx = 0; idx < sequence.length(); idx++) {
                int value = this.value + (sequence.charAt(idx) == 'l' ? 1 : -1);
                String subSequence = sequence.substring(0, idx) + sequence.substring(idx + 1, sequence.length());
                result.add(new SubSequence(subSequence, value));
            }

            return result;
        }
    }
}
