/* 자바스크립트 false */

// 아래의 5가지 값은 false로 인식, 나머지 값은 true로 인식
  // null
  // undefined
  // 0
  // ‘’ (빈문자열)
  // NaN



/* 어떻게 출력되는지 작성해보세요. */
// !
console.log("!0", !0); //t
console.log("''", !''); //t
console.log("!null", !null); //t
console.log("!undefined", !undefined); //t
console.log("!NaN", !NaN); //t


// !!
console.log("!!0", !!0); //f
console.log("!!''", !!''); //f
console.log("!!null", !!null); //f
console.log("!!undefined", !!undefined); //f
console.log("!!NaN", !!NaN); //f

var id;
console.log(id); // undefined
// id = "a"; // 값을 대입해주면?

if (id) {
    console.log("id가 값이 있는 경우...");
}
else {
    console.log("id가 값이 없는 경우...");//얘가 출력
}
