package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3020 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] icicle = new int[H];
        int[] bamboo = new int[H];

        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                bamboo[t - 1] += 1;
            } else {
                icicle[H - t] += 1;
            }
        }

        for (int i = H - 1; i > 0; i--) {
            bamboo[i - 1] += bamboo[i];
        }
        for (int i = 0; i < H - 1; i++) {
            icicle[i + 1] += icicle[i];
        }
        for (int i = 0; i < H; i++) {
            bamboo[i] += icicle[i];
        }
        int min_value = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            if (min_value > bamboo[i]) {
                cnt = 1;
                min_value = bamboo[i];
            } else if (min_value == bamboo[i]) {
                cnt++;
            }
        }
        System.out.println(min_value + " " + cnt);
        return;
    }
}
