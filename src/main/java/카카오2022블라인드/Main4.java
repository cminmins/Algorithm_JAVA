package 카카오2022블라인드;
//https://tech.kakao.com/2022/01/14/2022-kakao-recruitment-round-1/
//https://programmers.co.kr/learn/courses/30/lessons/92342

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main4 {
    static int maxValue = Integer.MIN_VALUE;
    static int[] answer = new int[11];

    static void dfs(int r, int lionScore, int peachScore, int index, int[] lion, int[] peach) {
        if (r == 0 || index > 10) {
            boolean check = false;
            if (peachScore >= lionScore) {
                return;
            }

            if(maxValue < lionScore - peachScore){
                maxValue = lionScore - peachScore;
                answer = lion.clone();
                if (r > 0 && index > 10) {
                    answer[10] = r;
                }
            } else if(maxValue == lionScore - peachScore) {
                for (int i = 10; i >= 0; i--) {
                    if (lion[i] > answer[i]) {
                        check = true;
                        break;
                    } else if(lion[i] < answer[i]){
                        break;
                    }
                }
                if (check == true) {
                    answer = lion.clone();
                    if (r > 0 && index > 10) {
                        answer[10] = r;
                    }
                }
            }
            return;
        }

        if (peach[index] > 0) {
            // 두가지 경우 어떻게든 영끌해서 이기는거
            if (peach[index] < r) {
                lion[index] = peach[index] + 1;
                dfs(r - (peach[index] + 1), lionScore + (10 - index), peachScore - (10 - index), index + 1, lion, peach);
                lion[index] = 0;
            }

            // 이번 점수는 내주고 다음 점수에서 얻어가기
            dfs(r, lionScore, peachScore, index + 1, lion, peach);
        } else {
            // 라이언이 1개쏘고 이기기
            lion[index] = 1;
            dfs(r - 1, lionScore + (10 - index), peachScore, index + 1, lion, peach);
            lion[index] = 0;

            // 아무도 점수 흭득 X
            dfs(r, lionScore, peachScore, index + 1, lion, peach);
        }

        return;
    }

    static int[] solution(int n, int[] info) {
        int[] lion = new int[11];
        int sum =0;
        for (int i = 0; i <= 10; i++) {
            if (info[i] > 0) {
                sum += 10 - i;
            }
        }

        dfs(n, 0, sum, 0, lion, info);
        for (int i = 0; i <= 10; i++) {
            if (answer[i] != 0) {
                return answer;
            }
        }
        return new int[]{-1};
    }


    public static void main(String[] args) throws IOException {
        solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0});
        for (int i = 0; i <= 10; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println();

        boolean check = false;
        int[] t2 = {1, 1, 1, 1, 2, 0, 0, 2, 0, 0, 0};
        int[] t1 = {1, 1, 1, 1, 2, 0, 0, 0, 1, 1, 0};
        for (int i = 10; i >= 0; i--) {
            if (t1[i] < t2[i]) {
                check = true;
                break;
            }
        }
        if (check == true) {
            t1 = t2.clone();
        }

//        maxValue = Integer.MIN_VALUE;
//        answer = new int[11];
//        solution(1, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
//        for (int i = 0; i <= 10; i++) {
//            System.out.print(answer[i] + " ");
//        }
//        System.out.println();

//        maxValue = Integer.MIN_VALUE;
//        answer = new int[11];
//        solution(9, new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1});
//        for (int i = 0; i <= 10; i++) {
//            System.out.print(answer[i] + " ");
//        }
//        System.out.println();
//
//        maxValue = Integer.MIN_VALUE;
//        answer = new int[11];
//        solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3});
//        for (int i = 0; i <= 10; i++) {
//            System.out.print(answer[i] + " ");
//        }
//        System.out.println();

        return;
    }
}