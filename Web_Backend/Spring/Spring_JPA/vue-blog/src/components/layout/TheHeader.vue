<script setup>
import { RouterLink } from "vue-router"
</script>

<template>
  <header
    class="w-full fixed top-0 left-0 z-30 text-gray-700 bg-white border-t border-gray-100 shadow-sm body-font"
  >
    <div class="flex flex-col items-center justify-between p-6 mx-auto md:flex-row">
      <router-link
        :to="{ name: 'main' }"
        class="flex items-center mb-4 font-medium text-gray-900 title-font md:mb-0"
      >
        <img src="@/assets/logo_square.png" class="inline h-8 v-8" />
      </router-link>
      <nav
        class="flex flex-wrap items-center justify-center pl-6 ml-6 text-base border-l border-gray-200"
      >
        <router-link :to="{ name: 'article' }" class="mr-5 font-medium hover:text-gray-900"
          >게시판</router-link
        >
      </nav>
      <nav
        class="flex flex-wrap items-center justify-center pl-6 ml-6 text-base border-l border-gray-200 md:mr-auto"
      >
        <router-link :to="{ name: 'board-make' }" class="mr-5 font-medium hover:text-gray-900"
          >게시판 생성</router-link
        >
      </nav>
      <div class="flex-shrink-0 mr-3">
        <img
          class="relative inline-block h-8 w-8 rounded-full object-cover object-center"
          alt=""
          src="@/assets/profile.png"
        />
      </div>
      <div class="items-center h-full">
        <router-link :to="{ name: 'user-login' }" class="mr-5 font-medium hover:text-gray-900">
          로그인
        </router-link>
      </div>
      <div class="items-center h-full">
        <router-link
          :to="{ name: 'user-join' }"
          class="px-4 py-2 text-xs font-bold text-white uppercase transition-all duration-150 bg-blue-400 rounded shadow-lg shadow-blue-500/50 outline-none active:bg-teal-600 hover:shadow-md focus:outline-none ease"
        >
          회원가입
        </router-link>
      </div>
    </div>
  </header>
</template>

<style scoped></style>
