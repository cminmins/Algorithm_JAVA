package backjoon.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int s = 0;
        int e = N - 1;
        int min_value = Integer.MAX_VALUE;
        int ans_s = 0;
        int ans_e = N-1;
        while (s < e) {
            int sum = arr[s] + arr[e];
            if (min_value > Math.abs(sum)) {
                min_value = Math.abs(sum);
                ans_e = e;
                ans_s = s;
            }
            if (sum >= 0) {
                e--;
            } else {
                s++;
            }
        }
        System.out.println(arr[ans_s] + " " + arr[ans_e]);
    }
}