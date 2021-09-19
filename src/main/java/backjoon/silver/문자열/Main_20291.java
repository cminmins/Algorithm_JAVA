package backjoon.silver.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_20291 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

//        Map<String, Integer> ex = new HashMap<>();
        Map<String, Integer> ex = new TreeMap<>();
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken().split("\\.")[1];
            if (ex.containsKey(key)) {
                ex.put(key, ex.get(key) + 1);
            } else {
                ex.put(key, 1);
            }
        }
//        String[] mapkey = ex.keySet().toArray(new String[0]);
//        Arrays.sort(mapkey);
//        for (String fileKey : mapkey) {
//            System.out.println(fileKey + " " + ex.get(fileKey));
//        }

        for(String key : ex.keySet()) {
            System.out.println(key + " " + ex.get(key));
        }
        return;
    }
}
