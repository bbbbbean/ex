-- ���� �м� �ڵ�
-- Ʈ���̽� ���� �ĺ��� ���� : ���� ���ϸ� �ش� �ĺ��ڰ� �߰��Ǿ� ����
ALTER SESSION SET tracefile_identifier = '_TEST2_';

-- ���� ����
ALTER SESSION SET sql_trace = TRUE;

-- � ������ ���� ���� �Ұ���
-- �������� ������ ������ �ٸ� 12�� ���� ���� ���� : ���ε� ���� + ��� �̺�Ʈ
ALTER SESSION SET EVENTS '10046 trace name context forever, level 12';

-- �Ʒ� �ڵ� ó�� ��� Ȯ�� ����
select * from usertbl where userid='lsg';

-- ���� �ߴ�, ��
ALTER SESSION SET sql_trace = FALSE;

-- ���� Ȯ��
-- Ʈ���̽� ���� ��� Ȯ�� ����
-- �̰� �־�� `C:\ORACLEXE\APP\ORACLE\diag\rdbms\xe\xe\trace\xe_ora_3276__TEST2_.trc` �̷� ��ΰ� ����
SELECT VALUE FROM v$diag_info;