package backjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6550 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(str);
            String s = st.nextToken();
            String t = st.nextToken();
            int index = 0;
            boolean check = true;
            for (int i = 0; i < s.length(); i++) {
                if ((index = t.indexOf(s.charAt(i), index)) < 0){
                    check = false;
                    break;
                }
                index++;
            }
            if (check) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        return;
    }
}
