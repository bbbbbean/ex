-- 성능 분석 코드
-- 트레이스 파일 식별자 설정 : 저장 파일명에 해당 식별자가 추가되어 저장
ALTER SESSION SET tracefile_identifier = '_TEST2_';

-- 추적 시작
ALTER SESSION SET sql_trace = TRUE;

-- 어떤 레벨의 오류 추적 할건지
-- 레벨별로 추적의 범위가 다름 12는 가장 높은 레벨 : 바인드 변수 + 대기 이벤트
ALTER SESSION SET EVENTS '10046 trace name context forever, level 12';

-- 아래 코드 처리 결과 확인 예정
select * from usertbl where userid='lsg';

-- 추적 중단, 끝
ALTER SESSION SET sql_trace = FALSE;

-- 파일 확인
-- 트레이스 파일 경로 확인 쿼리
-- 이게 있어야 `C:\ORACLEXE\APP\ORACLE\diag\rdbms\xe\xe\trace\xe_ora_3276__TEST2_.trc` 이런 경로가 보임
SELECT VALUE FROM v$diag_info;