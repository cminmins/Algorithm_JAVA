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
          .charAt(index)
          .valueOf(개체)
              오브젝트의 값을 String으로 변환 할때 사용
              .toString(개체)와 비슷한 기능, 차이점은 null 처리 방법
              valueOf()는 null이면 null을 리턴하지만, tostring은 nullexception을 발생
              "null"을 구분하기 위해선
              ```java
              if("null".equals(String 개체))
              ```
              이렇게 해서 null인지 확인하는 방법이 있다.
