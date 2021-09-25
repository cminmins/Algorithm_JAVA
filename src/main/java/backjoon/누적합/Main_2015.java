package backjoon.누적합;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            arr[i] += arr[i - 1];
        }

        int count = 0;
        for (int s = 0; s < N; s++) {
            for (int e = s; e < N; e++) {
                if (s - 1 >= 0 && (arr[e] - arr[s - 1] == K)) {
                    count++;
                } else if (s == 0 && (arr[e] == K)) {
                    count++;
                }
            }
        }
        System.out.println(count);
        return;
    }
}
