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
            [����]
                ������ [CONSTANT] �ڷ���(ũ��) [:= ��];
*/

-- ��±�� Ȱ��ȭ
SET SERVEROUTPUT ON;

DECLARE
    EID NUMBER;
    ENAME VARCHAR2(30);
    PI CONSTANT NUMBER := 3.14;
BEGIN
    EID := 888;
    ENAME := '���峲';
--    PI := 3.15; -- ���� �߻�
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('PI : ' || PI);
END;
/

/*
        2) ���۷��� Ÿ�� ���� ���� �� �ʱ�ȭ
            [ǥ����]
                ������ ���̺��.�÷���%TYPE;
            
            - �ش��ϴ� ���̺��� �÷��� ������ Ÿ���� �����ؼ� �� Ÿ������ ������ �����Ѵ�.
*/

DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
BEGIN
    -- ������� �Է¹޾Ƽ� ����� ���, �����, �޿������� ���� EID, ENAME, SAL ������ ���� �� ����Ѵ�.
    SELECT EMP_ID, EMP_NAME, SALARY
    INTO EID, ENAME, SAL
    FROM EMPLOYEE
    WHERE EMP_NAME = '&�����';
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('SAL : ' || SAL);
END;
/

------------------- �ǽ� ���� -------------------
-- ���۷��� Ÿ�� ������ EID, ENAME, JCODE, DTITLE, SAL�� �����ϰ� 
-- �� �ڷ����� EMPLOYEE ���̺��� EMP_ID, EMP_NAME, JOB_CODE, SALARY �÷��� Ÿ�԰�
-- DEPARTMENT ���̺��� DEPT_TITLE �÷��� Ÿ���� �����Ѵ�.
-- ����ڰ� �Է��� ����� ��ġ�ϴ� ����� ��ȸ(���, �����, ���� �ڵ�, �μ���, �޿�)�� �� ��ȸ ����� �� ������ ���� �� ����Ѵ�.
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    JCODE EMPLOYEE.JOB_CODE%TYPE;
    DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
BEGIN
    SELECT E.EMP_ID, 
           E.EMP_NAME, 
           E.JOB_CODE, 
           D.DEPT_TITLE, 
           E.SALARY
    INTO EID, ENAME, JCODE, DTITLE, SAL
    FROM EMPLOYEE E
    JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
    WHERE E.EMP_ID = '&���';
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('JCODE : ' || JCODE);
    DBMS_OUTPUT.PUT_LINE('DTITLE : ' || DTITLE);
    DBMS_OUTPUT.PUT_LINE('SAL : ' || SAL);
END;
/

/*
        3) ROW Ÿ�� ���� ���� �� �ʱ�ȭ
            [ǥ����]
                ������ ���̺��%ROWTYPE;
                
            - �ϳ��� ���̺��� ���� �÷��� ���� �Ѳ����� ������ �� �ִ� ������ �ǹ��Ѵ�.
            - ��� �÷��� ��ȸ�ϴ� ��쿡 ����ϱ� ���ϴ�.
*/
DECLARE
    EMP EMPLOYEE%ROWTYPE;
BEGIN
    SELECT *
    INTO EMP
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || EMP.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || EMP.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('�ֹι�ȣ : ' || EMP.EMP_NO);
    DBMS_OUTPUT.PUT_LINE('�̸��� : ' || EMP.EMAIL);
    DBMS_OUTPUT.PUT_LINE('��ȭ��ȣ : ' || EMP.PHONE);
    DBMS_OUTPUT.PUT_LINE('�μ� �ڵ� : ' || EMP.DEPT_CODE);
    DBMS_OUTPUT.PUT_LINE('���� �ڵ� : ' || EMP.JOB_CODE);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || TO_CHAR(EMP.SALARY, 'FM99,999,999'));
END;
/

---------------------------------------
/*
    <PL/SQL �����(EXECUTABLE SECTION)>
        1) ���ù�
          1-1) ���� IF ����
            [����]
                IF ���ǽ� THEN
                    ���� ����
                END IF;
*/
-- ����� �Է¹��� �� �ش� ����� ���, �̸�, �޿�, ���ʽ��� ���
-- ��, ���ʽ��� ���� �ʴ� ����� ���ʽ� ��� ���� '���ʽ��� ���޹��� �ʴ� ����Դϴ�.'��� ������ ����Ѵ�.
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, BONUS
    INTO EID, ENAME, SAL, BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || EID);
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || SAL);
    
    IF (BONUS IS NULL) THEN
         DBMS_OUTPUT.PUT_LINE('���ʽ��� ���޹��� �ʴ� ����Դϴ�.');
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('���ʽ� : ' || NVL(BONUS, 0));
END;
/
/*
        1-2) IF ~ ELSE ����
          [����]
            IF ���ǽ� THEN
                ���� ����
            ELSE 
                ���� ����
            END IF;
*/
-- ���� PL/SQL���� IF ~ ELSE �������� �����Ͽ� �ۼ�
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, BONUS
    INTO EID, ENAME, SAL, BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || EID);
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || SAL);
    
    IF (BONUS IS NULL) THEN
         DBMS_OUTPUT.PUT_LINE('���ʽ��� ���޹��� �ʴ� ����Դϴ�.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('���ʽ� : ' || NVL(BONUS, 0));
    END IF;
END;
/
/*
        1-3) IF ~ ELSIF ~ ELSE ����
          [����]
            IF ���ǽ� THEN
                ���� ����
            ELSIF ���ǽ� THEN
                ���� ����
            ...
            [ELSE
                ���� ����]
            END IF;
*/
-- ����ڿ��� ������ �Է¹޾� SCORE ������ ������ �� ������ �Էµ� ������ ���� GRADE ������ �����Ѵ�.
--  90�� �̻��� 'A'
--  80�� �̻��� 'B'
--  70�� �̻��� 'C'
--  60�� �̻��� 'D'
--  60�� �̸��� 'F'
-- ����� '����� ������ 95���̰�, ������ A�����Դϴ�.'�� ���� ����Ѵ�.
DECLARE
    SCORE NUMBER;
    GRADE CHAR(1);
BEGIN
    SCORE := '&����';
    
    IF (SCORE >= 90) THEN
        GRADE := 'A';
    ELSIF (SCORE >= 80) THEN
        GRADE := 'B';
    ELSIF (SCORE >= 70) THEN
        GRADE := 'C';
    ELSIF (SCORE >= 60) THEN
        GRADE := 'D';
    ELSE
        GRADE := 'F';
    END IF;    
    
    DBMS_OUTPUT.PUT_LINE('����� ������ ' || SCORE || '���̰�, ������ ' || GRADE  ||'�����Դϴ�.');
END;
/

/*
        1-4) CASE ����
          [����]
            CASE �� ���
                 WHEN �񱳰�1 THEN �����1
                 WHEN �񱳰�2 THEN �����2
                 ...
                 [ELSE �����]
            END;
*/
-- ����� �Է¹��� �Ŀ� ����� ��� �÷� �����͸� EMP�� �����ϰ� DEPT_CODE�� ���� �˸´� �μ��� ����Ѵ�.
DECLARE
    EMP EMPLOYEE%ROWTYPE;
    DNAME VARCHAR(30);
BEGIN
    SELECT * 
    INTO EMP
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    DNAME := CASE EMP.DEPT_CODE
                  WHEN 'D1' THEN '�λ������'
                  WHEN 'D2' THEN 'ȸ�������'
                  WHEN 'D3' THEN '�����ú�'
                  WHEN 'D4' THEN '����������'
                  WHEN 'D5' THEN '�ؿܿ���1��'
                  WHEN 'D6' THEN '�ؿܿ���2��'
                  WHEN 'D7' THEN '�ؿܿ���3��'
                  WHEN 'D8' THEN '���������'
                  WHEN 'D9' THEN '�ѹ���'
             END CASE;
             
    DBMS_OUTPUT.PUT_LINE('��� : ' || EMP.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || EMP.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('�μ� �ڵ� : ' || EMP.DEPT_CODE);
    DBMS_OUTPUT.PUT_LINE('�μ��� : ' || DNAME);
END;
/

/*
        2) �ݺ���
          2-1) BASIC LOOP
            [����]
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

-- ������(2 ~ 9��) ���

/*
        3) FOR LOOP
          [����]
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

-- �ݺ���(FOR ����)�� �̿��� ������ ����
CREATE TABLE TEST (
    NUM NUMBER,
    CREATE_DATE DATE
);

SELECT * FROM TEST;
ROLLBACK;

-- TEST ���̺� 10���� ���� INSERT�ϴ� PL/SQL �ۼ�
BEGIN
    FOR NUM IN 1..10
    LOOP
        INSERT INTO TEST VALUES(NUM, SYSDATE);
        
        IF (MOD(NUM, 2) = 0) THEN
            COMMIT;
        ELSE
            ROLLBACK;
        END IF;    
    END LOOP;
END;
/

------------------------------------------
/*
    <PL/SQL ����ó����(EXCEPTION SECTION)>
        ���ܶ� ���� �� �߻��ϴ� ������ ���ϰ� PL/SQL ������ �߻��� ���ܸ� ����ó���ο��� �ڵ�� ó���� �����ϴ�.

        [����]
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
-- ����ڰ� �Է��� ���� ������ ����
DECLARE
    RESULT NUMBER;
BEGIN
    RESULT := 10 / '&����';
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || RESULT);
EXCEPTION
    WHEN ZERO_DIVIDE THEN DBMS_OUTPUT.PUT_LINE('������ ����� 0���� ���� �� �����ϴ�.');
END;
/

-- �ʹ� ���� ���� ��ȸ�� �Ǿ��� ��
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
BEGIN  
    SELECT EMP_ID, EMP_NAME
    INTO EID, ENAME
    FROM EMPLOYEE
    WHERE MANAGER_ID = '&�����ȣ';

    DBMS_OUTPUT.PUT_LINE('��� : ' || EID);
    DBMS_OUTPUT.PUT_LINE('����� : ' || ENAME);
EXCEPTION
    WHEN TOO_MANY_ROWS THEN DBMS_OUTPUT.PUT_LINE('�ʹ� ���� ���� ��ȸ�Ǿ����ϴ�.');
    WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.PUT_LINE('��ȸ ����� �����ϴ�.');
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('������ �߻��߽��ϴ�.');
END;
/

SELECT *
FROM EMPLOYEE
WHERE MANAGER_ID = 201;