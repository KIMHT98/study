// splice
// 배열의 특정위치에 요소를 추가하거나 삭제
// splice( index, 제거할 요소 개수, 배열에 추가될 요소 )


var arr = [1, 2, 3, 4, 5, 6, 7];
console.log(arr.splice(3, 2));//[4,5]가 제가됨
// 3번째 인덱스에서부터 2개 제거
console.log(arr); //[1,2,3,6,7] 

var arr = [1, 2, 3, 4, 5, 6, 7];
arr.splice(2, 1, "a", "b");
// 2번째 인덱스에서 1개 제거 후 "a"와 "b"를 추가
console.log(arr); //[1,2,"a","b",5,6,7] 

