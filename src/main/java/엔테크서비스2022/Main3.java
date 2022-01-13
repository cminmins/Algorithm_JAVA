package 엔테크서비스2022;

import java.util.HashMap;
import java.util.Map;

public class Main3 {
    class Solution {

        public boolean checkYear(int y){
            return (y % 400 == 0) || (y % 4 == 0) && (y % 100 != 0);
        }

        public int solution(String join_date, String resign_date, String[] holidays) {
            int answer = 0;

            String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
            int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            Map<String, Integer> dayMap = new HashMap<>();
            dayMap.put("MON", 0);
            dayMap.put("TUE", 1);
            dayMap.put("WED", 2);
            dayMap.put("THU", 3);
            dayMap.put("FRI", 4);
            dayMap.put("SAT", 5);
            dayMap.put("SUN", 6);

            String[] sd = join_date.substring(0, 10).split("/");
            String startDay = join_date.substring(11, 14);
            // System.out.println(startDay);
            String[] ed = resign_date.split("/");
            int[] startDate = {Integer.parseInt(sd[0]), Integer.parseInt(sd[1]), Integer.parseInt(sd[2])};
            int[] endDate = {Integer.parseInt(ed[0]), Integer.parseInt(ed[1]), Integer.parseInt(ed[2])};

            // for(int i=0; i<3; i++){
            //     System.out.println(startDate[i] + " " + endDate[i]);
            // }
            boolean checkM = false;
            boolean checkD = false;
            String today = "";
            for(int y=startDate[0]; y<=endDate[0]; y++){
                if(checkYear(y)){
                    month[2] = 29;
                } else{
                    month[2] = 28;
                }

                int lastmonth = 12;
                if(y == endDate[0]){
                    lastmonth = endDate[1];
                }
                for(int m =1; m<=lastmonth; m++){
                    if(y == startDate[0] && !checkM){
                        m = startDate[1];
                        checkM = true;
                    }
                    int lastday = month[m];
                    if(y == endDate[0] && m == endDate[1]){
                        lastday = endDate[2];
                    }
                    for(int d=1; d<=lastday; d++){
                        if(y == startDate[0] && !checkD){
                            d = startDate[2] + 1;
                            checkD = true;
                        }
                        // 시작날과 종료일이 같고, 주말일때 예외케이스
                        // today 변경을 선활용, 후변경하던가
                        // -1을 startDate[2]로 바꾸고?
                        // startDay 대신 today를 계속쓰고 d를 +1로 바꾸던가
                        today = days[((dayMap.get(startDay) - 1) + d) % 7];
                        // System.out.println(today);
                        if(!today.equals("SUN") && !today.equals("SAT")){
                            answer++;
                            // System.out.println(y + " : " + m + " : " + d + " / " + today);
                        }
                        for(int i=0; i<holidays.length; i++){
                            int hm = Integer.parseInt(holidays[i].substring(0,2));
                            if(hm == m){
                                int hd = Integer.parseInt(holidays[i].substring(3,5));
                                if(hd == d){
                                    if(!today.equals("SUN") && !today.equals("SAT")){
                                        answer--;
                                        // System.out.println("Holiday = " + y + " : " + m + " : " + d + " / " + today);
                                    }
                                }
                            }
                        }
                    }
                    startDay = days[(dayMap.get(today) + 1) % 7];
                }
            }
            return answer;
        }
    }
}

//3.
//        # 3
//        # 2019/12/01 SUN
//        # 2020/03/02
//        # 01/02
//        # 12/24
//        # 03/01
//        # 1
//        # 2019/12/01 SUN
//        # 2019/12/31
//        # 12/25
//        import sys
//        from collections import defaultdict
//        si = sys.stdin.readline
//        # 입력 + 파싱
//        #####################################################
//        N = int(si())
//        start, day = si().split()
//        end = si()
//        holidays = [tuple(map(int, si().split('/'))) for _ in range(N)]
//        day = {
//        'MON': 0,
//        'TUE': 1,
//        'WED': 2,
//        'THU': 3,
//        'FRI': 4,
//        'SAT': 5,
//        'SUN': 6,
//        }[day]
//        def parsing_YMD(date, day):
//        Y, M ,D = map(int, date.split('/'))
//        return (Y, M, D, day)
//        #####################################################
//        def is_workday(today):
//        Y, M, D, day = today
//        if day in [5, 6]:
//        return False
//        if (M, D) in holidays:
//        return False
//        return True
//        def is_leap_year(year):
//        if year % 400 == 0:
//        return True
//        if year % 100 == 0:
//        return False
//        return year % 4 == 0
//        days = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
//        def tomorrow(today):
//        Y, M, D, day = today
//        last_day = days[M]
//        if is_leap_year(Y) and M == 2:
//        last_day += 1
//        if D == last_day:
//        D = 1
//        M += 1
//        else:
//        D += 1
//        if M == 13:
//        M = 1
//        Y += 1
//        return (Y, M, D, (day + 1) % 7)
//        today = parsing_YMD(start, day)
//        ans = 0
//        while True:
//        if is_workday(today):
//        ans += 1
//        if today[:3] == parsing_YMD(end, -1)[:3]:
//        break
//        today = tomorrow(today)
//        print(ans)