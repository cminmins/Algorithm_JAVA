package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_15686 {

    static class pair{
        int y;
        int x;
        int dis;

        public pair(int y, int x) {
            this.y = y;
            this.x = x;
            this.dis = Integer.MAX_VALUE;
        }
    }

    static ArrayList<pair> house = new ArrayList<>();
    static ArrayList<pair> store = new ArrayList<>();
    static ArrayList<pair> selected = new ArrayList<>();

    public static int counting(pair a, pair b) {
        return Math.abs(a.y - b.y) + Math.abs(a.x - b.x);
    }

    public static int countDistance(ArrayList<pair> sel, int m) {
        int[] dis = new int[house.size()];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            pair t = sel.get(i);
            for (int j = 0; j < house.size(); j++) {
                dis[j] = Math.min(dis[j], counting(t, house.get(j)));
            }
        }

        int sum = 0;
        for (int j = 0; j < house.size(); j++) {
            sum += dis[j];
        }
        return sum;
    }

    static int ans = Integer.MAX_VALUE;
    public static void findBestDistance(int idx, int m) {
        if (selected.size() == m) {
            ans = Math.min(ans, countDistance(selected, m));
            return;
        }

        for (int i = idx; i < store.size(); i++) {
            selected.add(store.get(i));
            findBestDistance(i + 1, m);
            selected.remove(selected.size() - 1);
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
//        int[][] map = new int[n + 1][c + 1];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {
                    house.add(new pair(y, x));
                } else if (temp == 2) {
                    store.add(new pair(y, x));
                }
            }
        }
        findBestDistance(0, m);
        System.out.println(ans);
        return;
    }

}
