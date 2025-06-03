# session-basic

## 문제 링크

https://dreamhack.io/wargame/challenges/409

## 문제 설명

쿠키와 세션으로 인증 상태를 관리하는 간단한 로그인 서비스이다. admin으로 로그인에 성공하면 플래그를 얻을 수 있다.

## 풀이 과정

1. `users = { 'guest': 'guest', 'user': 'user1234' }` 와 `pw = users[username]` 를 보고 guest의 비밀번호는 guest가 아닐지 로그인 해봄, 성공.
   user의 비밀번호 또한 user1234인 것을 알 수 있었음.
2. admin의 비밀번호도 admin일지 시도해보았지만 실패.

3. 
```
 @app.route('/admin')
def admin():
    # developer's note: review below commented code and uncomment it (TODO)

    # session_id = request.cookies.get('sessionid', None)
    # username = session_storage[session_id]
    # if username != 'admin':
    #     return render_template('index.html') 

    return session_storage
```
   
에서 /admin이 session_storage를 return 함을 알 수 있었음.

3. /admin에 접근하여 세션값을 알아내기 성공함.
4. guest로 로그인한 후, 관리자 메뉴를 열어 session_id의 세션값을 admin의 세션값으로 바꿔줌, 로그인 성공.

## 배운 점

'/admin'처럼 파이썬 코드 안에 숨겨둔 트릭이 있어 코드를 잘 읽어야 함을 느낌.
쿠키 세션값만 바꿔주면 직접 로그인 하지 않고도 쉽게 계정을 탈취할 수 있음을 알게 됨.



