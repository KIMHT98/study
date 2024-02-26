var m1 = {name : "a1"}
var m2 = {name : "a2"}

function msg(){
  console.log(this);
  console.log(this.name+"님이 입장")
}
m1.msg = msg
m2.msg = msg
m1.msg()
/*
{ name: 'a1', msg: [Function: msg] }
a1님이 입장
*/
m2.msg()
/*
{ name: 'a2', msg: [Function: msg] }
a2님이 입장
*/