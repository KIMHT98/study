function myInfo(name, age='이십', ...hobbies) {
  console.log(
    `이름: ${name}, 나이: ${age}, 취미:${hobbies}`
  )
}

myInfo()
myInfo("haley")
myInfo("hugh", 'ㅁㅇㄴㄹ', "working", "running", "studying")
myInfo("haley", 35, "research", "working")
