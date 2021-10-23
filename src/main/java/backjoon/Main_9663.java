package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_9663 {
    private static Integer[] temp;
    private static int N;
    private static int cnt = 0;

    static class pair_xy{
        int y;
        int x;

        public pair_xy(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    private static enum Op{
        branch,
        merge;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        temp = new Integer[N];

        StringBuilder sb = new StringBuilder();
        String str = "asd";
        Arrays.sort(temp, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        Queue<pair_xy> q = new LinkedList<>();
        q.add(new pair_xy(1, 1));
        TreeSet<Integer> se = new TreeSet<>();
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        ArrayList<Integer>[] arr = new ArrayList[3];
        arr[1] = new ArrayList<Integer>();


        ArrayList<Integer>[] al2 = new ArrayList[9];
        al2[0] = new ArrayList<>();
        ArrayList<pair_xy> al = new ArrayList<>();
        al2[2].add(3);
        dfs(0);
        System.out.println(cnt);

    }

    public static void dfs(int y) {
        if (y == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            temp[y] = i;
            if (checker(y)) {
                dfs(y + 1);
            }
        }
    }

    static boolean checker(int x) {
        for (int i = 0; i < x; i++) {
            // 같은열에 있을 경우
            if (temp[i] == temp[x]) {
                return false;
            } else if (Math.abs(i - x) == Math.abs(temp[i] - temp[x])) {
                return false;
            }
        }
        return true;
    }
}