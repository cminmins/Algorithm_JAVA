package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] block = new int[W];
        int max_index = -1;
        int max_h = Integer.MIN_VALUE;
        int rain = 0;


        for (int i = 0; i < W; i++) {
            block[i] = Integer.parseInt(st.nextToken());
            if (block[i] >= max_h) {
                max_index = i;
                max_h = block[i];
            }
        }
//        for (int i = 0; i < max_index; i++) {
//            int temp_sum = 0;
//            for (int j = i + 1; j <= max_index; j++) {
//                if (block[j] >= block[i]) {
//                    rain += temp_sum;
//                    i = j - 1;
//                    break;
//                } else {
//                    temp_sum += block[i] - block[j];
//                }
//            }
//        }
//
//        for (int i = W-1; i > max_index; i--) {
//            int temp_sum = 0;
//            for (int j = i - 1; j >= max_index; j--) {
//                if (block[j] >= block[i]) {
//                    rain += temp_sum;
//                    i = j + 1;
//                    break;
//                } else {
//                    temp_sum += block[i] - block[j];
//                }
//            }
//        }

        int height = block[0];
        int temp_sum = 0;
        for (int i = 1; i <= max_index; i++) {
            if (height > block[i]) {
                temp_sum += height - block[i];
            } else {
                height = block[i];
                rain += temp_sum;
                temp_sum = 0;
            }
        }

        height = block[W - 1];
        temp_sum = 0;
        for (int i = W - 2; i >= max_index; i--) {
            if (height > block[i]) {
                temp_sum += height - block[i];
            } else {
                height = block[i];
                rain += temp_sum;
                temp_sum = 0;
            }
        }
        System.out.println(rain);
    }
}
