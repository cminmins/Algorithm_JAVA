package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        int[] ind = new int[n+1];
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
            ind[r]++;
            map.get(l).add(r);
        }

        for (int i = 1; i <= n; i++) {
            if (ind[i] == 0) {
                ind[i] = -1;
                q.add(i);
                ans.add(i);
                break;
            }
        }

        while (!q.isEmpty()) {
            int index = q.remove();
            for (int j = 0; j < map.get(index).size(); j++) {
                ind[map.get(index).get(j)]--;
            }

            for (int i = 1; i <= n; i++) {
                if (ind[i] == 0) {
                    ind[i] = -1;
                    q.add(i);
                    ans.add(i);
                }
            }
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        return;
    }
}