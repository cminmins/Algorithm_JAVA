package backjoon.silver.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] cnt = new int[100001];

        int result = -1;
        int start = 1;
        int end = 1;
        for (int i = 1; i <= N; i++) {
            if (cnt[arr[i]] < K) {
                end = i;
                cnt[arr[i]]++;
                result = Math.max(result, end - start + 1);
            } else {
                while (true) {
                    if (arr[start] == arr[i]) {
                        start++;
                        end = i;
                        break;
                    } else {
                        cnt[arr[start]]--;
                        start++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
