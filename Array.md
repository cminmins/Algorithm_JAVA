Array Class
=====================================

- 배열의 선언
  
    int[] s = new int[배열길이];
    
- 배열의 길이

    s.length
    
- 배열 접근

    s[1] -> 2
    
- 배열 초기화
    
    int[] s = new int[]{1,2,3,4,5};
    int[] s = {1, 2, 3, 4, 5};
   
    Arrays.fill(s, 0);
   
- 배열 복사

    - System class의 arraycopy()
        성능이 제일 좋음
        
        ```java
        int[] sunny1 = new int[]{1, 2, 3, 4, 5};
        int newLength = 10;
        int[] sunny2 = new int[newLength];
        System.arraycopy(sunny1, 0, sunny2, 0, sunny1.length);
        ```
        
    - Array class의 copyOf()
        가장 많이 쓰임
        ```java
        int[] sunny3 = Arrays.copyOf(sunny1, newLength);
        
      
    
- import.java.util.Arrays
========================================

  - .asList
      
      Array -> ArrayList로 변환할때 사용
      
      **int, float, char 같은 primitive type을 변환할때
      ```java
      int[] arr = {1,2,3};
      List<Integer> list = new ArrayList<>();
      for (int i : arr) {
      list.add(i);
      }
      ```
    
      String 같은 클래스를 변환할때
      
      ```java
      String [] arr = new String[] {"one", two", "three"};
      ArrayList<Stirng> ls = new ArrayList<>(Arrays.asList(arr));
      
      //List<String> list = Array.asList(arr);를 할 경우에는 list에서 set으로 수정하면 arr의 값도 같이 바뀜. 같은 주소값을 공유
      ```
   
   
- Arrays.binarySearch(Object[] a, Object key) (이진탐색으로 검색, 미리 정렬되어있어야함)
      
      ```java
      int index = Arrays.binarySearch(arr, 10); 
      ```
      
      arr에서 key값 10을 검색
      
- CopyOfRange(배열, 시작, 종료)

    int[] copy_arr = Arrays.CopyOfRange(arr, 0, 6);
    
- equals(object[] a, object[] b)

    Arrays.equals(a, b);
    
    전달받은 a, b 두 배열이 같은지 확인
    
- sort(object[] a)

    정렬
    
    역정렬
    Arrays.sort(arr,Collections.reverseOrder());
    
    일부 구간만 정렬
    Arrays.sort(arr, 0, 4); // 0,1,2,3 요소만 정렬
    
    Operator 정렬 (compareTo Override)
    int를 비교할 경우에는 int가 아니라 Integer를 사용해야함
    
    ```java
    Arrays.sort(arr, new Comparator<Integer>() {
    @Override
    public int compare(Integer i1, Integer i2) {
        return i2 - i1;
    }
    });
    ```
    
    객체를 정렬하는 방법도 있는데 이거는 나중에 공부 (TBD)
