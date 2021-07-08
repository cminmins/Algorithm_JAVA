package 딜리버리히어로;

import java.util.HashMap;
import java.util.Map;

public class Main3 {
public static int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 1;
        int count = 1;
        int left = 0;
        int right = 0;
        map.put(A[0], 1);

        while (right < A.length - 1) {
            right++;

            if (map.containsKey(A[right])) {
                map.replace(A[right], map.get(A[right]) + 1);
            } else {
                map.put(A[right], 1);
                count++;
            }

            if (count < 3) {
                result = Math.max(right - left + 1, result);
                continue;
            }

            while (left < right && count > 2) {
                map.replace(A[left], map.get(A[left]) - 1);
                if (map.get(A[left]) == 0) {
                    map.remove(A[left]);
                    count--;
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args){


        return;
    }
}

//
//import java.util.HashMap;
//        import java.util.Map;
//
//class Solution {
//    public int solution(int[] A) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int result = 1;
//        int count = 1;
//        int left = 0;
//        int right = 0;
//        map.put(A[0], 1);
//
//        while (right < A.length - 1) {
//            right++;
//
//            if (map.containsKey(A[right])) {
//                map.replace(A[right], map.get(A[right]) + 1);
//            } else {
//                map.put(A[right], 1);
//                count++;
//            }
//
//            if (count < 3) {
//                result = Math.max(right - left + 1, result);
//                continue;
//            }
//
//            while (left < right && count > 2) {
//                map.replace(A[left], map.get(A[left]) - 1);
//                if (map.get(A[left]) == 0) {
//                    map.remove(A[left]);
//                    count--;
//                }
//                left++;
//            }
//        }
//        return result;
//    }
//}

