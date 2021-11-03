package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Integer> compress = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // '(' == -1
            if (c == ')') {
                int temp = 0;
                while (compress.peek() != -1) {
                    temp += compress.pop();
                }
                compress.pop();
                temp *= compress.pop();
                compress.push(temp);
            } else if (c == '(') {
                compress.pop();
                compress.push(Integer.parseInt(String.valueOf(str.charAt(i - 1))));
                compress.push(-1);
            } else {
                compress.push(1);
            }
        }

        int cnt =0;
        while (!compress.empty()) {
            cnt += compress.pop();
        }
        System.out.println(cnt);
    }
}
