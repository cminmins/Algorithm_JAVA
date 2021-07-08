package Web;

public class Main3 {

    public static int solution(String s, String t) {
        int result = 0;
        int idx = -1;
        int n = t.length();

        StringBuilder sb = new StringBuilder(s);
        while ((idx = sb.indexOf(t)) >= 0) {
            sb.replace(idx, idx + n,"");
            result++;
        }


        return result;
    }


    public static void main(String[] args) {
        System.out.println(solution("aabcbcd", "abc"));
        System.out.println(solution("aaaaabbbbb", "ab"));
        String str = "a".repeat(1000000);
        System.out.println(solution(str, "a"));
        return;
    }
}
