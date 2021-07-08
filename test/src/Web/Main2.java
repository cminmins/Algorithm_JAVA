package Web;

import java.util.ArrayList;
import java.util.Arrays;

public class Main2 {

    public static String[] solution(String s) {
        String[] answer = {};
        ArrayList<String> al = new ArrayList<>();

        int cnt = 0;
        int idx1 = 0;

        int n = s.length();
        boolean check = false;
        while (idx1 < (n + 1) / 2) {
            cnt = 1;
            while ((idx1 + cnt) <= (n + 1) / 2) {
                String temp = s.substring(idx1, idx1 + cnt);
                int test = s.lastIndexOf(temp);
                if (s.lastIndexOf(temp) == n - cnt - idx1) {
                    al.add(temp);
                    s = s.substring(idx1 + cnt, n - cnt - idx1);
//                    idx1 += cnt;
                    idx1 = 0;
                    check = true;
                    break;
                }
                else{
                    check = false;
                }
                cnt++;
            }
            n = s.length();
            if(!check) {
                break;
            }
        }
        ArrayList<String> last = new ArrayList<>();
        for(String str : al){
            last.add(str);
        }
        if(!s.equals("")){
            last.add(s);
        }
        for(int i=al.size()-1; i>=0; i--) {
            last.add(al.get(i));
        }
        answer = last.toArray(new String[last.size()]);
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("abcxyasdfasdfxyabc")));
        System.out.println(Arrays.toString(solution("abcxyqwertyxyabc")));
        System.out.println(Arrays.toString(solution("abcabcabcabc")));
        System.out.println(Arrays.toString(solution("llttaattll")));
        System.out.println(Arrays.toString(solution("zzzzzz")));
        System.out.println(Arrays.toString(solution("abcdef")));
        return;
    }
}
