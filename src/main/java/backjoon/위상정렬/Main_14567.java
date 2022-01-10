package backjoon.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14567 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
//        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        ArrayList<Integer>[] arr = new ArrayList[n+1];
        int[] map = new int[n + 1];
        int[] ans = new int[n + 1];
        int depth = 0;

        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from].add(to);
            map[to]++;
        }

//        for (int i = 1; i <= n; i++) {
            depth++;
            Queue<Integer> q = new LinkedList<>();
            for (int j = 1; j <= n; j++) {
                if (ans[j] == 0 && map[j] == 0) {
                    ans[j] = depth;
                    q.add(j);
                }
            }
            while (!q.isEmpty()) {
                int index = q.remove();
                for (int t = 0; t < arr[index].size(); t++) {
                    int temp = arr[index].get(t);
                    map[temp]--;
                    if (map[temp] == 0) {
                        q.add(temp);
                        ans[temp] = ans[index] + 1;
                    }
                }
            }
//        }

        for (int t=1; t<=n; t++) {
            System.out.print(ans[t] + " ");
        }
        return;
    }
}
