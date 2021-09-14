package backjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_20438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken()) + 2;
        int[] students = new int[t+1];
        int sleepCount = Integer.parseInt(st.nextToken());
        int sendCount = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<Integer> s = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sleepCount; i++) {
            int sleepNum = Integer.parseInt(st.nextToken());
            s.add(sleepNum);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sendCount; i++) {
            int sendNum = Integer.parseInt(st.nextToken());
            if (s.contains(sendNum)) {
                continue;
            }

            for (int k = sendNum; k <= t; k += sendNum) {
                students[k] = 1;
            }
        }

        int[] result = new int[t+1];
        for (int i = 3; i <= t; i++) {
            if (students[i] == 0 || s.contains(i)) {
                result[i] = result[i - 1] + 1;
            } else {
                result[i] = result[i - 1];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.print(result[end] - result[start]);
        }
        return;
    }
}
