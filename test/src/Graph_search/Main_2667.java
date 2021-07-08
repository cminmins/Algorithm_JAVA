package Graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2667 {

    static class pos {
        int y;
        int x;

        pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int test = Integer.parseInt(st.nextToken());

        int[] yd = {-1, 0, 1, 0};
        int[] xd = {0, 1, 0, -1};

        int[][] map = new int[test][test];
        int[][] check = new int[test][test];
        Queue<pos> q = new LinkedList<>();
        for(int y=0; y<test; y++){
            String tmp = br.readLine();
            for (int x = 0; x < test; x++) {
                map[y][x] = tmp.charAt(x) - 48;
            }
        }

        int total = 0;
        ArrayList<Integer> al = new ArrayList<>();
        for (int b = 0; b < test; b++) {
            for (int a = 0; a < test; a++) {
                if (check[b][a] == 0 && map[b][a] == 1) {
                    q.add(new pos(b, a));
                    check[b][a] = ++total;
                    int semi = 1;

                    // 방문하지 않았고, 집이 있는 곳에서부터 BFS 탐색
                    while (!q.isEmpty()) {
                        int y = q.peek().y;
                        int x = q.peek().x; q.poll();
                        for (int i = 0; i < 4; i++) {
                            int yy = y + yd[i];
                            int xx = x + xd[i];
                            if (yy >= 0 && yy < test && xx >= 0 && xx < test) {
                                if (check[yy][xx] == 0 && map[yy][xx] == 1) {
                                    check[yy][xx] = total;
                                    q.add(new pos(yy, xx));
                                    semi++;
                                }
                            }
                        }
                    }
                    al.add(semi);
                }
            }
        }
        System.out.println(total);
        Collections.sort(al);
        for (Integer t : al) {
            System.out.println(t);
        }
        return;
    }
}
