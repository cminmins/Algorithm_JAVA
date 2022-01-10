package Ebay;

import java.util.HashMap;
import java.util.Map;

public class Main4 {

    static Map<Character, Integer> light = new HashMap<>();
    static char[] RGB = {'R', 'G', 'B'};

    public static void clickedButton(StringBuilder bulbs, int idx, int k, int op) {
        for (int i = 0; i < k; i++) {
            bulbs.setCharAt(idx+i, RGB[(3 + light.get(bulbs.charAt(idx+i)) + op) % 3]);
        }
        return;
    }

    public static boolean checkAllRed(StringBuilder bulbs, int n) {
        for (int i = 0; i < n; i++) {
            if (bulbs.charAt(i) != 'R') {
                return false;
            }
        }
        return true;
    }

    static int answer = Integer.MAX_VALUE;
    public static void dfs(StringBuilder bulbs, int s, int n, int k, int cnt) {
        if (answer <= cnt) {
            return;
        }
        if (checkAllRed(bulbs, n)) {
            answer = Math.min(answer, cnt);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (s != i) {
                clickedButton(bulbs, i, k, 1);
                dfs(bulbs, i, n, k, cnt+1);
                clickedButton(bulbs, i, k, -1);
            }
        }
        return;
    }



    public static int solution(int n, int k, String bulbs) {
        light.put('R', 0);
        light.put('G', 1);
        light.put('B', 2);
        dfs(new StringBuilder(bulbs), -1, n, k, 0);
        if (answer == Integer.MAX_VALUE) {
            return -1;
        } else {
            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(6, 3, "RBGRGB"));
        return;
    }
}

//    문제 설명
//    전구 n개가 일렬로 나열되어 있습니다. 각 전구는 빨강(R), 초록(G), 혹은 파란(B) 불빛이 들어와 있습니다. 당신은 k개의 연속된 전구를 선택해 아래와 같이 불빛을 한꺼번에 바꿀 수 있는 버튼을 가지고 있습니다.
//
//        빨강(R) → 초록(G)
//        초록(G) → 파랑(B)
//        파랑(B) → 빨강(R)
//        단, 전구를 벗어나게 구간을 정할 수는 없습니다. 당신은 버튼을 최소한으로 눌러 전구를 모두 빨간(R) 불빛으로 바꿔야 합니다.
//
//        예를 들어 n = 6, k = 3일 때, 전구에 불이 다음과 같이 들어와 있는 경우,
//
//        rgb_bulb_1.png
//
//        구간을 2번부터 4번 전구로 정해 버튼을 누르면 불빛이 아래와 같이 바뀝니다.
//
//        rgb_bulb_2.png
//
//        마찬가지로 구간을 4번부터 6번 전구로 정해 버튼을 누르면 불빛이 아래와 같이 바뀝니다.
//
//        rgb_bulb_3.png
//
//        마지막으로 구간을 3번부터 5번 전구로 정해 버튼을 누르면 불빛이 아래와 같이 바뀝니다. 따라서, 모든 전구를 빨간(R) 불빛으로 바꾸려면 버튼을 적어도 세 번 눌러야 합니다.
//
//        rgb_bule_4.png
//
//        전구의 개수 n, 불빛을 한꺼번에 바꿀 수 있는 연속된 전구 개수 k, 처음 전구의 상태 bulbs가 매개변수로 주어집니다. 모든 전구를 빨간 불빛으로 바꾸려면 버튼을 최소 몇 번 눌러야 하는지 return 하도록 solution 함수를 완성해주세요.
//
//        제한사항
//        n은 1 이상 200,000 이하인 자연수입니다.
//        k는 1 이상 n 이하인 자연수입니다.
//        bulbs는 전구의 상태를 나타내는 문자열로 길이는 n 입니다.
//        bulbs는 'R', 'G', 'B'로만 이루어져 있습니다.
//        R은 빨강, G는 초록, B는 파란 불빛의 전구를 나타냅니다.
//        만약 모든 전구를 빨간 불빛으로 바꿀 수 없다면 -1을 return 해주세요.
//        입출력 예
//        n	k	bulbs	result
//        6	3	"RBGRGB"	3
//        3	2	"BGG"	-1
//        4	2	"GBBG"	6
//        입출력 예 설명
//        입출력 예 #1
//
//        문제의 예시와 같습니다.
//
//        입출력 예 #2
//
//        버튼을 아무리 눌러도 모든 전구를 빨간 불빛으로 만들 수 없습니다.
//
//        입출력 예 #3
//
//        다음과 같이 6번 만에 모든 전구를 빨간 불빛으로 만들 수 있습니다.
//
//        GBBG → GRRG → GGGG → BBGG → BBBB → RRBB → RRRR

//4.
//        #include <string>
//#include <vector>
//#include <iostream>
//using namespace std;
//        char ch(char x, int cnt){
//        string p = "RGB";
//        int y = 0;
//        if (x == 'R') y = 0;
//        if (x == 'G') y = 1;
//        if (x == 'B') y = 2;
//        return p[(y + cnt) % 3];
//        }
//        int solution(int n, int k, string bulbs) {
//        vector<int> cnt(n + 1, 0);
//        int ans = 0;
//        for (int i=0;i<n;i++){
//        if (i > 0) cnt[i] += cnt[i-1];
//        bulbs[i] = ch(bulbs[i], cnt[i]);
//        if (bulbs[i] == 'R') continue;
//        else{
//        if (i >= n - k + 1) return -1;
//        int click = 0;
//        if (bulbs[i] == 'B') click = 1;
//        else click = 2;
//        cnt[i] += click;
//        cnt[i + k] -= click;
//        ans += click;
//        }
//        }
//        return ans;
//        }
