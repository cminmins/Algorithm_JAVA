package backjoon.누적합;

import java.io.*;
import java.util.StringTokenizer;

public class Main_21318 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] music = new int[t + 1];
        for (int i = 1; i <= t; i++) {
            music[i] = Integer.parseInt(st.nextToken());
        }

        int[] miss = new int[t + 1];
        for (int i = 1; i < t; i++) {
            // 실수한다
            if (music[i] > music[i + 1]) {
                miss[i]++;
            }
            // 누적
            miss[i] += miss[i - 1];
        }
        miss[t] = miss[t - 1];

        st = new StringTokenizer(br.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int i = 0; i < test; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (end + 1 <= t && music[end] > music[end + 1]) {
//                System.out.println(miss[end] - miss[start - 1] - 1);
                bw.write(miss[end] - miss[start - 1] - 1 + "\n");
            } else {
//                System.out.println(miss[end] - miss[start - 1]);
                bw.write(miss[end] - miss[start - 1] + "\n");
            }
        }
        bw.flush();
        bw.close();
        return;
    }
}
