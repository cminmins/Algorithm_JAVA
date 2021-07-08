//class Solution {
//    Map<String, Integer> addressMap;
//    public String solution(String S, String C) {
//        StringBuilder answer = new StringBuilder();
//        addressMap = new HashMap<>();
//        C = "@" + C.toLowerCase() + ".com";
//        String[] names = S.split("\\; ");
//
//        for (int idx = 0; idx < names.length; idx++) {
//            String[] separatedName = names[idx].split(" ");
//            StringBuilder sb = new StringBuilder();
//            sb.append(separatedName[0].toLowerCase()).append(".");
//
//            String lastName = separatedName.length == 3 ?
//                    separatedName[2].toLowerCase() : separatedName[1].toLowerCase();
//            lastName = lastName.replace("-", "");
//
//            if(lastName.length() >= 8) {
//                sb.append(lastName.substring(0, 8));
//            } else {
//                sb.append(lastName);
//            }
//
//            String address = sb.toString();
//            if (!addressMap.containsKey(address)) {
//                addressMap.put(address, 1);
//                answer.append(address).append(C);
//            } else {
//                int num = addressMap.get(address) + 1;
//                addressMap.put(address, num);
//                answer.append(address).append(num).append(C);
//            }
//
//            if(idx != names.length - 1) {
//                answer.append("; ");
//            }
//        }
//
//        return answer.toString();
//    }
//}