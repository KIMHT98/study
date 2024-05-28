<script setup>
import { ref, onMounted, computed } from "vue"
import { useRouter, useRoute } from "vue-router"
import { storeToRefs } from "pinia"
import { useCategoryStore } from "@/stores/category"

import { detailArticle } from "@/api/board"

const router = useRouter()
const route = useRoute()

const categoryStore = useCategoryStore()
const { menuItems } = storeToRefs(categoryStore)

const control = ref(route.path.split("/")[1])
const article = ref({})

const param = ref({
  pgno: route.query.pgno,
  spp: route.query.spp,
  key: route.query.key,
  word: route.query.word,
  bcode: route.query.bcode,
})

onMounted(() => {
  detailArticle(
    control.value,
    route.params.articleNo,
    ({ data }) => {
      article.value = data
    },
    (error) => {
      console.error(error)
    }
  )
})

const boardTitle = computed(() => {
  let title = ""
  menuItems.value.forEach((menu) => {
    menu.boardLists.forEach((boardInfo) => {
      if (boardInfo.bcode == param.value.bcode) {
        title = boardInfo.bname
      }
    })
  })
  return title
})

const replyArticle = () => {
  router.push({
    name: `${control.value}-reply`,
    params: { articleNo: article.value.articleNo },
    query: param.value,
  })
}

const listArticle = () => {
  router.push({
    name: `${control.value}-list`,
    params: { bcode: param.value.bcode },
    query: param.value,
  })
}
</script>

<template>
  <div class="flex flex-col w-full min-h-screen items-center justify-start bg-white mt-10">
    <div class="flex justify-center rounded-xl bg-white bg-clip-border text-slate-500 shadow-sm">
      <div class="p-3 text-center">
        <h2 class="w-64 font-sans text-4xl font-semibold leading-snug tracking-normal antialiased">
          {{ boardTitle }}
        </h2>
      </div>
    </div>
    <div class="flex flex-col w-full justify-start items-center px-10">
      <div class="flex justify-end h-15 w-full min-w-[200px] mt-5 px-4 py-2">
        <div class="group flex justify-end items-center flex-wrap gap-4">
          <span class="text-lg font-bold">
            <img
              class="relative inline-block h-6 w-6 rounded-full object-cover object-center mr-1"
              alt=""
              src="@/assets/profile.png"
            />
            {{ article.userName }}
          </span>
          <span class="text-md">{{ article.registerTime }}</span>
        </div>
      </div>

      <div
        class="group flex w-full justify-between flex-wrap items-center gap-2 border-b-2 border-b-slate-300 mr-9 px-4 pb-2"
      >
        <div class="text-2xl text-zinc-600">{{ article.articleNo }}. {{ article.subject }}</div>
        <div class="group flex justify-end flex-wrap items-center gap-3">
          <span
            class="cursor-pointer rounded-full border border-indigo-500/5 bg-indigo-500/5 p-3 text-indigo-500 transition-colors hover:border-indigo-500/10 hover:bg-indigo-500/10 hover:!opacity-100 group-hover:opacity-70"
          >
            <svg
              xmlns="http://www.w3.org/2000/svg"
              height="1em"
              viewBox="0 0 512 512"
              class="fill-indigo-600"
            >
              <!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
              <path
                d="M352 144c0-44.2 35.8-80 80-80s80 35.8 80 80v48c0 17.7 14.3 32 32 32s32-14.3 32-32V144C576 64.5 511.5 0 432 0S288 64.5 288 144v48H64c-35.3 0-64 28.7-64 64V448c0 35.3 28.7 64 64 64H384c35.3 0 64-28.7 64-64V256c0-35.3-28.7-64-64-64H352V144z"
              />
            </svg>
          </span>
          <span>{{ article.hit }}</span>
          <span
            class="cursor-pointer rounded-full border border-slate-500/5 bg-slate-500/5 p-3 text-slate-500 transition-colors hover:border-slate-500/10 hover:bg-slate-500/10 hover:!opacity-100 group-hover:opacity-70"
          >
            <svg
              xmlns="http://www.w3.org/2000/svg"
              height="1em"
              viewBox="0 0 512 512"
              class="fill-pink-600"
            >
              <!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
              <path
                d="M47.6 300.4L228.3 469.1c7.5 7 17.4 10.9 27.7 10.9s20.2-3.9 27.7-10.9L464.4 300.4c30.4-28.3 47.6-68 47.6-109.5v-5.8c0-69.9-50.5-129.5-119.4-141C347 36.5 300.6 51.4 268 84L256 96 244 84c-32.6-32.6-79-47.5-124.6-39.9C50.5 55.6 0 115.2 0 185.1v5.8c0 41.5 17.2 81.2 47.6 109.5z"
              />
            </svg>
          </span>
          <span>30</span>
        </div>
      </div>
      <div
        class="relative w-full min-w-[200px] text-zinc-600 border-b-2 border-b-slate-300 mt-2 p-5"
        v-html="article.content"
      ></div>
      <div class="flex w-full mt-3 justify-end">
        <button
          class="middle none center mr-2 rounded-lg bg-stone-500 py-3 px-6 font-sans text-xs font-bold uppercase text-white shadow-md shadow-stone-500/20 transition-all hover:shadow-lg hover:shadow-stone-500/40 focus:opacity-[0.85] focus:shadow-none active:opacity-[0.85] active:shadow-none disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none"
          data-ripple-light="true"
        >
          글수정
        </button>
        <button
          class="middle none center mr-2 rounded-lg bg-red-500 py-3 px-6 font-sans text-xs font-bold uppercase text-white shadow-md shadow-red-500/20 transition-all hover:shadow-lg hover:shadow-red-500/40 focus:opacity-[0.85] focus:shadow-none active:opacity-[0.85] active:shadow-none disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none"
          data-ripple-light="true"
        >
          글삭제
        </button>
        <button
          class="middle none center mr-2 rounded-lg bg-amber-500 py-3 px-6 font-sans text-xs font-bold uppercase text-white shadow-md shadow-amber-500/20 transition-all hover:shadow-lg hover:shadow-amber-500/40 focus:opacity-[0.85] focus:shadow-none active:opacity-[0.85] active:shadow-none disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none"
          data-ripple-light="true"
          v-if="control == 'reboard'"
          @click="replyArticle"
        >
          답글작성
        </button>
        <button
          class="middle none center mr-2 rounded-lg bg-indigo-500 py-3 px-6 font-sans text-xs font-bold uppercase text-white shadow-md shadow-indigo-500/20 transition-all hover:shadow-lg hover:shadow-indigo-500/40 focus:opacity-[0.85] focus:shadow-none active:opacity-[0.85] active:shadow-none disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none"
          data-ripple-light="true"
          @click="listArticle"
        >
          목록보기
        </button>
      </div>
    </div>
  </div>
</template>

<style scoped lang="scss"></style>
