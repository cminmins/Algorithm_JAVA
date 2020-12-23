Stack, Queue
====================================


##Stack
--------------------
    
- 내용 

    LIFO 구조의 클래스, 후입선출
    List 콜렉션 클래스의 Vector 클래스를 상속받아 만들어진 클래스
    
- 선언
    
    Stack<String> st = new Stack<String>();
   
- 메소드

    - st.push(E e)
        
        가장 위쪽에 해당 값을 추가
      
    - st.pop()
    
        가장 위의 값을 리턴하고 삭제
      
    - st.peek()
        
        가장 위의 값만 리턴
        
    - st.empty()
    
        해당 stack이 비어있으면 true, 비어 있지 않으면 false를 ㅣ턴
        
    - st.search(Object o) 
    
        해당 스택에서 해당 object가 존재하는지 확인, 가장 위에서부터 1~n으로 시작하고 존재하면 index를 리턴, 없으면 -1 리턴
        

Queue
-------------------------------

- 내용

    FIFO 선입선출 구조, ex) 프린트 풀
    Stack이랑은 다르게 별도의 인터페이스 형태로 제공됨
    보통은 LinkedList 클래스로 Queue를 구현하는데 가장 많이 이용함
    
- 선언
    
    Queue<Integer> q = new LinkedList<Integer>();
    
- 메소드

    - 실패할 경우 Exception이 발생하는 함수
        - .add(E e)
            맨 뒤에 추가함
        - .remove()
            맨 앞에 있는 요소를 삭제
        - .element()
            맨 앞에 있는 요소를 리턴함
    
    - null을 리턴하는 함수
        - .offet(E e)
            맨 뒤에 추가함
        - .poll()
            맨 앞에 있는 요소를 삭제
        - .peek()
            맨 앞에 있는 요소를 리턴함
        poll과 peek은 큐가 비어있을 경우 null을 반환하고, offer은 실패할 경우 false를 반환함     
       
    
