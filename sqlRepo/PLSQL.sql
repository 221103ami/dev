/*
    <PL/SQL>
        ����Ŭ ��ü�� ����Ǿ� �ִ� ������ ���� SQL ���� ������ ������ ����, ���� ó��(IF), �ݺ� ó��(LOOP, FOR, WHILE) ���� �����Ѵ�.
        (�ټ��� SQL ���� �� ���� ������ �����ϴ�.)
        
        [PL/SQL�� ����]
            1) �����(DECLAER SECTION) : DECLARE�� ����, ������ ����� ���� �� �ʱ�ȭ�ϴ� �κ��̴�.
            2) �����(EXECUTABLE SECTION) : BEGIN�� ����, SQL ��, ���(����, �ݺ���) ���� ������ ����ϴ� �κ��̴�.
            3) ���� ó����(EXCEPTION SECTION) : EXCEPTION�� ����, ���� �߻� �� �ذ��ϱ� ���� ������ ����ϴ� �κ��̴�.
            
        
    <PL/SQL �����(DECLAER SECTION)>
        ���� �� ����� ������ ���� �����̴�.(����� ���ÿ� �ʱ�ȭ�� ����)
        ���� �� ����� �Ϲ� Ÿ�� ����, ���۷��� Ÿ�� ����, ROW Ÿ�� ������ �����ؼ� ����� �� �ִ�.
        
        1) �Ϲ� Ÿ�� ������ ���� �� �ʱ�ȭ
            [ǥ����]
                ������ [CONSTANT] �ڷ���(ũ��) [:= ��];
*/


/*
        2) ���۷��� Ÿ�� ���� ���� �� �ʱ�ȭ
            [ǥ����]
                ������ ���̺��.�÷���%TYPE;
            
            - �ش��ϴ� ���̺��� �÷��� ������ Ÿ���� �����ؼ� �� Ÿ������ ������ �����Ѵ�.
*/

/*
    <PL/SQL �����(EXECUTABLE SECTION)>
        1) ���ù�
          1-1) ���� IF ����
            [ǥ����]
                IF ���ǽ� THEN
                    ���� ����
                END IF;
*/

/*
        1-2) IF ~ ELSE ����
          [ǥ����]
            IF ���ǽ� THEN
                ���� ����
            ELSE 
                ���� ����
            END IF;
*/

/*
        1-3) IF ~ ELSIF ~ ELSE ����
          [ǥ����]
            IF ���ǽ� THEN
                ���� ����
            ELSIF ���ǽ� THEN
                ���� ����
            ...
            [ELSE
                ���� ����]
            END IF;
*/

/*
        1-4) CASE ����
          [ǥ����]
            CASE �� ���
                 WHEN �񱳰�1 THEN �����1
                 WHEN �񱳰�2 THEN �����2
                 ...
                 [ELSE �����]
            END;
*/

/*
        2) �ݺ���
          2-1) BASIC LOOP
            [ǥ����]
                LOOP
                    �ݺ������� �����ų ����
                    
                    [�ݺ����� �������� ���ǹ� �ۼ�]
                        1) IF ���ǽ� THEN 
                              EXIT;
                           END IF
                           
                        2) EXIT WHEN ���ǽ�;
                END LOOP;
*/

-- 1 ~ 5���� ���������� 1�� �����ϴ� ���� ���
DECLARE
    NUM NUMBER := 1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(NUM);
        
        NUM := NUM + 1;
        
--        IF NUM > 5 THEN
--            EXIT;
--        END IF;        
        EXIT WHEN NUM > 5;
    END LOOP;
END;
/

/*
        2-2) WHILE LOOP
          [ǥ����]
            WHILE ���ǽ�
            LOOP
                �ݺ������� ������ ����;
            END LOOP;
*/

-- 1 ~ 5���� ���������� 1�� �����ϴ� ���� ���
DECLARE
    NUM NUMBER := 1;
BEGIN
    WHILE NUM <= 5
    LOOP
        DBMS_OUTPUT.PUT_LINE(NUM);
        
        NUM := NUM + 1;
    END LOOP;
END;
/

/*
        3) FOR LOOP
          [ǥ����]
            FOR ���� IN [REVERSE] �ʱⰪ..������
            LOOP
                �ݺ������� ������ ����;
            END LOOP;
*/

-- 1 ~ 5���� ���������� 1�� �����ϴ� ���� ���
BEGIN
    FOR NUM IN 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(NUM);
    END LOOP;
END;
/

-- �������� ���
BEGIN
    FOR NUM IN REVERSE 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(NUM);
    END LOOP;
END;
/


-- ������(2 ~ 9��) ��� (��, ¦���ܸ� ����Ѵ�.)
BEGIN
    FOR DAN IN 2..9
    LOOP
        IF (MOD(DAN, 2) = 0) THEN
            FOR SU IN 1..9
            LOOP        
                DBMS_OUTPUT.PUT_LINE(DAN || ' X ' || SU || ' = ' || DAN * SU );
            END LOOP;
            
            DBMS_OUTPUT.PUT_LINE('');
        END IF;
    END LOOP;
END;
/


------------------------------------------
/*
    <PL/SQL ����ó����(EXCEPTION SECTION)>
        ���ܶ� ���� �� �߻��ϴ� ������ ���ϰ� PL/SQL ������ �߻��� ���ܸ� ����ó���ο��� �ڵ������� ó���� �����ϴ�.

        [ǥ����]
            DECLARE
                ...
            BEGIN
                ...
            EXCEPTION
                WHEN ���ܸ� 1 THEN ����ó������ 1;
                WHEN ���ܸ� 2 THEN ����ó������ 2;
                ...
                WHEN OTHERS THEN ����ó������;
                
        * ����Ŭ���� �̸� ���ǵǾ� �ִ� ����
          - NO_DATA_FOUND : SELECT ���� ���� ����� �� �൵ ���� ��쿡 �߻��Ѵ�.
          - TOO_MANY_ROWS : �� ���� ���ϵǾ�� �ϴµ� SELECT ������ ���� ���� ���� ������ �� �߻��Ѵ�. 
          - ZERO_DIVIDE   : ���ڸ� 0���� ���� �� �߻��Ѵ�.
          - DUP_VAL_ON_INDEX : UNIQUE ���� ������ ���� �÷��� �ߺ��� �����Ͱ� INSERT �� �� �߻��Ѵ�.
*/








