#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include<utility>
#include<string>
#include <cmath>

using namespace std;

//string text[20] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
//string solution(int left, int right, int offset){
//    string answer = "";
//
//    while(answer.size() < right+1) {
//        string temp = to_string(offset++);
//        int len = temp.size();
//        for (int i = 0; i < len; i++) {
//            if (temp[i] == '1' && (i < len - 1) && (i + 1 < len)) {
//                answer = answer + text[(temp[i] - '0') * 10 + (temp[i + 1] - '0')];
//                i++;
//            } else {
//                answer += text[temp[i] - '0'];
//            }
//        }
//    }
//
//    answer = answer.substr(left-1, right-left+1);
//    return answer;
//}


/* 2번
 bool 써서 (는 그냥 push
{ 일때는 소괄호 bool이 false인지 보고 push
[ 일때는 소괄호, 중괄호 bool이 false보고 push
top이 (면서 넣는게 )이면 pop
 { } 이면 pop
 [] 이면 pop
*/
vector<int> solution(vector<string> pars){
    vector<int> answer;
    for(int i=0; i<pars.size(); i++){
        string temp = pars[i];
        stack<char> s;
        for(int k=0; k<temp.size(); k++){
            if(temp[k] == '(' || temp[k] == '{' || temp[k] == '['){
                s.push(temp[k]);
            }
            else{
                s.pop();
            }
        }
        if(s.empty()){
            answer.push_back(1);
        }
        else{
            answer.push_back(0);
        }
    }
    return answer;
}

int main(){
    std::ios::sync_with_stdio(false);
//    cout << solution(11, 20, 210) << endl;
//    cout << solution(16, 30, 5108) << endl;

    cout << solution()
    return 0;

}