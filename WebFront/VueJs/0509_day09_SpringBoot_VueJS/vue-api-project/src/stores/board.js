import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

export const useBoardStore = defineStore('board', () => {
 
  const REST_BOARD_API = 'http://localhost:8080/api-board/board'

  const createBoard = function(board){
    axios({
      url:REST_BOARD_API,
      method: 'POST',
      data: board,
    })
    .then(()=>{
      router.push({name:'board-list'})
    })
    .catch((err)=>{
      console.log(err)
    })
  }
  const boardList = ref([])
  const getBoardList = function(){
    axios.get(REST_BOARD_API)
    .then((response)=>{
      boardList.value = response.data
    })
  }
  const board = ref({});
  const getBoard = function(id){
    axios.get(`${REST_BOARD_API}/${id}`)
    .then((response)=>{
      board.value = response.data
    })
  }
  const updateBoard = function(){
    axios.put(REST_BOARD_API, board.value)
    .then(()=>{
      router.push({name:'board-list'})
    })
  }

  const searchBoardList = function(searchCondition){
    axios.get(REST_BOARD_API,{
      params: searchCondition
    }).then((response)=>{
      boardList.value = response.data
    })
  }





  return { createBoard, getBoardList, boardList,board,getBoard,updateBoard,searchBoardList}
})
