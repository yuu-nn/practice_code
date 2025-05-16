# simple_sql

## 문제 링크
https://dreamhack.io/wargame/challenges/24

## 문제 설명
SQL INJECTION 취약점을 통해 플래그를 획득하는 로그인 서비스이다.

## 풀이 과정
1. 파이썬 코드를 통해 (userid, userpassword)에 ("guest", "guest") 로 로그인이 됨을 알 수 있었고, ID가 admin인 계정에 로그인 하는게 최종 목표임을 알 수 있었다.
2. 'select * from users where userid="{userid}" and userpassword="{userpassword}"' 를 코드에서 확인할 수 있다. 이 코드를 id가 admin일때의 데이터가 보일 수 있도록 
admin";-- 
을 userid에 넣어준다.
이때 "로 id를 받고있으니 admin"로 닫고 ;로 문장을 마무리 해준다. --을 이용하여 뒤에오는 모든 문장을 주석처리 해준다.

## 배운점
간단한 SQL 취약점을 이용하는 방법을 알게 되었다. {userid}자리에 우리가 실제 기입하는 id 값이 들어가는 것을 이용하여, 데이터 베이스에 접근할 수 있음을 알게 되었다. 
