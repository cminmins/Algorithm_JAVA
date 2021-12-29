package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        int[] bag = new int[100001];
        int total = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
            if (bag[w] == 0) {
                bag[w] = v;
            }
            for (int idx = w; idx < 100001; idx++) {
                if (bag[idx - w] > 0) {
                    bag[idx] = Math.max(bag[idx], bag[idx - w] + v);
                }
            }
        }
        System.out.println(bag[7]);
        return;
    }
}
