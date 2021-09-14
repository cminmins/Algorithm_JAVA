//package kakako_2021;
//
//import java.util.Arrays;
//
//public class Main4 {
//
//    class Solution {
//        private static int maxScoreDiff;
//        private static int[] answer;
//
//        public int[] solution(int n, int[] info) {
//            answer = new int[11];
//            maxScoreDiff = -1;
//
//            int[] history = new int[11];
//            shootArrow(info, history, true, n, 0, 0, 0);
//
//            Arrays.fill(history, 0);
//            shootArrow(info, history, false, n, 0, 0, 0);
//
//            if (maxScoreDiff == -1) {
//                return new int[]{-1};
//            }
//
//            return answer;
//        }
//
//        public void shootArrow(int[] info, int[] history, boolean willWin, int arrowCnt, int apeachScore, int ryanScore, int targetIdx) {
//            // 점수 10 -> 1점 승 패 판결중 화살 다 떨어지면 점수 차이 계산, targetIdx 10이면 0점일 때
//            if (arrowCnt == 0 || targetIdx > 9) {
//                // 라이언이 우승 할 때만
//                if (ryanScore <= apeachScore) {
//                    return;
//                }
//
//                // 10 ~ 1점 중에서 남은 화살 0개 일 때는 라이언이 계속 져야되니 어피치 점수 계산
//                if (targetIdx < 10) {
//                    for (int idx = targetIdx; idx < 10; idx++) {
//                        if (info[idx] > 0) {
//                            apeachScore += 10 - idx;
//                        }
//                    }
//                }
//
//                // 남은 화살 0점에 다 쏘기
//                if (arrowCnt > 0) {
//                    history[10] = arrowCnt;
//                }
//
//                int scoreDiff = ryanScore - apeachScore;
//
//                if (scoreDiff > maxScoreDiff) {
//                    maxScoreDiff = scoreDiff;
//                    for (int idx = 0; idx <= 10; idx++) {
//                        answer[idx] = history[idx];
//                    }
//                } else if (scoreDiff == maxScoreDiff && canChangeSameScoreDiff(history)) {
//                    // 라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러가지 일 경우
//                    // 가장 낮은 점수를 더 많이 맞힌 경우 return
//                    for (int idx = 0; idx <= 10; idx++) {
//                        answer[idx] = history[idx];
//                    }
//                }
//
//                history[10] = 0;
//
//                return;
//            }
//
//            // 질려고 할때
//            // 남아있는 화살수보다 어피치가 더 많이쐈을때
//
//            if (!willWin) {
//                if (info[targetIdx] > 0) {
//                    apeachScore += 10 - targetIdx;
//                }
//            }
//            else{
//                // 이기려고했는데 화살수가 부족함
//                if (info[targetIdx] >= arrowCnt) {
//                    return;
//                } else {
//                    // 어피치보다 1발은 더쏴야함
//                    history[targetIdx] = info[targetIdx] + 1;
//                    arrowCnt -= info[targetIdx] + 1;
//                    ryanScore += 10 - targetIdx;
//                }
//            }
//
//
//            if (!willWin || arrowCnt <= info[targetIdx]) {
//                // 어피치 승리
//                apeachScore += 10 - targetIdx;
//            } else {
//                // 라이언 승리
//                history[targetIdx] = info[targetIdx] + 1;
//                arrowCnt -= info[targetIdx] + 1;
//                ryanScore += 10 - targetIdx;
//            }
//            shootArrow(info, history, true, arrowCnt, apeachScore, ryanScore, targetIdx + 1);
//            shootArrow(info, history, false, arrowCnt, apeachScore, ryanScore, targetIdx + 1);
//
//            history[targetIdx] = 0;
//        }
//
//        public boolean canChangeSameScoreDiff(int[] history) {
//            for (int idx = 10; idx >= 0; idx--) {
//                if (history[idx] > answer[idx]) {
//                    return true;
//                }
//            }
//
//            for (int idx = 10; idx >= 0; idx--) {
//                if (history[idx] == answer[idx]) {
//                    continue;
//                }
//                else if(history[idx] > answer[idx]){
//                    return true;
//                }
//                else{
//                    return false;
//                }
//            }
//
//            return false;
//        }
//    }
//
//    public static void main(String[] args) {
//
//
//        return;
//    }
//}
