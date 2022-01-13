package 엔테크서비스2022;

public class Main4 {
}


//4.
//        import sys
//        from collections import defaultdict
//        si = sys.stdin.readline
//        N, M, K = map(int, si().split())
//        MOD = 1000000007
//        dy = [[[0 for _ in range(M + 1)] for __ in range(M + 1)] for ___ in range(N + 1)]
//        dy[0][0][0] = 1
//        for i in range(1, N + 1):
//        for s in range(1, M + 1):
//        if s > i * K:
//        break
//        for os in range(1, M + 1):
//        if os > s:
//        break
//        if i % 2 == 1:
//        for l in range(1, K + 1):
//        if s < l or os < l:
//        break
//        dy[i][s][os] += dy[i - 1][s - l][os - l]
//        dy[i][s][os] %= MOD
//        else:
//        for l in range(1, K + 1):
//        if s < l:
//        break
//        dy[i][s][os] += dy[i - 1][s - l][os]
//        dy[i][s][os] %= MOD
//        print(dy[N][M][M // 2])