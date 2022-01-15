package 카카오2022블라인드;
//https://tech.kakao.com/2022/01/14/2022-kakao-recruitment-round-1/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main1 {


    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> members = new HashMap<>();
//        boolean[][] userReport = new boolean[id_list.length][id_list.length];

        Map<String, ArrayList<String>> mem = new HashMap<>();
//        Map<String, Integer> userCount = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
//            userCount.put(id_list[i], 0);
            mem.put(id_list[i], new ArrayList<String>());
            members.put(id_list[i], i);
        }

        for (int i = 0; i < report.length; i++) {
            // [0] - from, [1] - to
            String[] str = report[i].split(" ");
            if (!mem.get(str[1]).contains(str[0])) {
                mem.get(str[1]).add(str[0]);
            }

//            int fromIndex = members.get(str[0]);
//            int toIndex = members.get(str[1]);
//            userReport[fromIndex][toIndex] = true;
//            userCount.put(str[1], userCount.get(toIndex) + 1);
        }

        for (int i = 0; i < id_list.length; i++) {
            if (mem.get(id_list[i]).size() >= k) {
                for (String str : mem.get(id_list[i])) {
                    answer[members.get(str)]++;
                }
            }
        }

//        // 신고횟수 누적
//        int[] waring = new int[id_list.length];
//        for (int i = 0; i < id_list.length; i++) {
//            for (int j = 0; j < id_list.length; j++) {
//                if (i == j) {
//                    continue;
//                }
//                if (userReport[i][j] == true) {
//                    waring[j]++;
//                }
//            }
//        }
//
//        // k번 이상 경고먹은 유저를 신고한 사람들에게 발송 메일 계산
//        for (int i = 0; i < id_list.length; i++) {
//            if (waring[i] >= k) {
//                for (int j = 0; j < id_list.length; j++) {
//                    if (i == j) {
//                        continue;
//                    }
//                    if (userReport[j][i] == true) {
//                        answer[j]++;
//                    }
//                }
//            }
//        }
        return answer;
    }


    public static void main(String[] args) throws IOException {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        int[] answer = solution(id_list, report, k);
        for (int i : answer) {
            System.out.print(i + " ");
        }
        return;
    }
}


//        import java.util.*;
//class Solution {
//    public int[] solution(String[] id_list, String[] report, int k) {
//        // key: 신고당한놈, value: 몇명한테 당했는지
//        Map<String, Set<String>> map = new HashMap<>();
//
//        for (String rep : report) {
//            String[] arr = rep.split(" ");
//            Set<String> set = map.getOrDefault(arr[1], new HashSet<>());
//            set.add(arr[0]);
//            map.put(arr[1], set);
//        }
//
//        // key: 알림받을 놈, value: 몇번 알림받을지
//        Map<String, Integer> countMap = new LinkedHashMap<>();
//
//        for (String id : id_list) {
//            countMap.put(id, 0);
//        }
//
//        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
//            if (entry.getValue().size() >= k) { // 정지당할놈
//                for (String value : entry.getValue()) {
//                    countMap.put(value, countMap.getOrDefault(value, 0) + 1);
//                }
//            }
//        }
//
//        return countMap.values().stream().mapToInt(Integer::intValue).toArray();
//    }
//}