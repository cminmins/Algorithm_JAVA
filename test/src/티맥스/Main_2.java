package 티맥스;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main_2 {
    private static char[] chars;
    private static StringBuilder sb;
    private static Set<String> wordsSet;

    public static String[] solution(String letters) {
        int len = letters.length();
        chars = new char[len];
        wordsSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            chars[i] = letters.charAt(i);
        }
        sb = new StringBuilder();
        makePermutation(0, len, new char[len], new boolean[len]);
        String[] answer = wordsSet.toArray(new String[wordsSet.size()]);
        Arrays.sort(answer);
        return answer;
    }

    public static void makePermutation(int cur, int r, char[] picked, boolean[] visited) {
        if (r == cur) {
            sb = new StringBuilder();
            for (int i = 0; i < picked.length; i++) {
                sb.append(picked[i]);
            }
            String res = sb.toString();
            if (wordsSet.contains(res)) {
                return;
            }
            wordsSet.add(res);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (cur > 0 && chars[i] == picked[cur - 1]) {
                break;
            }
            visited[i] = true;
            picked[cur] = chars[i];
            makePermutation(cur + 1, r, picked, visited);
            visited[i] = false;
        }
    }


    public static void main(String[] args) {

//        "abca"["abac", "abca", "acab", "acba", "baca", "caba"]
//        "abcbc"["abcbc", "acbcb", "bacbc", "bcabc", "bcacb", "bcbac", "bcbca", "cabcb", "cbabc", "cbacb", "cbcab", "cbcba"]
//        "wxyz"["wxyz", "wxzy", "wyxz", "wyzx", "wzxy", "wzyx", "xwyz", "xwzy", "xywz", "xyzw", "xzwy", "xzyw", "ywxz", "ywzx", "yxwz", "yxzw", "yzwx", "yzxw", "zwxy", "zwyx", "zxwy", "zxyw", "zywx", "zyxw"]
        for (String str : solution("abca")) {
            System.out.println(str);
        }
        return;
    }
}
