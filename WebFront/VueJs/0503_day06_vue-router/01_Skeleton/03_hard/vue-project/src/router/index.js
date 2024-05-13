import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import UserView from "../views/UserView.vue";
import LoginView from "../views/LoginView.vue";
const isAuthenticated = false;
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
      // beforeEnter: (to, from) => {
      //   if (!isAuthenticated) {
      //     console.log("로그인 하고와");
      //     return { name: "login" };
      //   }
      // },
    },
    {
      path: "/about",
      name: "about",
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import("../views/AboutView.vue"),
      // beforeEnter: (to, from) => {
      //   if (!isAuthenticated) {
      //     console.log("로그인 하고와");
      //     return { name: "login" };
      //   }
      // },
    },
    {
      path: "/user/:id",
      name: "user",
      component: UserView,
    },
    {
      path: "/login",
      name: "login",
      component: LoginView,
      // beforeEnter: (to, from) => {
      //   if (isAuthenticated === true) {
      //     console.log("로그인 완료");
      //     return { name: "home" };
      //   } else {
      //     console.log("로그인 하고와");
      //   }
      // },
    },
  ],
});
// router.beforeEach((to, from) => {
//   console.log(to);
//   console.log(from);
//   return false;
// });
// router.beforeEach((to, from) => {
//   if (!isAuthenticated && to.name !== "login") {
//     console.log("로그인 안되어있음");
//     return { name: "login" };
//   }
// });

export default router;
