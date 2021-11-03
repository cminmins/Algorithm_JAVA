package backjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_6137 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[] str = new char[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine().charAt(0);
        }


        int s = 0;
        int e = N - 1;
        while (s < e) {
            if (str[s] < str[e]) {
                sb.append(str[s++]);
            } else if (str[s] > str[e]) {
                sb.append(str[e--]);
            } else {
                int ss = s + 1;
                int ee = e - 1;
                boolean check = true; // true == L, false == R
                while (ss < ee) {
                    if (str[ss] < str[ee]) {
                        check = true;
                        break;
                    } else if (str[ss] > str[ee]) {
                        check = false;
                        break;
                    } else {
                        ss++;
                        ee--;
                    }
                }
                if (check) {
                    sb.append(str[s++]);
                } else {
                    sb.append(str[e--]);
                }
            }
        }
        sb.append(str[s]);
        int cnt = 0;
        for (int i = 0; i < sb.length(); i++) {
            System.out.print(sb.charAt(i));
            if (++cnt == 80) {
                System.out.println();
                cnt = 0;
            }
        }
    }
}
