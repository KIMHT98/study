import { createRouter, createWebHistory } from "vue-router"
import HomeView from "../views/HomeView.vue"

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "main",
      component: HomeView,
    },
    {
      path: "/users",
      name: "users",
      component: () => import("../views/UserView.vue"),
      children: [
        {
          path: "login",
          name: "user-login",
          component: () => import("@/components/users/UserLogin.vue"),
        },
        {
          path: "join",
          name: "user-join",
          component: () => import("@/components/users/UserJoin.vue"),
        },
      ],
    },
    {
      path: "/article",
      name: "article",
      component: () => import("../views/ArticleBoardView.vue"),
      // redirect: "/article/list",
      children: [
        {
          path: "list/:bcode",
          name: "article-list",
          component: () => import("../components/boards/articles/ArticleBoardList.vue"),
        },
        {
          path: "write",
          name: "article-write",
          component: () => import("@/components/boards/articles/ArticleBoardWrite.vue"),
        },
        {
          path: "details/:articleNo",
          name: "article-detail",
          component: () => import("@/components/boards/articles/ArticleBoardDetail.vue"),
        },
      ],
    },
    {
      path: "/reboard",
      name: "reboard",
      component: () => import("../views/ArticleBoardView.vue"),
      // redirect: "/reboard/list",
      children: [
        {
          path: "list/:bcode",
          name: "reboard-list",
          component: () => import("../components/boards/articles/ArticleBoardList.vue"),
        },
        {
          path: "write",
          name: "reboard-write",
          component: () => import("@/components/boards/articles/ArticleBoardWrite.vue"),
        },
        {
          path: "details/:articleNo",
          name: "reboard-detail",
          component: () => import("@/components/boards/articles/ArticleBoardDetail.vue"),
        },
        {
          path: "reply/:articleNo",
          name: "reboard-reply",
          component: () => import("@/components/boards/articles/ArticleBoardReply.vue"),
        },
      ],
    },
    {
      path: "/picture",
      name: "picture",
      component: () => import("../views/PictureBoardView.vue"),
      // redirect: "/picture/list",
      children: [
        {
          path: "list/:bcode",
          name: "picture-list",
          component: () => import("@/components/boards/pictures/PictureBoardList.vue"),
        },
        {
          path: "write",
          name: "picture-write",
          component: () => import("@/components/boards/pictures/PictureBoardWrite.vue"),
        },
        {
          path: "details/:articleNo",
          name: "picture-detail",
          component: () => import("@/components/boards/pictures/PictureBoardDetail.vue"),
        },
      ],
    },
    {
      path: "/admin",
      name: "admin",
      component: () => import("../views/AdminView.vue"),
      redirect: "/admin/makeboard",
      children: [
        {
          path: "makeboard",
          name: "board-make",
          component: () => import("@/components/admin/board/MakeBoard.vue"),
        },
      ],
    },
  ],
})

export default router
