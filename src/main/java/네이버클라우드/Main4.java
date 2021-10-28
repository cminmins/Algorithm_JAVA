//package 네이버클라우드;
//
//import java.io.IOException;
//import java.util.Arrays;
//
///*
//고객이 원하는 시간대에 회의 예약 o
//고객은 예약한 시간 동안 반드시 회의실 사용
//예약한 시간보다 일찍 사용 종료하거나 예약하고 희의실 사용 안하는 경우는 없음
//
// */
//
//public class Main4 {
//    public static void main(String[] args) throws IOException {
////        Solution s = new Solution();
//        /*int[][] info = new int[][]{{2, 3}, {2, 5}, {2, 2}, {3, 3}};
//
//        Arrays.sort(info, (o1, o2) -> {
//            if(o1[0] - o2[0] == 0) {
//                return o1[1] - o2[1];
//            } else {
//                return o1[0] - o2[0];
//            }
//        });
//
//        int[] sortedStart = new int[info.length];
//        for(int idx = 0; idx < info.length; idx++) {
//            sortedStart[idx] = info[idx][0];
//        }
//
//        for (int idx = 0; idx < info.length; idx++) {
//            System.out.printf("%d %d %d\n", Arrays.binarySearch(sortedStart, idx, info.length, 2),
//                    Arrays.binarySearch(sortedStart, idx, info.length, 3),
//                    Arrays.binarySearch(sortedStart, idx, info.length, 4));
//        }
//
//
//        System.out.println("--------------------");
//        Arrays.stream(info).map(o -> o[0] + ", " + o[1]).forEach(System.out::println);*/
//
//        Solution4 s = new Solution4();
//        int[][] info1 = new int[][]{{1, 5}, {1,4}, {1,3}, {3,4}, {3, 5}, {7, 8}};
//        int[][] info2 = new int[][]{{2, 3}, {2, 5}, {2, 2}, {3, 3}};
//        int[][] info3 = new int[][]{{1, 2}, {2, 3}, {4, 5}, {5, 6}};
//
//        int[] answer1 = s.solution(info1);
//        System.out.println("------------------------");
//        Arrays.stream(answer1).forEach(System.out::println);
//
//        int[] answer2 = s.solution(info2);
//        System.out.println("------------------------");
//        Arrays.stream(answer2).forEach(System.out::println);
//
//        int[] answer3 = s.solution(info3);
//        System.out.println("------------------------");
//        Arrays.stream(answer3).forEach(System.out::println);
//    }
//}
//
//
//class Solution4 {
//    private static int MAX_SECOND = 86399;
//
//    public int[] solution(int[][] info) {
//        int[] answer = {};
//
//        int[] potential = new int[MAX_SECOND + 1];
//        int maxCnt = 0;
//        int potentialIdx = 0;
//
//        Arrays.sort(info, (o1, o2) -> {
//            if(o1[0] - o2[0] == 0) {
//                return o1[1] - o2[1];
//            } else {
//                return o1[0] - o2[0];
//            }
//        });
//
//        int[] sortedStart = new int[info.length];
//        for (int idx = 0; idx < info.length; idx++) {
//            sortedStart[idx] = info[idx][0];
//        }
//
//        // 메인 로직
//        int currSecond = sortedStart[0];
//        int currIdx = 0;
//        int endIdx = 0;
//        int cnt = 0;
//
//        while (currIdx < info.length) {
//
//            if (info[currIdx][1] < currSecond) {
//                currIdx++;
//                continue;
//            } else if(info[currIdx][0] <= currSecond) {
//                endIdx = Arrays.binarySearch(sortedStart, currIdx, info.length, currSecond + 1);
//
//                if (endIdx < 0) {
//                    endIdx = (endIdx + 1) * -1;
//                }
//
//                cnt = endIdx - currIdx;
//
//                if (cnt > maxCnt) {
//                    potentialIdx = 0;
//                    potential[potentialIdx++] = currSecond;
//                    maxCnt = cnt;
//                } else if (cnt == maxCnt) {
//                    potential[potentialIdx++] = currSecond;
//                }
//            }
//
//            currSecond++;
//        }
//
//        answer = new int[potentialIdx];
//        for (int idx = 0; idx < potentialIdx; idx++) {
//            answer[idx] = potential[idx];
//        }
//
//        return answer;
//    }
//}

import java.util.Arrays;

class Solution4 {
    final int MAX_SEC = 86400;
    public int[] solution(int[][] info) {
        int[] begins = new int[info.length];
        int[] ends = new int[info.length];
        int[] weights = new int[MAX_SEC];

        for(int idx = 0; idx < info.length; idx++) {
            begins[idx] = info[idx][0];
            ends[idx] = info[idx][1];
        }

        Arrays.sort(begins);
        Arrays.sort(ends);

        int maxSec = ends[info.length - 1];

        int cur = 0;
        int weight = 0;
        int beginPtr = 0;
        int endPtr = 0;
        int maxValue = 0;
        int count = 0;

        while(cur < maxSec + 1) {
            while (beginPtr < info.length && begins[beginPtr] == cur) {
                weight++;
                beginPtr++;
            }

            weights[cur] = weight;
            if (weight > maxValue) {
                maxValue = weight;
                count = 1;
            } else if (weight == maxValue) {
                count++;
            }

            while (endPtr < info.length && ends[endPtr] == cur) {
                weight--;
                endPtr++;
            }

            cur++;
        }

        int[] answer = new int[count];
        int answerIdx = 0;
        for (int idx = 0; idx < maxSec + 1; idx++) {
            if (maxValue == weights[idx]) {
                answer[answerIdx++] = idx;
            }
        }

        return answer;
    }
}