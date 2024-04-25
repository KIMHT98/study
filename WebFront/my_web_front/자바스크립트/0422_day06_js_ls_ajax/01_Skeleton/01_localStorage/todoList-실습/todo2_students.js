const createBtn = document.querySelector('#create') //등록버튼
const inputTag = document.querySelector('#todo') //입력 창
const ulTag = document.querySelector('#todo-list') //리스트
const btnDone = document.querySelector('#btn-done')//한거
const btnNo = document.querySelector('#btn-no')//전체
const btnAll = document.querySelector('#btn-all')//안한거

// 할 일이 1개만 있을까...?
let todoList


window.addEventListener('load', function () {
  todoList = localStorage.getItem('todoList')

  if (todoList !== null) {
    todoList = JSON.parse(todoList)
    for (let i = 0; i < todoList.length; i++) {
      createTodoItem(todoList[i])
    }
  } else {
    todoList = []
  }
})

//할일 등록하는 메서드
const createTodo = () => {
  const content = inputTag.value
  if(!content.trim()){
    alert("할 일을 등록해주세요.")
  }else{
    //할 일 객체
    const todoItem = {
      todo : content,
      done : false,
    }
    //할 일 만들기
    createTodoItem(todoItem)
    inputTag.value = ""//입력값 초기화
    //할 일을 입력한 후에도 커서가 남아있어서 바로 또 등록할 수 있음
    inputTag.focus()
    //등록을 했으니 할 일 목록에 넣어주자
    todoList.push(todoItem)
    //locasStorage에 저장
    localStorage.setItem("todoList", JSON.stringify(todoList))
  }

}

//할일 추가하는 메서드
const createTodoItem = (todoItem) => {
  //li태그 만들기
  const liTag = document.createElement("li")
  //span태그 만들기 -> 할 일 내용이 들어갈 것
  const spanTag = document.createElement("span")
  spanTag.innerText = todoItem.todo
  //li태그에 내용 넣기
  liTag.appendChild(spanTag)

  //삭제 버튼 만들기
  if(!todoItem.done){
    //삭제 버튼(a태그)
    const delBtn = document.createElement("a")
    delBtn.classList.add('btn', 'btn-sm', 'btn-danger', 'mx-2')
    delBtn.innerText = "x"

    //버튼 누르면 지워지는 이벤트 생성
    delBtn.addEventListener("click", function(){
      //할 일 지우기
      removeTodo(todoItem.todo)
      delBtn.remove()
    })
    liTag.appendChild(delBtn)
  }else{
    //이미 할 일인 경우 v 체크 표시
    const doneBtn = document.createElement('a')
    doneBtn.classList.add('btn', 'btn-sm', 'btn-success', 'mx-2', 'disabled'), 
    doneBtn.innerText = 'v'
    liTag.append(doneBtn)
  }
  ulTag.appendChild(liTag)
}


//할일 지우는 메서드
const removeTodo = (todo) => {
 //for문을 돌리면서 삭제할 할일을 찾음
  for(let i=0;i<todoList.length;i++){
    const atodo = todoList[i];
    //이게 아직 안한 일이고 내용이 같다면 완료상태를 true로 변경
    //같은 내용이 있을 수도 있으므로 하나만 찾고 중단
    if(!atodo.done && atodo.todo === todo){
      atodo.done = true;
      break;
    }
  }
  //클릭된 요소의 부모 요소(span)에 줄 그음
  event.target.parentElement.classList.add('text-decoration-line-through')
  localStorage.setItem("todoList", JSON.stringify(todoList))

}

//완료한 일 가져오기
const getDoneList = () => {
  const doneList = []
  //반복문 돌면서
  for(let i=0;i<todoList.length;i++){
    const atodo = todoList[i]
    //완료한 것들은 리스트에 넣기
    if(atodo.done){
      doneList.push(atodo)
    }
  }
  return doneList

}

//아직 안한 일 가져오기
const getNoList = () => {
  const noList = []
  //반복문 돌면서
  for(let i=0;i<todoList.length;i++){
    const atodo = todoList[i]
    //아직 안한 것들 리스트에 넣기
    if(!atodo.done){
      noList.push(atodo)
    }
  }
  return noList


}


//등록 버튼 누르면 글 추가(전체)
createBtn.addEventListener('click', createTodo)

//한 것들 목록 가져오기
btnDone.addEventListener('click', () => {
  ulTag.innerHTML = null
  //완료한 일들 가져오기
  const doneList = getDoneList()
  //반복문 돌면서 ul태그 밑에 li태그로 넣어줌
  for(let i=0;i<doneList.length;i++){
    const atodo = doneList[i]
    const liTag = document.createElement("li")
    liTag.append(atodo.todo)
    ulTag.append(liTag)
  }

})
//안한 것들 목록 가져오기
btnNo.addEventListener('click', () => {
  ulTag.innerHTML = null
  //안한 일들 가져오기
  const noList = getNoList()
  //반복문 돌면서 ul태그 밑에 li태그로 넣어줌
  for(let i=0;i<noList.length;i++){
    const atodo = noList[i]
    const liTag = document.createElement("li")
    liTag.append(atodo.todo)
    ulTag.append(liTag)
  }


})

//전체글 가져오기
btnAll.addEventListener('click', () => {
    ulTag.innerHTML = null
    //반복문 돌면서
    for(let i=0;i<todoList.length;i++){
      const atodo = todoList[i]
      //전체 일들 li태그로 추가하기
      createTodoItem(atodo)
    }


})