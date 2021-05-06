package 누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14929 {

    public static void main(String[] Argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long t = Long.parseLong(st.nextToken());
        long[] arr = new long[(int) t];
        long total = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i =0; i<t; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        long answer = 0;
        for(int i=0; i<t; i++){
            total -= arr[i];
            answer += total * arr[i];
        }
        System.out.println(answer);
        return;
    }
}
