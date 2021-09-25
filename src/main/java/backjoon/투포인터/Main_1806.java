package backjoon.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int result = Integer.MAX_VALUE;
        int end = 0;
        int start = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            arr[i] += arr[i - 1];
        }

        while (start <= end && end < N) {
            int length = 0;
            int sum = 0;
            if (start == 0) {
                sum = arr[end];
                length = end + 1;
            }else{
                sum = arr[end] - arr[start - 1];
                length = end - start + 1;
            }

            if (sum >= S) {
                result = Math.min(result, length);
                if (start == end) {
                    end++;
                }
                start++;
            } else {
                end++;
            }

        }
        if (result == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
        return;
    }
}
