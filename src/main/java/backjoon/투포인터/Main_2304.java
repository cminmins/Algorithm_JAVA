package backjoon.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] building = new int[1001];
        int min_idx = 1001;
        int max_idx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            min_idx = Math.min(min_idx, x);
            max_idx = Math.max(max_idx, x);
            building[x] = y;
        }


        int s = min_idx;
        int e = max_idx;
        int roof = 0;
        int l_w = building[s];
        int r_w = building[e];
        while (s < e) {
            if (building[s] < building[e]) {
                roof += l_w;
                l_w = Math.max(l_w, building[++s]);
            } else {
                roof += r_w;
                r_w = Math.max(r_w, building[--e]);
            }
        }
        roof += building[s];
        System.out.println(roof);
        return;
    }
}
