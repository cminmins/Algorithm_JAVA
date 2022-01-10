package 롯데e커머스2022;

public class Main2 {

    // 아래 1~3을 존재하는 모든 높이 h에 대해서 실행
        // 1. 침수되는 위치 찾기
        // 배열에 존재하는 값을 기준으로 탐색
        // 탐색하면서 그 높이보다 <= h 이면 침수되는 위치로 판단함
        // 침수되면 visit 배열에 1로 표기

        // 2. 땅 덩어리 개수 세기
        // 단지 세기 방법
        // 위에서 1이 되지않은 0인 애들에 단지번호를 붙이면됨

        // 3. 정답 여부 확인하기


}


//2.
//        #include <iostream>
//#include <string>
//#include <vector>
//#include <algorithm>
//#define NM 35
//        using namespace std;
//        int a[NM][NM];
//        int N, M;
//        void Input() {
    //        cin >> N >> M;
    //        for (int i = 1; i <= N; i++) {
    //          for (int j = 1; j <= M; j++) {
    //              cin >> a[i][j];
    //          }
    //        }
//        }
//        int dir[4][2] = { {1,0},{0,1},{-1,0},{0,-1} };
//        void Pro() {
    //        int ans = 0;
    //        for (int i = 1; i <= N; i++) {
        //        for (int j = 1; j <= M; j++) {
        //        if (a[i][j] == 0) continue;  // 바다면 무시
        //        for (int k = 0; k < 4; k++) {
            //        int ni = i + dir[k][0];
            //        int nj = j + dir[k][1];
            //        if (a[ni][nj] == 0) {  // 인접한 게 바다라면
            //        ans++;
    //                  }
//                  }
//                  }
//              }
    //        cout << ans;
//        }
//        int main() {
//        ios::sync_with_stdio(false);
//        cin.tie(NULL);
//        Input();
//        Pro();
//        return 0;
//        }
