// 변수 (Variable)

/* 함수 스코프 */
// var
// - 재 선언 가능, 재 할당 가능
// - 호이스팅(Hoisting) 특성이 있음
var name = "현태"
function f1(){
  console.log(name)//undefined : 호이스팅 특성 때문
  var name = "현타이"
  console.log(name)//현타이
}
f1()//얘는 그 안에서 name을 출력함
console.log(name)//현태
                 //f1의 name은 그 안에서만 작용


/* 블록 레벨 스코프 */
// let
// - 재 선언 불가, 재 할당 가능
let num = 123
function f2(){
  console.log(num)//123
  num = 1234//let num =1234하면 에러 발생
}
f2()
console.log(num)//1234

// const
// - 재 선언 불가, 재 할당 불가
// - 대문자 SNAKE_CASE 사용
// - 선언시 값을 할당해줘야함
// - 상수로 사용
const n = 123
function f3(){
  console.log(n)//123
  // n = 1234 -> 에러발생(재할당 재선언 불가능)
}
f3()
console.log(n)//123

/* undefined */
// - 변수에 아무 값도 없어서 타입을 알 수 없는 경우
var a
console.log(a)//undefined


// $ _ 로 시작해도 괜찮다
// 대소문자를 구분
// JS 예약어 사용 x