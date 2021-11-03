package backjoon;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16235 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[][] live = new ArrayList[N + 1][N + 1];
        // [0]은 양분, [1]은 토지
        int[][][] A = new int[N + 1][N + 1][2];
        int t = A[1].length;
        for (int y = 1; y <= N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= N; x++) {
                live[y][x] = new ArrayList<>();
                A[y][x][0] = Integer.parseInt(st.nextToken());
                A[y][x][1] = 5;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            live[y][x].add(age);
        }
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};

        // 최초 1회 정렬
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                Collections.sort(live[y][x], Collections.reverseOrder());
            }
        }

        for (int i = 0; i < K; i++) {
            // 봄
            for (int y = 1; y <= N; y++) {
                for (int x = 1; x <= N; x++) {
                    int sum = 0;
                    for (int k = live[y][x].size() - 1; k >= 0; k--) {
                        int age = live[y][x].get(k);
                        if (A[y][x][1] >= age) {
                            A[y][x][1] -= age;
                            live[y][x].set(k, age + 1);
                        } else {
                            live[y][x].remove(k);
                            sum += age / 2;
                        }
                    }
                    A[y][x][1] += sum;
                }
            }
            // 가을
            for (int y = 1; y <= N; y++) {
                for (int x = 1; x <= N; x++) {
                    for (int tree : live[y][x]) {
                        if (tree % 5 == 0) {
                            for (int d = 0; d < 8; d++) {
                                int yy = y + dy[d];
                                int xx = x + dx[d];
                                if (yy < 1 || xx < 1 || yy > N || xx > N) {
                                    continue;
                                }
                                live[yy][xx].add(1);

//                                if (yy >= 1 && yy <= N && xx >= 1 && xx <= N) {
//                                    live[yy][xx].add(1);
//                                }
                            }
                        }
                    }
                    A[y][x][1] += A[y][x][0];
                }
            }
        }

        int answer = 0;
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                answer += live[y][x].size();
            }
        }
        System.out.print(answer);
    }
}
