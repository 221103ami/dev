/*
    <SEQUENCE>
        정수값을 순차적으로 생성하는 역할을 하는 객체이다.
        
    <SEQUENCE 생성>
        [표현법]
            CREATE SEQUNCE 시퀀스명
            [START WITH 숫자]
            [INCREAMENT BY 숫자]
            [MAXVALUE 숫자]
            [MINVALUE 숫자]
            [CYCLE | NOCYCLE]
            [CACHE 바이트크기 | NOCACHE]; (기본값 20 바이트)
            
        [사용 구문]
            시퀀스명.CURRVAL : 현재 시퀀스의 값
            시퀀스명.NEXTVAL : 시퀀스 값을 증가시키고 증가된 시퀀스 값
                              (기존 시퀀스 값에서 INCREAMENT 값 만큼 증가된 값)
                              
        * 캐시메모리
          - 미리 다음 값들을 생성해서 저장해둔다.
          - 매번 호출할 때마다 시퀀스 값을 새로 생성을 하는 것이 아닌 캐시 메모리 공간에 미리 생성된 값들을 사용한다.
*/

-- NEXTVAL를 한 번이라도 수행하지 않는 이상 CURRVAL을 가져올 수 없다.
-- CURRVAL는 마지막으로 수행된 NEXTVAL 값을 저장해서 보여주는 값이다.


/*
    <SEQUENCE 수정>
        [표현법]
            ALTER SEQUENCE 시퀀스명
            [INCREAMENT BY 숫자]
            [MAXVALUE 숫자]
            [MINVALUE 숫자]
            [CYCLE | NOCYCLE]
            [CACHE 바이트크기 | NOCACHE]; (기본값 20 바이트)
            
        - START WITH는 변경이 불가능하다. 즉, 재설정하고 싶다면 기존에 시퀀스를 삭제 후 재 생성해야 한다.
*/

/*
    <SEQUENCE 삭제>
        DROP SEQUENCE 시퀀스명;
*/


















