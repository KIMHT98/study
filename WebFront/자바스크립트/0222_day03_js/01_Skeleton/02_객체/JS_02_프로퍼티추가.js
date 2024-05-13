// 객체 생성 시 프로퍼티 추가
let class8 = {지역 : "서울", 인원 : 30, 교실 : "308호"}
function member(id, email){
  this.id = id
  this.email = email
}
let Member = new member(1234,"kht1335@asd.com")
