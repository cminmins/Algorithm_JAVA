package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[8001];
        int[] avg = new int[n];
        ArrayList<Integer> al = new ArrayList<>();
        int max_value = Integer.MIN_VALUE;
        int min_value = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int s = Integer.parseInt(br.readLine());
            sum += s;
            if (s < 0) {
                arr[Math.abs(s)]++;
            } else {
                arr[4000 + s]++;
            }
            avg[i] = s;
            max_value = Math.max(max_value, s);
            min_value = Math.min(min_value, s);
        }
        int maxCnt = 0;
        for (int i = min_value; i <= max_value; i++) {
            if (i < 0) {
                maxCnt = Math.max(maxCnt, arr[Math.abs(i)]);
            } else {
                maxCnt = Math.max(maxCnt, arr[4000 + i]);
            }
        }
        for (int i = min_value; i <= max_value; i++) {
            if (i < 0) {
                if (maxCnt == arr[Math.abs(i)]) {
                    al.add(i);
                }
            } else {
                if (maxCnt == arr[4000 + i]) {
                    al.add(i);
                }
            }
        }

        Arrays.sort(avg);
        Collections.sort(al);
        if (sum / n < 0) {
            System.out.println(Math.floorDiv(sum, n));
        } else {
            System.out.println(Math.round(sum / n));
        }
        System.out.println(avg[n / 2]);
        if (al.size() > 1) {
            System.out.println(al.get(1));
        } else {
            System.out.println(al.get(0));
        }
        System.out.println(max_value - min_value);
    }

}
