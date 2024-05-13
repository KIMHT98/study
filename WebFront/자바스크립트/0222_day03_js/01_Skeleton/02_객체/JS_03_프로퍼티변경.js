// 프로퍼티 변경

// 객체 생성 시 프로퍼티 추가
let class8 = {지역 : "서울", 인원 : 30, 교실 : "308호"}
function member(id, email){
  this.id = id
  this.email = email
}
let Member = new member(1234,"kht1335@asd.com")

console.log(class8.지역)//서울
console.log(class8["인원"])//30
console.log(Member.id)//1234
console.log(Member["email"])//kht1335@asd.com

//데이터 추가
Member.name = "현태"
//데이터 변경
Member.id = 1
//데이터 삭제
delete Member.email
console.log(Member)//member { id: 1, name: '현태' }