package backjoon.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int s = 1;
        int e = 1;
        int cnt = 0;
        int length = 0;

        while (s <= N && arr[s] % 2 == 1) {
            s++;
        }
        e = s;

        while (s <= e && e <= N) {
            if (arr[e] % 2 == 0) {
                length++;
            } else if (arr[e] % 2 == 1) {
                cnt++;
            }
            if (cnt > K || e == N) {
                result = Math.max(result, length);
                while ( s <= N && arr[s] % 2 == 0) {
                    s++;
                    length--;
                }
                s++;
                cnt--;
            }
            e++;
        }
        System.out.println(result);
        return;
    }
}
