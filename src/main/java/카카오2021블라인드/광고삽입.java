package 카카오2021블라인드;

public class 광고삽입 {

    static class Solution {

        int secToInt(String str) {
            String[] time = str.split(":");
            int timeInt = Integer.parseInt(time[0]) * 3600
                    + Integer.parseInt(time[1]) * 60
                    + Integer.parseInt(time[2]);
            return timeInt;
        }

        String intToSec(int time) {
            return String.format("%02d:%02d:%02d",
                    time / 3600,
                    (time / 60) % 60,
                    time % 60);
        }


        public String solution(String play_time, String adv_time, String[] logs) {
            int intPlay_time = secToInt(play_time);
            int intAdv_time = secToInt(adv_time);
            if (intPlay_time == intAdv_time) {
                return ("00:00:00");
            }

            long[] time = new long[360000];
            for (int i = 0; i < logs.length; i++) {
                String[] temp = logs[i].split("-");
                time[secToInt(temp[0])]++;
                time[secToInt(temp[1])]--;
            }

            // 해당 시간의 시청자수
            for (int i = 1; i <= intPlay_time; i++) {
                time[i] += time[i - 1];
            }
            // 해당 시간의 누적 방송시간
            for (int i = 1; i <= intPlay_time; i++) {
                time[i] += time[i - 1];
            }

            long maxTime = time[intAdv_time - 1];
            int index = 0;
            for (int i = 0; i <= intPlay_time - intAdv_time; i++) {
                long temp_time = time[i + intAdv_time] - time[i];
                if (maxTime < temp_time) {
                    maxTime = temp_time;
                    index = i + 1;
                }
            }
            return intToSec(index);
        }
    }


    public static void main(String[] args) {
        String play_tiem = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        Solution sol = new Solution();
        System.out.println(sol.solution(play_tiem, adv_time, logs));
    }
}
