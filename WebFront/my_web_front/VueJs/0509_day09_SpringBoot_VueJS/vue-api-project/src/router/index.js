import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import YoutubeView from '@/views/YoutubeView.vue'
import BoardView from '@/views/BoardView.vue'
import BoardCreate from '@/components/board/BoardCreate.vue'
import BoardList from '@/components/board/BoardList.vue'
import BoardUpdate from '@/components/board/BoardUpdate.vue'
import BoardDetail from '@/components/board/BoardDetail.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/youtube',
      name: 'youtube',
      component: YoutubeView
    },{
      path: '/board',
      name: 'board',
      component: BoardView,
      children: [
        {
          path: '',
          name: 'board-list',
          component: BoardList
        },
        {
          path: 'create',
          name: 'board-create',
          component: BoardCreate
        },
        {
          path: 'update',
          name: 'board-update',
          component: BoardUpdate
        },
        {
          path: ':id',
          name: 'board-detail',
          component: BoardDetail
        },
       
      ]
    },
  ]
})

export default router
