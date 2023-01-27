-- �Լ�
/*
    <�Լ�>
        �÷����� �о ��� ����� ��ȯ�Ѵ�.
          - ������ �Լ� : N���� ���� �о N���� ����� �����Ѵ�. (�� �� �Լ� ���� -> ��� ��ȯ)
          - �׷� �Լ�   : N���� ���� �о 1���� ����� �����Ѵ�. (�ϳ��� �׷캰�� �Լ� ���� -> ��� ��ȯ)
        SELECT ���� ������ �Լ��� �׷� �Լ��� �Բ� ������� ���Ѵ�. (��� ���� ������ �ٸ��� ������)
        �Լ��� ����� �� �ִ� ��ġ�� SELECT, WHERE, ORDER BY, GROUP BY, HAVING ���� ����� �� �ִ�.
*/

--------------------- ������ �Լ� ---------------------

/*
    <���� ���� �Լ�>
    1) LENGTH / LENGTHB
      - LENGTH(�÷�|'���ڰ�') : ���� �� ��ȯ
      - LENGTHB(�÷�|'���ڰ�') : ������ ����Ʈ �� ��ȯ
        �ѱ� �� ���� -> 3BYTE
        ������, ����, Ư������ �� ���� -> 1BYTE
        
    * DUAL ���̺�
      - SYS ����ڰ� �����ϴ� ���̺�
      - SYS ����ڰ� ���������� ��� ����ڰ� ������ �����ϴ�.
      - �� ��, �� �÷��� ������ �ִ� ����(DUMMY) ���̺��̴�.
      - ����ڰ� �Լ�(���)�� ����� �� �ӽ÷� ����ϴ� ���̺��̴�.
*/

/*
    2) INSTR
        - INSTR(�÷�|'���ڰ�', '����'[, POSITION[, OCCURRENCE]])
        - ������ ��ġ���� ������ ���� ��°�� ��Ÿ���� ������ ���� ��ġ�� ��ȯ�Ѵ�.
*/

SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL; -- 3��° �ڸ��� B�� ��ġ�� ���
SELECT INSTR('AABAACAABBAA', 'B', 4) FROM DUAL; -- 3��° �ڸ��� B�� ��ġ�� ���
SELECT INSTR('AABAACAABBAA', 'B', 1, 2) FROM DUAL; -- 9��° �ڸ��� B�� ��ġ�� ���
SELECT INSTR('AABAACAABBAA', 'B', -1) FROM DUAL; -- 10��° �ڸ��� B�� ��ġ�� ���
SELECT INSTR('AABAACAABBAA', 'B', -1, 3) FROM DUAL; -- 3��° �ڸ��� B�� ��ġ�� ���

/* 
    3) LPAD / RPAD
        - LPAD/RPAD(�÷�|'���ڰ�', ����(����Ʈ)[, '�����̷��� �ϴ� ����'])
        - ���õ� �÷�|'���ڰ�'�� ������ ���ڸ� ���� �Ǵ� �����ʿ� ���ٿ� ���� N ���� ��ŭ�� ���ڿ��� ��ȯ�Ѵ�.
        - ���ڿ� ���� ���ϰ� �ְ� ǥ���ϰ��� �� �� ����Ѵ�.
*/

/*
    4) LTRIM / RTRIM
        - LTRIM/RTRIM(�÷�|'���ڰ�'[, '�����ϰ��� �ϴ� ����'])
        - ���ڿ��� ���� Ȥ�� �����ʿ��� �����ϰ��� �ϴ� ���ڵ��� ã�Ƽ� ������ ����� ��ȯ�Ѵ�.
        - �����ϰ��� �ϴ� ���ڰ��� ���� �� �⺻������ ������ �����Ѵ�.
*/

/*
    5) TRIM
        - TRIM([[LEADING|TRAILING|BOTH] '�����ϰ��� �ϴ� ���ڰ�' FROM] �÷�|'���ڰ�')
        - ���ڰ� ��/��/���ʿ� �ִ� ������ ���ڸ� ������ �������� ��ȯ�Ѵ�. 
        - �����ϰ��� �ϴ� ���ڰ��� ���� �� �⺻������ ���ʿ� �ִ� ������ �����Ѵ�. 
*/

/*
    6) SUBSTR
        - SUBSTR(�÷�|'���ڰ�', POSITION[, LENGTH])
        - ���ڵ����Ϳ��� ������ ��ġ���� ������ ������ŭ�� ���ڿ��� �����ؼ� ��ȯ�Ѵ�.
*/

/*
    7) LOWER / UPPER / INITCAP
        - LOWER/UPPER/INITCAP(�÷�|'���ڰ�')
          LOWER : ��� �ҹ��ڷ� �����Ѵ�.
          UPPER : ��� �빮�ڷ� �����Ѵ�.
          INITCAP : �ܾ� �� ���ڸ��� �빮�ڷ� �����Ѵ�.
*/

SELECT LOWER('Welcome To My World!') FROM DUAL;
SELECT UPPER('Welcome To My World!') FROM DUAL;
SELECT INITCAP('welcome to my world!') FROM DUAL;

/*
    8) CONCAT
        - CONCAT(�÷�|'���ڰ�', �÷�|'���ڰ�')
        - ���ڵ����� �� ���� ���޹޾Ƽ� �ϳ��� ��ģ �� ����� ��ȯ�Ѵ�.
*/

/*
    9) REPLACE
      - REPLACE(�÷�|'���ڰ�', �����Ϸ��� �ϴ� ����, �����ϰ��� �ϴ� ����)
      - �÷� �Ǵ� ���ڰ����� "�����Ϸ��� �ϴ� ����"�� "�����ϰ��� �ϴ� ����"�� �����ؼ� ��ȯ�Ѵ�.
*/

-------------------------------------------------
/*
    <���� ���� �Լ�>
    
    1) ABS
        - ABS(NUBER)
        - ���밪�� ���ϴ� �Լ�
*/

/*
    2) MOD
        - MOD(NUMBER, NUMBER)
        - �� ���� ���� �������� ��ȯ�� �ִ� �Լ� (�ڹ��� % ����� �����ϴ�.)
*/

/*
    3) ROUND
        - ROUND(NUMBER[, ��ġ])
        - ��ġ�� �����Ͽ� �ݿø����ִ� �Լ�
        - ��ġ : �⺻�� 0(.), ���(�Ҽ��� �������� ������)�� ����(�Ҽ��� �������� ����)�� �Է°���
*/
SELECT ROUND(123.456) FROM DUAL;
SELECT ROUND(123.456, 1) FROM DUAL;
SELECT ROUND(123.456, 4) FROM DUAL;
SELECT ROUND(123.456, -1) FROM DUAL;
SELECT ROUND(123.456, -2) FROM DUAL;
SELECT ROUND(123.456, -3) FROM DUAL;
SELECT ROUND(723.456, -3) FROM DUAL;

/*
    4) CEIL
        - CEIL(NUMBER)
        - �Ҽ��� �������� �ø����ִ� �Լ�
*/

/*
    5) FLOOR
        - FLOOR(NUMBER)
        - �Ҽ��� �������� �����ϴ� �Լ�
*/
SELECT FLOOR(123.456) FROM DUAL;
SELECT FLOOR(123.789) FROM DUAL;

/*
    6) TRUNC
        - TRUNC(NUMBER[, ��ġ])
        - ��ġ�� �����Ͽ� ������ ������ �Լ�
        - ��ġ : �⺻�� 0(.), ���(�Ҽ��� �������� ������)�� ����(�Ҽ��� �������� ����)�� �Է°���
*/

SELECT TRUNC(123.456) FROM DUAL;
SELECT TRUNC(123.456, 1) FROM DUAL;
SELECT TRUNC(123.456, -1) FROM DUAL;

----------------------------------------------------
/*
    <��¥ ���� �Լ�>
    
    1) SYSDATE
        �ý����� ���� ��¥�� �ð��� ��ȯ�Ѵ�.
*/
SELECT SYSDATE FROM DUAL;

/* 
    2) MONTHS_BETWEEN
        [ǥ����]
            MONTHS_BETWEEN(DATE1, DATE2)
            
        - �Է¹��� �� ��¥ ������ ���� ���� ��ȯ�Ѵ�.
        - ������� NUMBER Ÿ���̴�.
*/

/*
    3) ADD_MONTHS
        [ǥ����]
            ADD_MONTHS(DATE, NUMBER)
            
        - Ư�� ��¥�� �Է¹޴� ���ڸ�ŭ�� ���� ���� ���� ��¥�� �����Ѵ�.
        - ������� DATE Ÿ���̴�.
*/

/*
    4) NEXT_DAY
        [ǥ����]
            NEXT_DAY(DATE, ����(����|����))
        
        - Ư�� ��¥���� ���Ϸ��� ������ ���� ����� ��¥�� �����Ѵ�.
        - ������� DATE Ÿ���̴�.
*/

SELECT SYSDATE, NEXT_DAY(SYSDATE, '�����') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'ȭ') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 1) FROM DUAL;-- 1:�Ͽ���, 2:������, ..., 7:�����
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'SUNDAY') FROM DUAL; -- ����(���� �� KOREAN�̱� ������)

ALTER SESSION SET NLS_LANGUAGE = AMERICAN; -- ��� ����
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'SUNDAY') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'MON') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 6) FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '��') FROM DUAL; -- ���� �߻�
SELECT SYSDATE, NEXT_DAY(SYSDATE, '�����') FROM DUAL; -- ���� �߻�

ALTER SESSION SET NLS_LANGUAGE = KOREAN; -- ��� ���� (�ٽ� �������)


/*
    5) LAST_DAY
        [ǥ����]
            LAST_DAY(DATE)
        
        - �ش� ���� ������ ��¥�� ��ȯ�Ѵ�.
        - ������� DATE Ÿ���̴�.   
*/

/*
    6) EXTRACT
        [ǥ����]
            EXTRACT(YEAR|MONTH|DAY FROM DATE);
            
        - Ư�� ��¥���� ����, ��, �� ������ �����ؼ� ��ȯ�Ѵ�.
          YEAR : ������ ����
          MONTH : ���� ����
          DAY :  �ϸ� ����
        - ������� NUMBER Ÿ���̴�.
*/

-- ��¥���亯��
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH:MI:SS';
SELECT SYSDATE FROM DUAL;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
SELECT SYSDATE FROM DUAL;

-----------------------------------------------------------------------
/*
    <����ȯ �Լ�>
    
    1) TO_CHAR
        [ǥ����]
            TO_CHAR(��¥|����[, ����])
        
        - ��¥ �Ǵ� ���� Ÿ���� �����͸� ���� Ÿ������ ��ȯ�ؼ� ��ȯ�Ѵ�.
        - ������� CHARACTER Ÿ���̴�.
*/

-- ���� --> ����
SELECT TO_CHAR(1234) FROM DUAL;
SELECT TO_CHAR(1234, '999999') FROM DUAL; -- 6ĭ�� ������ Ȯ��, ������ ����, ��ĭ�� �������� ä���.
SELECT TO_CHAR(1234, '000000') FROM DUAL; -- 6ĭ�� ������ Ȯ��, ������ ����, ��ĭ�� 0���� ä���.
SELECT TO_CHAR(1234, 'L999999') FROM DUAL; -- ���� ������ ����(LOCAL)�� ȭ�����
SELECT TO_CHAR(1234, '$999999') FROM DUAL;
SELECT TO_CHAR(1234, 'L') FROM DUAL;
SELECT TO_CHAR(1234, 'L999,999') FROM DUAL; -- �ڸ��� ���� �޸�

-- ��¥ --> ����
SELECT SYSDATE FROM DUAL;
SELECT TO_CHAR(SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'AM HH:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'PM HH24:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'MON DY, YYYY') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD(DY)') FROM DUAL;


-- ������ ���� ����
-- ������ ���õ� ���� ���ڴ� 'Y', 'R'�� �ִ�.
SELECT TO_CHAR(SYSDATE, 'YYYY'),
       TO_CHAR(SYSDATE, 'RRRR'),
       TO_CHAR(SYSDATE, 'YY'),
       TO_CHAR(SYSDATE, 'RR'),
       TO_CHAR(SYSDATE, 'YEAR')
FROM DUAL;

-- ���� ���� ����
SELECT TO_CHAR(SYSDATE, 'MM'),
       TO_CHAR(SYSDATE, 'MON'),
       TO_CHAR(SYSDATE, 'MONTH'),
       TO_CHAR(SYSDATE, 'RM') -- �θ� ��ȣ
FROM DUAL;

-- �Ͽ� ���� ����
SELECT TO_CHAR(SYSDATE, 'DDD'), -- 1���� �������� ��ĥ°
       TO_CHAR(SYSDATE, 'DD'),  -- 1���� �������� ��ĥ°
       TO_CHAR(SYSDATE, 'D')    -- 1�ָ� �������� ��ĥ°
FROM DUAL;

-- ���Ͽ� ���� ����
SELECT TO_CHAR(SYSDATE, 'DAY'),
       TO_CHAR(SYSDATE, 'DY')
FROM DUAL;


/*
    2) TO_DATE
        [ǥ����]
            TO_DATE(����|����[, ����])
        
        - ���� �Ǵ� ������ �����͸� ��¥ Ÿ������ ��ȯ�ؼ� ��ȯ�Ѵ�.
        - ������� DATE Ÿ���̴�.
*/

-- ���� --> ��¥
SELECT TO_DATE(20211014) FROM DUAL;
SELECT TO_DATE(20211014190830) FROM DUAL;

-- ���� --> ��¥
SELECT TO_DATE('20211014') FROM DUAL;
SELECT TO_DATE('20211014 190830') FROM DUAL;
SELECT TO_DATE('20211014', 'YYYYMMDD') FROM DUAL;

-- YY�� RR ��
SELECT TO_DATE('110923', 'YYMMDD') FROM DUAL;
SELECT TO_DATE('990923', 'YYMMDD') FROM DUAL; -- YY : ������ ���� ����

SELECT TO_DATE('110923', 'RRMMDD') FROM DUAL;
SELECT TO_DATE('990923', 'RRMMDD') FROM DUAL; -- RR : �ش� ���� 50 �̻��̸� ���� ����, 50 �̸��̸� ���� ���� 


/*
    3) TO_NUMBER
        [ǥ����]
            TO_NUMBER('���ڰ�'[, ����])
        
        - ���� Ÿ���� �����͸� ���� Ÿ���� �����ͷ� ��ȯ�ؼ� ��ȯ�Ѵ�.
        - ������� NUMBER Ÿ���̴�.
*/

SELECT TO_NUMBER('0123456789') FROM DUAL;
SELECT '123' + '456' FROM DUAL; -- �ڵ����� ���� Ÿ������ ����ȯ �� ����ó���� ���ش�.
SELECT '123' + '456A' FROM DUAL; -- ���� �߻�(���� ������ ���ڵ鸸 �ڵ�����ȯ �ȴ�.)
SELECT '10,000,000' + '500,000' FROM DUAL; -- ���� �߻�
SELECT TO_NUMBER('10,000,000', '99,999,999') + TO_NUMBER('500,000', '999,999') FROM DUAL;


/*
    <NULL ó�� �Լ�>
    
    1) NVL
        [ǥ����]
            NVL(�÷�, �÷����� NULL�� ��� ��ȯ�� ��)
        
        - NULL�� �Ǿ��ִ� �÷��� ���� ���ڷ� ������ ������ �����Ͽ� ��ȯ�Ѵ�.

    2) NVL2
        [ǥ����]
            NVL2(�÷�, ������ �� 1, ������ �� 2)
            
        - �÷� ���� NULL�� �ƴϸ� ������ �� 1, �÷� ���� NULL�̸� ������ �� 2�� �����Ͽ� ��ȯ�Ѵ�.  
    
    3) NULLIF
        [ǥ����]
            NULLIF(�񱳴�� 1, �񱳴�� 2)
            
        - �� ���� ���� �����ϸ� NULL ��ȯ, �� ���� ���� �������� ������ �񱳴�� 1�� ��ȯ�Ѵ�.
*/


/*
    <�����Լ�>
        ���� ���� ��쿡 ������ �� �� �ִ� ����� �����ϴ� �Լ��̴�.
    
    1) DECODE
        [ǥ����]
            DECODE(�÷�|����, ���ǰ� 1, ����� 1, ���ǰ� 2, ����� 2, ..., �����)
        
        - ���ϰ��� �ϴ� ���� ���ǰ��� ��ġ�� ��� �׿� �ش��ϴ� ������� ��ȯ�� �ִ� �Լ��̴�.
*/

/*
    2) CASE
        [ǥ����]
            CASE WHEN ���ǽ� 1 THEN ����� 1
                 WHEN ���ǽ� 2 THEN ����� 2
                 ...
                 ELSE ����� N
            END
*/

/*
    <�׷� �Լ�>
        �뷮�� �����͵�� ���質 ��� ���� �۾��� ó���ؾ� �ϴ� ��� ���Ǵ� �Լ����̴�.
        ��� �׷� �Լ��� NULL ���� �ڵ����� �����ϰ� ���� �ִ� �͵鸸 ����� �Ѵ�.
        ���� AVG �Լ��� ����� ���� �ݵ�� NVL() �Լ��� �Բ� ����ϴ� ���� �����Ѵ�.
        
        1) SUM
            [ǥ����]
                SUM(NUMBER)
                
            - �ش� �÷� ������ �� �հ踦 ��ȯ�Ѵ�.
*/

/*
        2) AVG
            [ǥ����]
                AVG(NUMBER)
            
            - �ش� �÷� ������ ����� ���ؼ� ��ȯ�Ѵ�.
*/

/*
        3) MIN / MAX
            [ǥ����]
                MIN/MAX(��� Ÿ�� �÷�)
            
            - MIN : �ش� �÷� ���� �߿� ���� ���� ���� ��ȯ�Ѵ�.
            - MAX : �ش� �÷� ���� �߿� ���� ū ���� ��ȯ�Ѵ�.
*/

/*
        4) COUNT
            [ǥ����]
                COUNT(*|�÷���|DISTINCT �÷���)
            
            - �÷� �Ǵ� ���� ������ ���� ��ȯ�ϴ� �Լ��̴�.
            - COUNT(*) : ��ȸ ����� �ش��ϴ� ��� ���� ������ ��ȯ�Ѵ�.
            - COUNT(�÷���) : ������ �÷� ���� NULL�� �ƴ� ���� ������ ��ȯ�Ѵ�.
            - COUNT(DISTINCT �÷���) �ش� �÷� ���� �ߺ��� ������ ���� ������ ��ȯ�Ѵ�. 
*/










