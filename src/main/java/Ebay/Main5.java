package Ebay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5 {

    public String[] solution(String []P) {
        String[] answer = new String[2];
        return answer;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());



        return;
    }
}

//    문제 설명
//    팰린드롬(Palindrome)이란 앞에서부터 읽으나 뒤에서부터 읽으나 같은 단어를 말합니다. 예를 들어, "abba"나 "a"와 같은 단어는 팰린드롬이고, "abcda"나 "dc"와 같은 단어는 팰린드롬이 아닙니다.
//
//        문자열로 표현된 숫자(ex."131")가 N개 들어있는 배열 P가 주어질 때, 다음 규칙에 따라 배열 원소들을 제거하려고 합니다.
//
//        배열에서 임의의 두 수 A, B를 뽑습니다.
//        두 수 A, B를 AB 또는 BA로 이어붙였을 때 팰린드롬이 된다면 A, B를 배열에서 제거할 수 있습니다. 예를 들어, "21"과 "123"을 뽑았을 때, "21123"은 팰린드롬이 아니지만 "12321"은 팰린드롬이므로 두 개의 수는 배열에서 제거할 수 있습니다.
//        만약 서로 붙여서 만들어진 숫자가 팰린드롬 숫자가 아니면 배열에서 제거할 수 없습니다.
//        이와 같은 방식을 반복하여, 배열의 모든 원소를 제거해야 합니다.
//        예를 들어 N=4, P = ["11","111","11","211"] 가 주어졌을 때,
//
//        [case 1]
//
//        처음에, 첫 번째 원소인 "11"과 두 번째 원소인 "111"을 뽑습니다.
//        서로 붙어서 만들어진 숫자 "11111"은 팰린드롬이므로 두 개의 수는 배열에서 제거할 수 있습니다.
//        배열에 남아 있는 세 번째 원소인 "11"과 네 번째 원소인 "211"을 뽑습니다.
//        서로 붙어서 만들어진 숫자 "11211"은 팰린드롬이므로 두 개의 수는 배열에서 제거할 수 있습니다.
//        배열의 모든 원소를 제거했습니다.
//        [case 2]
//
//        처음에, 첫 번째 원소인 "11"과 세 번째 원소인 "11"을 뽑습니다.
//        서로 붙어서 만들어진 숫자 "1111"은 팰린드롬이므로 두 개의 수는 배열에서 제거할 수 있습니다.
//        배열에 남아 있는 두 번째 원소인 "111"과 네 번째 원소인 "211"을 뽑습니다.
//        서로 붙어서 만들어진 숫자 "211111" 또는 "111211"은 팰린드롬이 아니므로 두 개의 수는 배열에서 제거할 수 없습니다.
//        배열의 모든 원소를 제거하지 못했습니다.
//        [case 3]
//
//        처음에, 첫 번째 원소인 "11"과 네 번째 원소인 "211"을 뽑습니다.
//        서로 붙어서 만들어진 숫자 "11211"은 팰린드롬이므로 두 개의 수는 배열에서 제거할 수 있습니다.
//        배열에 남아 있는 두 번째 원소인 "111"과 세 번째 원소인 "11"을 뽑습니다.
//        서로 붙어서 만들어진 숫자 "11111"은 팰린드롬이므로 두 개의 수는 배열에서 제거할 수 있습니다.
//        배열의 모든 원소를 제거했습니다.
//        즉 case1, 3의 두 가지 방식으로 배열의 모든 원소를 제거할 수 있습니다.
//
//        우리는 배열에 있는 모든 원소를 제거하기 위해 첫 번째 원소를 몇 번째 원소와 연결해야 하는지 알고 싶습니다. 위의 예시의 경우, 두 번째 원소인 "111"과 연결했을 때(case1)와 네 번째 원소인 "211"을 연결했을 때(case3)입니다.
//
//        배열 P가 매개변수로 주어질 때, 배열에 있는 모든 원소를 제거하기 위해 첫 번째 원소를 어느 조각과 연결 해야 하는지 모든 가능한 경우를 찾고, 그 경우에 첫 번째 원소와 연결되는 원소들을 return 하도록 solution 함수를 완성해 주세요. 위의 예시의 경우는 ["111","211"]을 return 하면 됩니다. return 할 때는 배열에 주어진 순서대로 return 해주세요.
//
//        제한사항
//        N : 40 이하의 자연수이며, 문제 규칙상 항상 짝수만 주어집니다.
//        P의 각 원소 : 자연수가 string형으로 주어지며, 각 문자열의 길이는 1 이상 40 이하입니다. 단, 숫자는 0으로 시작하지 않습니다. (ex. "011")
//        P의 각 원소를 모두 제거할 수 있는 경우만 주어집니다.
//        입출력 예
//        P	answer
//        ["11","111","11","211"]	["111","211"]
//        ["21","123","111","11"]	["123"]
//        입출력 예 설명
//        입출력 예 #1
//        위의 예시와 같습니다.
//
//        입출력 예 #2
//
//        첫 번째 원소인 "21"과 두 번째 원소인 "123"을 뽑아 연결하면 "12321"이 되고, 이 숫자는 팰린드롬이므로 배열에서 제거합니다. 배열에 남은 세 번째 원소와 네 번째 원소를 뽑아 연결하면 "11111"이 되고, 이 숫자는 팰린드롬이므로 배열에서 제거합니다. 배열의 모든 원소를 제거했으므로 두 번째 원소인 "123"은 첫 번째 원소와 연결했을 때 배열의 모든 원소를 제거할 수 있습니다.
//
//        첫 번째 원소인 "21"과 세 번째 원소인 "111"을 뽑아 연결하면 "21111" 또는 "11121"이 되고, 이 숫자는 팰린드롬이 아닙니다. 즉, 첫 번째 원소와 세 번째 원소와 연결했을 때는 배열의 모든 원소를 제거할 수 없습니다.
//
//        첫 번째 원소인 "21"과 네 번째 원소인 "11"을 뽑아 연결하면 "2111" 또는 "1121"이 되고, 이 숫자는 팰린드롬이 아닙니다. 즉, 첫 번째 원소와 네 번째 원소와 연결했을 때는 배열의 모든 원소를 제거할 수 없습니다.
//
//        최종적으로 두 번째 원소가 속한 ["123"] 을 return 합니다.

//5.
//        #include<iostream>
//#include<vector>
//#include<string>
//using namespace std;
//        int target, match[50];
//        int a[50][50], n;
//        int path[50], visit[50];
//        int dfs(int x, int idx) {
//        if (visit[x]) return 0;
//        path[idx] = x;
//        visit[x] = 1;
//        if (match[x] == -1 && idx % 2 == 0) {
//        for (int i = 1; i <= idx; i += 2) {
//        match[path[i]] = path[i + 1];
//        match[path[i + 1]] = path[i];
//        }
//        return 1;
//        }
//        else if (idx % 2 == 0) {
//        return dfs(match[x], idx + 1);
//        }
//        else {
//        int flag = 0;
//        for (int j = 1; j < n; j++) {
//        if (j == target) continue;
//        //if (visit[j][(idx+1)%2]) continue;
//        if (a[x][j] == 0) continue;
//        if (dfs(j, idx + 1) == 1) return 1;
//        }
//        return 0;
//        }
//        }
//        vector<string> solution(vector<string> P)
//        {
//        n = P.size();
//        vector<string> answer;
//        for (int i = 0; i < n; i++) {
//        for (int j = 0; j < n; j++) {
//        if (i == j) continue;
//        string x = P[i] + P[j];
//        int flag = 0;
//        for (int k = 0; k < x.length(); k++) {
//        if (x[k] != x[x.length() - 1 - k]) flag = 1;
//        }
//        if (flag == 0) a[i][j] = a[j][i] = 1;
//        }
//        }
//        for (int i = 1; i < n; i++) {
//        for (int j = 0; j < n; j++) match[j] = -1;
//        if (a[0][i] == 0) continue;
//        target = i;
//        match[target] = 0;
//        match[0] = target;
//        int cnt = 0;
//        for (int j = 1; j < n; j++) {
//        if (match[j] != -1) continue;
//        for (int k = 0; k < n; k++) visit[k] = 0;
//        cnt += dfs(j, 1);
//        }
//        if (cnt * 2 == n - 2){
//        answer.push_back(P[i]);
//        }
//        }
//        return answer;
//        }
