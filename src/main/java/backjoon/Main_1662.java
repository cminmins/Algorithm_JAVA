package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
//        Stack<Character> compress = new Stack<>();
//        int cnt = 0;
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if (c == ')') {
//                int temp = 0;
//                while (compress.peek() != '(') {
//                    if (compress.pop() == 'a') {
//                        temp += cnt;
//                    } else {
//                        temp++;
//                    }
//                }
//                compress.pop();
//                int d = Integer.parseInt(String.valueOf(compress.pop()));
//                temp *= d;
//                cnt += temp;
//                if (cnt > 0) {
//                    compress.push('a');
//                }
//            } else {
//                compress.push(c);
//            }
//        }
//        if (!compress.isEmpty() && compress.peek() == 'a') {
//            cnt = cnt + compress.size() - 1;
//        } else {
//            cnt += compress.size();
//        }

        int index=0;
        String[] list = new String[str.length() + 1];
        for (int i = 0; i < str.length(); i++) {
            String c = String.valueOf(str.charAt(i));
            if (c.equals(')')) {
                0
            }

            list[index++] = c;


        }


        System.out.println(cnt);
    }
}
