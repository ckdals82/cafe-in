

###  Cafe-in
##TeamProject
spring을 이용한 카페 추천사이트

<hr>

## ⚙ 기능

- 로그인,로그아웃 
- 신규카페등록,삭제(관리자)
- 카페 이름으로 검색, 필터로 원하는 카페 검색
- 게시판
- 카페 별점등록, 별점순으로 카페 나열
<hr>

## ⌨️ 기능 구현

로그인<br>
>로그인시 아이디와 비밀번호가 틀리면 alert창을<br>
<img width="1221" alt="스크린샷 2021-10-29 오후 2 29 33" src="https://user-images.githubusercontent.com/81973067/139380888-a3909789-eb7e-4468-8dcf-4717db4e0dba.png">

<img width="1221" alt="스크린샷 2021-10-29 오후 2 30 42" src="https://user-images.githubusercontent.com/81973067/139380944-fbea9d90-3cb1-4553-a8a5-2c901781d6fc.png">

clock.js (시계 기능)<br>
>시계 기능구현은 현재의 시간을 계속 가져와서 업데이트 하면 된다.<br>
>특정 클래스, 태그 html 돔으로 가져오기<br>
>getTime 시간 가져오기<br>
>setInterval 1000 밀리세컨(1초)에 한번씩 getTime 콜백 함수 실행(즉, 업데이트)<br>


todo.js (todolist 기능)<br>
>init 초기화 함수 (기본 화면 출력, submit 요청)<br>
>greeting과 다르게 따로 받고 표시하는 과정이 다른 시간에 있을 필요는 없으므로 같은 화면에 input과 출력을 모두 표시<br>
>출력은 ul 태그 안에 li를 넣어서 표현<br>
>할 일을 User한테 입력받은 후, 바로 화면에 띄워줍니다. 또한, Greeting과 같이 Local Storage에 저장해두어 User가 다시 들어왔을 때 이전의 todo list를 띄워줍니다.<br>
<br>

bg.js (배경화면 랜덤화)<br>
>초기화 init<br>
>img 개수 지정, dom으로 가져오기<br>
>getRandom 함수 (랜덤 숫자 뽑기 함수)<br>
>내장객체 Math 활용<br>
>random 0.0000000000 ~ 1.00000000000 사이의 숫자를 random하게 내보냄 (자리수는 정확하지 않음)<br>
>그래서 보통 해당 숫자를 만들기 위해서 floor버림 , ceil올림을 통해서 자리수를 만들고, *를 통해서 범위를 정함<br>
>내장객체 사용하여 랜덤한 숫자로 나오는 수를 파라미터를 넣어 이미지 출력하게됨.

