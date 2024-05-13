import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import YoutubeView from '@/views/YoutubeView.vue'
import BoardView from '@/views/BoardView.vue'
import BoardCreate from '@/components/board/BoardCreate.vue'
import BoardList from '@/components/board/BoardList.vue'
import BoardUpdate from '@/components/board/BoardUpdate.vue'
import BoardDetail from '@/components/board/BoardDetail.vue'
import KakaoView from '@/views/KakaoView.vue'
import TMDBView from '@/views/TMDBView.vue'
import TmdbPopular from '@/components/TMDB/TmdbPopular.vue'
import TmdbTopRank from '@/components/TMDB/TmdbTopRank.vue'
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
    {
      path: "/kakao",
      name: "kakao",
      component: KakaoView
    },
    {
      path:'/tmdb',
      name:'tmdb',
      component: TMDBView,
      children:[
        {
          path:'popular',
          name:'tmdb-popular',
          component: TmdbPopular
        },
        {
          path: 'toprank',
          name: 'tmdb-toprank',
          component: TmdbTopRank
        }
      ]
    }
  ]
})

export default router
