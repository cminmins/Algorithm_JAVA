package backjoon.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_15961 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] chobab = new int[N];
        Map<Integer, Integer> myChoice = new HashMap();
        int result = 0;

        for (int i = 0; i < N; i++) {
            chobab[i] = Integer.parseInt(br.readLine());
        }
        for (int j = 0; j < k; j++) {
            myChoice.put(chobab[j], myChoice.getOrDefault(chobab[j], 0) + 1);
        }

        for (int i = 0; i < N; i++) {
            if (myChoice.containsKey(c)) {
                result = Math.max(result, myChoice.size());
            } else {
                result = Math.max(result, myChoice.size() + 1);
            }

            int end = (i + k) % N;
            if (myChoice.get(chobab[i]) == 1) {
                myChoice.remove(chobab[i]);
            } else {
                myChoice.put(chobab[i], myChoice.get(chobab[i]) - 1);
            }
            myChoice.put(chobab[end], myChoice.getOrDefault(chobab[end], 0) + 1);
        }
        System.out.println(result);
        return;
    }
}
