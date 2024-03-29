package Ebay;

import java.util.ArrayList;

public class Main2 {

    static ArrayList<String> ans = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static boolean checking(int[] stones, int k) {
        boolean isOK = false;
        int zeroCnt = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] == 0) {
                zeroCnt++;
            } else if (stones[i] == k) {
                isOK = true;
            }
        }
        return isOK & zeroCnt == stones.length - 1;
    }

    static boolean isValid(int[] stones, int k, int index) {
        for (int i = 0; i < stones.length; i++) {
            if (i == index) {
                continue;
            }
            if (stones[i] == 0) {
                return false;
            }
        }
        return true;
    }

    static void calc(int[] stones, int k, int index, int op) {
        for (int i = 0; i < stones.length; i++) {
            if (i == index) {
                stones[i] += op;
            } else {
                stones[i] -= op;
            }
        }
        return;
    }

    public static void search(int[] stones, int k) {
        if (ans.size() > 0) {
            return;
        }
        if (checking(stones, k)) {
            ans.add(sb.toString());
            return;
        }

        for (int i = stones.length - 1; i >= 0; i--) {
            if (isValid(stones, k, i)) {
                calc(stones, k, i, 1);
                sb.append(i);
                search(stones, k);
                calc(stones, k, i, -1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return;
    }


    public static String solution(int[] stones, int k) {
        int sum =0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        if ((stones.length > 2) && (sum - k) % (stones.length - 2) != 0) {
            return "-1";
        }
        if (sum < k) {
            return "-1";
        }
        search(stones, k);
        if (ans.size() > 0) {
            return ans.get(0);
        } else {
            return "-1";
        }
    }

    public static void main(String[] args) {
//        int[] stones = {1, 3, 2};
//        int k = 3;
//        int[] stones = {4, 2, 2, 1, 4};
//        int k = 1;
        int[] stones = {5, 7, 2, 4, 9};
        int k = 20;
        System.out.println(solution(stones, k));
        return;
    }
}


//프로그래밍
//        다시 풀 문제
//        문제 설명
//        돌무더기 게임은 여러 돌무더기에서 돌을 하나씩 추가하거나 제거하여, 하나의 돌무더기만 남기는 게임입니다. 게임에서 승리하기 위해서는 마지막에 남은 하나의 돌무더기의 돌 수가 정확히 k개가 되어야 합니다.
//
//        처음 주어지는 돌무더기들은 각각 1개 이상의 돌을 갖고 있습니다. 당신은 한 돌무더기를 골라 다음과 같은 행동을 할 수 있습니다.
//
//        선택한 돌무더기에 돌을 1개 추가합니다. 동시에, 선택되지 않은 나머지 돌무더기에서 각각 1개씩 돌을 제거합니다.
//        돌을 제거해야 할 나머지 돌무더기 중에서 제거할 돌이 없는 경우(=돌 수가 0인 경우), 위 행동은 실행할 수 없습니다.
//        예를 들어 3개의 돌무더기에 돌이 각각 [1, 3, 2]개 있고 k가 3인 경우, 게임에서 승리하는 가장 빠른 방법은 아래와 같이 2가지가 있습니다.
//
//        첫 번째 - 세 번째 - 세 번째 돌무더기를 차례대로 선택합니다. 각 선택 시에 돌무더기의 돌 수는 [2, 2, 1] - [1, 1, 2] - [0, 0, 3]과 같이 변합니다.
//        세 번째 - 첫 번째 - 세 번째 돌무더기를 차례대로 선택합니다. 각 선택 시에 돌무더기의 돌 수는 [0, 2, 3] - [1, 1, 2] - [0, 0, 3]과 같이 변합니다.
//        선택하는 돌무더기의 인덱스를 순서대로 나열하여 문자열로 변환하면 1번 방법은 "022", 2번 방법은 "202"입니다. 이를 사전 순으로 정렬했을 때, 가장 뒤에 오는 방법은 "202"입니다.
//
//        각 돌무더기의 돌 수를 나타내는 정수 배열 stones, 남겨야 하는 한 돌무더기의 돌 수를 나타내는 정수 k가 매개변수로 주어집니다. 게임에서 승리하기 위한 가장 빠른 방법 중에서, 선택하는 돌무더기의 인덱스를 문자열로 변환했을 때 사전 순으로 가장 뒤에 오는 방법을 return 하도록 solution 함수를 완성해주세요. 만약 어떤 방법으로도 목표를 달성할 수 없다면 "-1"을 return 해주세요.
//
//        제한사항
//        2 ≤ stones의 길이 ≤ 8
//        1 ≤ stones의 원소 ≤ 12
//        1 ≤ k ≤ 24
//        돌 수가 0인 돌무더기도 선택할 수 있는 돌무더기입니다.
//        입출력 예
//        stones	k	result
//        [1, 3, 2]	3	"202"
//        [4, 2, 2, 1, 4]	1	"3213"
//        [5, 7, 2, 4, 9]	20	"-1"
//        입출력 예 설명
//        입출력 예 #1
//
//        문제 예시와 같습니다.
//
//        입출력 예 #2
//
//        네 번째 - 세 번째 - 두 번째 - 네 번째 순으로 돌무더기를 선택하면 아래 표와 같이 돌 수가 변합니다.
//
//        선택한 돌무더기의 인덱스	stones
//        -	[4, 2, 2, 1, 4]
//        3	[3, 1, 1, 2, 3]
//        2	[2, 0, 2, 1, 2]
//        1	[1, 1, 1, 0, 1]
//        3	[0, 0, 0, 1, 0]
//        따라서 "3213"을 return 합니다.
//
//        입출력 예 #3
//
//        어떤 방법으로도 마지막에 남길 한 돌무더기를 20으로 만들 수 없습니다. 따라서 "-1"을 return 합니다.

//2.
//        #include <string>
//#include <vector>
//#include <unordered_set>
//#include <queue>
//using namespace std;
//        typedef long long int ll;
//        unordered_set<ll> mem;
//        inline ll conv(vector<int> &stones){
//        ll res = 0;
//        for (int x: stones) res = res * 25 + x;
//        return res;
//        }
//        string dfs(vector<int> stones, int k, string path) {
//        mem.insert(conv(stones));
//        // 종료 조건 (k개 남은 돌무더기 하나만 있는가?)
//        int cnt_k = 0, cnt_zero = 0;
//        for (int x: stones) {
//        if (x == k) cnt_k++;
//        if (x == 0) cnt_zero++;
//        }
//        if (cnt_zero == stones.size() - 1 && cnt_k == 1) return path;
//        // 완전 탐색
//        // 처음 찾은 방법이 사전 순으로 마지막임을 보장하기 위해 역순 탐색
//        for (int i = stones.size() - 1; i >= 0; i--) {
//        bool flag = true;
//        stones[i] += 2;
//        for (int &x: stones){
//        x--;
//        if (x < 0) flag = false;
//        }
//        if (flag && mem.find(conv(stones)) == mem.end()) {
//        string res = dfs(stones, k, path + (char)(i + '0'));
//        if (res != "-1") return res;
//        }
//        stones[i] -= 2;
//        for (int &x: stones){
//        x++;
//        }
//        }
//        return "-1";
//        }
//        string solution(vector<int> stones, int k) {
//        int sum = 0, n = stones.size();
//        for (int x: stones) sum += x;
//        if (n > 2 && (sum - k) % (n - 2) != 0) return "-1";
//        if (sum < k) return "-1";
//        return dfs(stones, k, "");
//        }
