# Algorithm_JAVA
Study Algorithm using Java language

1. 글자크기
  큰 제목 (===============)
  ===============
  
  작은 제목 (----------------)
  ----------------

  #앞에 샾 붙이기
  ## 2개 붙이면 더 작게, 6개까지 가능
  
  
2. 목록

  a. 순서있는 목록은 1. 2. 3. 이렇게
  b. 그냥 표시가 되는걸 원하면 *, -, + 
  
3. 영역
  - 띄어쓰기 4번 또는 탭 2번하면 해당 영역 블럭처리, 위아래로 한줄씩 띄어줘야 문제없음
  
  - 코드같은거 영역 처리할려면 <pre><code> </code></pre> 하거나 아니면 ``` ``` 찍기
  
  - 라인 긋기 
  * * *
  ***
  ******
  - - - 
  ------------------------------------
  
 4. 참조
    
    [Title](link)
    [Google](https://gist.github.com/ihoneymon/652be052a0727ad59601 "참조 사이트")


5. 글씨체
  기울기 (*, _)
  
  강조 (**, __)
 
  취소선 (~~)
  
  문장 중간에 사용할 경우 특수문자 양옆으로 띄어쓰기 해주는게 좋음
  
  
  
  
  
테스트 

    안녕하세요
 
끝


자바 자료형
Data Type
====================

1. Primitive Type

    * Boolean type 
      - Boolean
    * Numeric Type
      - Integer type (short, int, long)
      - Floating type (float, double)
    * charater type
      - char
    
2. Reference Type


ArrayList vs List
===========================

    - ArrayList는 클래스
    - List는 인터페이스
    ArrayList를 이용해서 List를 구현한 것
    ex) List<String> l = new ArrayList<String>();
    


Array vs ArrayList
=================================

- 차이점
---------------

    1. Array는 배열의 크기가 동적으로 변경안됨. 
    2. ArrayList는 특정 위치에 element를 추가, 삭제할 수 있음 (insert, add, remove)
    3. int[] 배열은 int만 저장이 가능한데 ArrayList는 다양한 객체 타입을 저장가능.
    4. Arrayiterator를 통해서 양방향 순회 가능
    
 
- ArrayList 메소드
 ----------------------
    
    1) .add(T);  가장 끝에 추가 
    2) .remove(T); 
    3) .size();
    4) 
    
    
- Array <-> ArrayList 변환
 ----------------------------
 
 - Array -> ArrayList
 
    1) int, float, char 같은 primitive 타입의 경우
       아래처럼 add를 이용해서 변환해야됨.
    ```
    int[] arr = {1,2,3};
    List<Integer> list = new ArrayList<>();
    for (int i : arr) {
         list.add(i);
    }
    ```

    2) String 같은 클래스를 변환할때
    ```   
    String [] arr = new String[] {"one", two", "three"};
    List<String> list = new ArrayList<>(Arrays.asList(arr));
    ```
    아래 2가지는 int일떄도 되는지는 안해봄
    3)  Collections.addAll(list, arr);
    4) list.addAll(Arrays.asList(array));

-ArrayList -> Array
    
    1)   
    List<String> list = new ArrayList<String>();
    String[] arr = new String[list.size()]; // arr에는 어떤 배열이 있음
    list.toArray(arr);
