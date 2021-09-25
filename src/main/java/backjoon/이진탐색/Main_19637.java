package backjoon.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_19637 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] characters = new int[M];
        String[] answer = new String[M];
        String[] arr = new String[N];
        int[] powers = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
            powers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            characters[i] = Integer.parseInt(br.readLine());
        }
        int index = 0;
        for (int i = 0; i < M; i++) {
            int find = characters[i];

            int left = 0;
            int right = N - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (powers[mid] < find) {
                    left = mid + 1;
                } else if (powers[mid] >= find){
                    right = mid -1;
                }
            }
            answer[i] = arr[left];
        }
        for (String str : answer) {
//            System.out.println(str);
            sb.append(str + '\n');
        }
        System.out.print(sb.toString());
    }
}
