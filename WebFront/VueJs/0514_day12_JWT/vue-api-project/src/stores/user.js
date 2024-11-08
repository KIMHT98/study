import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

const REST_BOARD_API = `http://localhost:8080/api-user`

export const useUserStore = defineStore('user', () => {
  const loginUserId = ref(null)
  const userLogin = function(id,password){
    axios.post(`${REST_BOARD_API}/login`,{
      id: id,
      password: password
    }).then((response)=>{
      sessionStorage.setItem('access-token',response.data["access-token"])
      
      const token = response.data['access-token'].split('.')
      let id = JSON.parse(atob(token[1]))['id']
    
      loginUserId.value = id

      router.push({name:'boardList'})
    
    }).catch((err)=>{
      console.log(err)
    })
  }

  return { userLogin}
})
