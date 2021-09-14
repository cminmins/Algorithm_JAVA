//package kakako_2021;
//
//import java.util.Map;
//import java.util.TreeMap;
//
//public class Main3 {
//
//    static int calculateSecond(String time) {
//        String[] stamps = time.split(":");
//        return Integer.parseInt(stamps[0]) * 60 + Integer.parseInt(stamps[1]);
//    }
//
//    static int calculateFee(double time, int[] fees) {
//        int totalFee = 0;
//        if (time - fees[0] > 0) {
//            // 기본요금 계산
//            totalFee += fees[1];
//            // 남는 시간 시간당 계산해서 추가
//            totalFee += Math.ceil((time - fees[0]) / fees[2]) * fees[3];
//        } else {
//            // 기본 시간보다 적게 주차했으면 기본 요금만 추가
//            totalFee = fees[1];
//        }
//        return totalFee;
//    }
//
//    public static int[] solution(int[] fees, String[] records) {
//
//        Map<String, Integer> result = new TreeMap<>();
//        Map<String, Integer> parking = new TreeMap<>();
//
//        for (int i = 0; i < records.length; i++) {
//            String[] carInfo = records[i].split(" ");
//            // 주차장에 들어간 시간 계산
//            if (carInfo[2].equals("IN")) {
//                parking.put(carInfo[1], calculateSecond(carInfo[0]));
//            } else if (carInfo[2].equals("OUT")) {
//                //주차장에서 나간 시간 - 들어왔던 시간
//                int parkingTime = calculateSecond(carInfo[0]) - parking.get(carInfo[1]);
//                parking.remove(carInfo[1]);
//                result.put(carInfo[1], result.getOrDefault(carInfo[1], 0) + parkingTime);
//            }
//        }
//
//        for (String remain : parking.keySet()) {
//            int parkingTime = calculateSecond("23:59") - parking.get(remain);
//            parking.remove(remain);
//            result.put(remain, result.getOrDefault(remain, 0) + parkingTime);
//        }
//
//        int[] answer = new int[result.size()];
//        int index = 0;
//        for (String car : result.keySet()) {
//            double totalParkingTime = result.get(car);
//            answer[index] = calculateFee(totalParkingTime, fees);
//            index++;
//        }
//        return answer;
//    }
//
//
//
//    public static void main(String[] args) {
////        int[] fees = {180, 5000, 10, 600};
////        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
//
////        int[] fees = {120, 0, 60, 591};
////        String[] records = {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
//
//        int[] fees = {1, 461, 1, 10};
//        String[] records = {"00:00 1234 IN"};
//
//
//        int[] result = solution(fees, records);
//        return;
//    }
//}
