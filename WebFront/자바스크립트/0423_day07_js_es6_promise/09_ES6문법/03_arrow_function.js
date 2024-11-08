let add = function (a, b) {
  return a + b
}
let add2 = (a, b) => {
  return a + b
}
let add3 = (a, b) => a + b


//위의 메서드는 모두 같은 기능을 하는 메서드
console.log(add(10, 20))
console.log(add2(10, 20))
console.log(add3(10, 20))

//함수를 간결하게 정의할 수 있도록 도움을 줌.
// 작성순서
// 1. function 키워드 삭제
// 2. ( ) 안에 함수가 사용할 파라미터 이름 작성 / 인자가 한개라면 괄호 생략가능  // ex) let pow = a => a**2
// 3. 화살표 ( => ) 를 붙인다.
// 4. { } 를 작성하고 블록 안에 함수가 실행할 코드 작성 / 함수가 return 문 하나라면 return 생략 가능

//주의사항
//기존의 함수에서 사용하는 this 와 화살표 함수의 this 는 서로 다른 this 값이 바인딩 될 수 있다.

// 기존함수의 this는 메서드가 호출 될때마다 현재 호출중인 메서드를 보유한 객체가 this로 연결
// 현재 호출중인 메서드를 보유한 객체가 없다면 전역 객체 (브라우저 환경에서의 window 객체)가 연결
// 화살표 함수는 함수가 정의되는 유효 범위의 this를 자신의 유효범위 this로 연결
