/* 문자열 연산 */
// 문자열과 숫자 타입의 + 연산 -> 문자열
// 문자열과 숫자 타입의 + 연산 이외 -> 숫자


console.log(1+"20",typeof(1 + "20")); //120 string
console.log("1" + "20",typeof("1" + "20")); //120 string
console.log("1" + 20,typeof("1" + 20)); //120 string 
console.log("100" - 8,typeof("100" - 8)); //92 number 
console.log("100" * 8,typeof("100" * 8)); //800 number
