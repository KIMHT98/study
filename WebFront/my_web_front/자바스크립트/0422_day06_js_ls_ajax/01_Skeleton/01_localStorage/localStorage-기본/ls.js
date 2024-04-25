const jsonLocalStorage = {
  setItem: (key, value) => {
    localStorage.setItem(key, JSON.stringify(value));
  },
  getItem: (key) => {
    return JSON.parse(localStorage.getItem(key) || "");
  },
};

//////// 페이지에 처음 들어왔을 때 
window.addEventListener("load", function () {
  const data = localStorage.getItem("data")
  if (data != null) {
    document.querySelector("#saved > li").innerText = JSON.parse(data)
  } else {
    document.querySelector('#saved > li').innerText = "저장된 내용이 없습니다."
  }
})




//////// 등록 #create 

// 1. 등록 버튼 선택(접근)
const createBtn = document.querySelector("#create")
// 2. 등록 버튼에 클릭 이벤트 추가
createBtn.addEventListener("click",function(){
  // 2-a. input 태그  || input 아이디 선택 
  const inputTag = document.querySelector("#input")
  console.log(inputTag.value)
  // 2-b. input에서 가져온 value를 json문자열으로 바꾸기
  jsonLocalStorage.setItem("temp",inputTag.value);
  // const content = JSON.stringify(inputTag.value)
  // console.log(content)
  // // 2-c. localStorage에 "data" 이름으로 값 추가
  // localStorage.setItem("temp",content)
  // // (중요) 2-d. input태그의 value값 초기화
  inputTag.value = ""
  console.log(inputTag.value)
}) 
//////// 조회 #read 
// 코드를 작성하세요.
//1. 조회 버튼 선택(접근)
const readBtn = document.querySelector("#read")
//2. 조회 버튼에 클릭 이벤트 추가
readBtn.addEventListener("click",function(){
  //2-a. saved > li가져오기
  const liTag = document.querySelector("#saved > li")
  //2-b. data값 가져오기
  const content = JSON.parse(localStorage.getItem("temp"))
  localStorage.setItem("data",JSON.stringify(content))
  if(!content){
    liTag.innerText = "저장된 내용이 없습니다."
  }else{
    //liTag에 내용 넣기
    liTag.innerText = content
  }
})
//////// 삭제 #delete 
//1.삭제 버튼 가져오기
const deleteBtn = document.querySelector("#delete")
deleteBtn.addEventListener("click",function(){
  localStorage.removeItem("data")
  localStorage.removeItem("temp");
  const liTag = document.querySelector("#saved > li")
  if(liTag.innerText==="저장된 내용이 없습니다."){
    alert("삭제할 내용이 없습니다.")
  }else{
    liTag.innerText = "저장된 내용이 없습니다."
    alert("삭제 완료")

  }
  
  
})




