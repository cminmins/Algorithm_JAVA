package 롯데e커머스2022;

public class Main1 {
    int[] cnt = new int[1000000];

    void pro() {
        int m = 10000;
        for (int i = 1; i <= m; i++) {
            int x = 10; // 원래는 입력받는값
            int ans = 0;
            for (int digit = 1; digit <= 1000000; digit *= 10) {
                // x에서 digit 자리수보다 위에 값 + 자리수보다 작은값 == digit 자리값을 0으로 만들려는 작업
                int digit_zero = x / (digit * 10) * (digit * 10) + x % (digit * 10);
                for (int k = 0; k <= 9; k++) {
                    int new_x = digit_zero + k * digit;
                    if (x == new_x) {
                        continue;
                    }
                    ans += cnt[new_x];
                }
            }
        }
    }




}


//1.
//        import sys
//        from collections import defaultdict
//        si = sys.stdin.readline
//        A = set(map(int, si().split()))
//        B = set(map(int, si().split()))
//        C = set(map(int, si().split()))
//        res = A & B & C
//        if not res:
//        print(-1)
//        else:
//        print(max(res))