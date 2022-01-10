package Ebay;

public class Main3 {
    public int solution(String[] grid) {
        int answer = 0;




        return answer;
    }
}
// 문제해설
//bottom side를 c+=2로 변경


//    문제 설명
//    모든 칸이 동일한 크기의 작은 정삼각형으로 이루어진 정삼각형 모양의 격자가 있습니다. 각 칸은 빨간색 또는 파란색으로 색칠되어 있으며, 당신은 이 격자에서 다음과 같은 규칙으로 움직입니다.
//
//        어떤 칸에 입장했을 때, 해당 칸의 색이 빨간색이라면 우회전을, 파란색이라면 좌회전을 해서 나갑니다.
//        다음 그림은 크기가 2인 격자가 색칠되어 있고, 격자에 입장했다가 퇴장하는 경로 6가지를 나타낸 것입니다.
//
//        example1.png
//
//        위 격자에서 가장 많은 칸을 거치는 경로는 3개의 칸을 거친다는 것을 알 수 있습니다.
//
//        삼각형 격자의 색깔 분포를 나타내는 문자열 배열 grid가 매개변수로 주어집니다. 주어진 격자에 입장했다가 퇴장하는 경로들 중에서, 가장 많은 칸을 거치는 경로를 찾아, 그 경로가 거치는 칸의 개수를 return 하도록 solution 함수를 완성해주세요. 이때, 한번 지나간 칸을 다시 한번 지나가는 것도 중복해서 세야 합니다.
//
//        제한사항
//        grid의 길이는 1 이상 200 이하입니다.
//        grid의 모든 문자열은 "R"과 "B"로 이루어져 있습니다.
//        R은 해당 칸이 빨간색, B는 해당 칸이 파란색 격자임을 나타냅니다.
//        grid의 i번째 문자열(0부터 시작)의 길이는 2 x i + 1 입니다.
//        이는 격자의 i번째 행의 색깔 분포를 나타냅니다.
//        i번째 행의 가장 왼쪽에 있는 작은 정삼각형 칸 부터 순서대로 색깔을 나타냅니다.
//        각 행의 짝수 번째(0번째 부터 시작하며, 0은 짝수로 가정) 문자는 정방향, 홀수 번째 문자는 역방향 작은 정삼각형의 색깔을 나타냅니다.
//        입출력 예
//        grid	result
//        ["B", "RRB"]	3
//        ["R", "BBB", "RBRBR"]	7
//        ["R", "RRR", "RBBBB", "BRRRBRR"]	15
//        입출력 예 설명
//        입출력 예 #1
//
//        본문의 예시와 같습니다.
//        입출력 예 #2
//
//        격자의 색깔 분포와 가장 많은 칸을 거치는 경로는 다음 그림과 같습니다.
//        example2.png
//        입출력 예 #3
//
//        격자의 색깔 분포와 가장 많은 칸을 거치는 경로는 다음 그림과 같습니다.
//        example3.png

//3-python.
//        def shift(grid):
//        n = len(grid)
//        res = []
//        for idx, row in enumerate(grid):
//        res.append([None for _ in range(n * 2 - 1)])
//        for i in range(n - idx - 1, n + idx):
//        res[idx][i] = row[i - (n - idx - 1)]
//        return res
//        def solution(grid):
//        def inRange(r, c):
//        nonlocal grid
//        n = len(grid)
//        if r < 0 or r >= n: return False
//        if c < n - r - 1 or c >= n + r: return False
//        return True
//        def traverse(r, c, port):
//        nonlocal con, conv, grid
//        res = 0
//        while inRange(r, c):
//        res += 1
//        port = conv[grid[r][c]][port]
//        r, c, port = con[r][c][port]
//        return res
//        # inside rule
//        conv = dict()
//        conv['R'] = [0 for _ in range(6)]
//        conv['B'] = [0 for _ in range(6)]
//        conv['R'][0], conv['R'][2], conv['R'][4] = 5, 1, 3
//        conv['B'][0], conv['B'][2], conv['B'][4] = 3, 5, 1
//        # connection
//        n = len(grid)
//        con = [[[(-1, -1, -1) for _ in range(6)] for _ in range(n * 2 - 1)] for _ in range(n)]
//        grid = shift(grid)
//        for r in range(n):
//        for c in range(n - r - 1, n + r):
//        if (r + c) % 2 == (n - 1) % 2:  # right triangle
//        con[r][c][1] = (r, c + 1, 4)
//        con[r][c][3] = (r + 1, c, 0)
//        con[r][c][5] = (r, c - 1, 2)
//        else:  # inverse triangle
//        con[r][c][1] = (r - 1, c, 2)
//        con[r][c][3] = (r, c + 1, 4)
//        con[r][c][5] = (r, c - 1, 0)
//        answer = 0
//        for r in range(n):
//        # left side
//        answer = max(answer, traverse(r, n - r - 1, 4))
//        # right side
//        answer = max(answer, traverse(r, n + r - 1, 0))
//        # bottom side
//        for c in range(0, n * 2 - 1, 2):
//        answer = max(answer, traverse(n - 1, c, 2))
//        return answer
//        3-cpp.
//        #include <string>
//#include <vector>
//using namespace std;
//        int n;
//        int conv[2][6];
//        vector<string> grid;
//        inline int coord(int r, int c) {
//        c -= (n - r - 1);
//        if (grid[r][c] == 'R') return 0;
//        return 1;
//        }
//        inline bool inRange(int r, int c) {
//        if (r < 0 || r >= n) return false;
//        if (c < n - r - 1 || c >= n + r) return false;
//        return true;
//        }
//        struct Z{
//        int r, c, port;
//        };
//        inline Z con(int r, int c, int port) {
//        if ((r + c) % 2 == (n - 1) % 2) {  // right triangle
//        if (port == 1) return {r, c + 1, 4};
//        if (port == 3) return {r + 1, c, 0};
//        if (port == 5) return {r, c - 1, 2};
//        }
//        else {  // inverse triangle
//        if (port == 1) return {r - 1, c, 2};
//        if (port == 3) return {r, c + 1, 4};
//        if (port == 5) return {r, c - 1, 0};
//        }
//        }
//        int traverse(int r, int c, int port) {
//        int ret = 0;
//        while (inRange(r, c)){
//        ret++;
//        int type = 0;
//        if (grid[r][c - (n - 1 - r)] == 'B') type = 1;
//        port = conv[type][port];
//        Z nxt = con(r, c, port);
//        r = nxt.r;
//        c = nxt.c;
//        port = nxt.port;
//        }
//        return ret;
//        }
//        int solution(vector<string> _grid) {
//        grid = _grid;
//        const int R = 0;
//        const int B = 1;
//        conv[R][0] = 5, conv[R][2] = 1, conv[R][4] = 3;
//        conv[B][0] = 3, conv[B][2] = 5, conv[B][4] = 1;
//        n = grid.size();
//        int ans = 0;
//        for (int r=0;r<n;r++){
//        ans = max(ans, traverse(r, n - r - 1, 4));
//        ans = max(ans, traverse(r, n + r - 1, 0));
//        }
//        for (int c=0;c<n*2-1;c+=2){
//        ans = max(ans, traverse(n - 1, c, 2));
//        }
//        return ans;
//        }
