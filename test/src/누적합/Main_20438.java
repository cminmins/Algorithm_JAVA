package 누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20438 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] sleep = br.readLine().split(" ");
        String[] awake = br.readLine().split(" ");

        int sleepcnt = 0;
        int awakecnt = 0;

        int[] arr = new int[n+3];
        for (int i = 0; i < q; i++) {
            int temp = Integer.parseInt(awake[i]);
            for(int idx=temp; idx<=n+2; idx+=temp){
                arr[idx]++;
            }
        }

        for (int i = 0; i < k; i++) {
            int temp = Integer.parseInt(sleep[i]);
            arr[temp] = 0;
//            for(int idx=temp; idx<n+2; idx+=idx){
//               arr[idx] = 0;
//            }
        }

        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int answer = 0;
            for (int i = x; i <= y; i++) {
                if (arr[i] <= 0) {
                    answer++;
                }
            }
            System.out.println(answer);
        }
        return;
    }
}