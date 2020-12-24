String 클래스
=====================================================


- 특징
----------------------------------------------------
1. 한번 선언 후 변경이 안됨.
  수정되는 것처럼 보이는건 새로운 객체를 생성해서 변경한 string으로 입력되서 그런거
  
  
  **Method**
  -----------------------------------------------
      
   -자주쓰는거
   
      .length()
          String의 길이를 리턴
          ex) abcd -> 4
          
  .equals(String)
      
      ex) A.equals(B) -> A와 B가 동일한 지 비교
      String의 경우에는 primitive type처럼 '=='를 통해서 비교가 되지 않는다.
        ==를 할 경우에는 주소값을 비교하는 걸로암
        
  .indexOf(value)
      
      해당 값이 들어있는 index를 리턴해줌
      
  .lastindexOf(value)
      
      해당 값이 들어있는 마지막 index를 리턴해줌
      
  .charAt(index)
    
      해당 index에 위치한 문자를 return해줌, char형으로
      char test = str.charAt(index);
  
  .toCharArray()
  
      String을 char[] 배열로 전환하여 반환한다.
      String str = "Hello world";
      char[] new_str = str.toCharArray();
      split은 string을 반환하는거랑 차이가 있음.
  
 .split(String a)
 
    a를 기준으로 string을 나눌 수 있음 배열로 return함
    ```java
    String[] stlist = str.split(" ");
    
  
  .valueOf(개체)
  
      오브젝트의 값을 String으로 변환 할때 사용
      **.toString(개체)** 와 비슷한 기능, 차이점은 null 처리 방법
      valueOf()는 null이면 null을 리턴하지만, tostring은 nullexception을 발생
      "null"을 구분하기 위해선
      ```java
      if("null".equals(String 개체))
      ```
      이렇게 해서 null인지 확인하는 방법이 있다.
      
      ex) String str = "asdasd";
          String.valueOf(str);
          str.toString();
      
 .compareTo(String)
 
    a.compareTo(b)을 하면 두개의 string을 앞에서 순차적으로 비교 (a - b)
    비교하는 문자가 > 0이면 양수를 리턴 / 같으면 0 / < 0 이면 음수를 리턴
    문자가 짧으면 짧은게 더 앞으로옴 ex) abc, abcded -> abc, abcded
    
 .contains(string)

    str1.contains(str2)하면 str1에 str2이 있는지 확인 후 포함하면 true, 없으면 false를 리턴
    
 .contact(string)
 
    String newstr = str1.contact(str2); 하면 str1+str2한 string이 만들어짐
    
  
 
 .substring(시작, 끝+1)
 
    index [시작] ~ [끝]까지 잘라서 return 함
 
 .replace(String a, String b)
 
    a 문자열이 있으면 b로 바꿔줌

.toUpperCase()
.toLowerCase()

    문자열을 대문자, 소문자로 변경해줌 
    
 .format(표현식, 문자열?)
 
    String.format(3, integer);
    를 하면 integer을 3진법으로 표시    
 .trim()
 
    문자열의 공백을 제거해줌
    
 .startWith(string)
 .endWith(string)
 
    시작하는, 끝나는 문자가 지정한 문자로 시작하면 true 아니면 false
  
