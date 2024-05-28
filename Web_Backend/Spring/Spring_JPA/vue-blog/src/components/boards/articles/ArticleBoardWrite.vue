<script setup>
import { ref, computed } from "vue"
import { useRouter, useRoute } from "vue-router"
import { storeToRefs } from "pinia"
import { useCategoryStore } from "@/stores/category"

import { registerArticle } from "@/api/board"
import Swal from "sweetalert2"

const router = useRouter()
const route = useRoute()

const categoryStore = useCategoryStore()
const { menuItems } = storeToRefs(categoryStore)

const control = ref(route.path.split("/")[1])

const param = ref({
  pgno: route.query.pgno,
  spp: route.query.spp,
  key: route.query.key,
  word: route.query.word,
  bcode: route.query.bcode,
})

const article = ref({
  userId: "kimssafy",
  subject: "",
  content: "",
  bcode: route.query.bcode,
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

const writeArticle = () => {
  let msg = "게시글등록 처리시 문제 발생했습니다."
  registerArticle(
    control.value,
    article.value,
    (response) => {
      if (response.status == 201) msg = "게시글등록이 완료되었습니다."

      Swal.fire("글작성", msg, "success")
      listArticle()
    },
    (error) => {
      console.error(error)
    }
  )
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
    <div class="flex flex-col w-full justify-center items-center p-10 mt-5">
      <div class="relative h-10 w-full min-w-[200px]">
        <!-- <input
          class="peer h-full w-full rounded-[7px] text-gray-600 border border-gray-600 border-t-transparent bg-transparent px-3 py-2.5 font-sans text-sm font-normal text-blue-gray-700 outline outline-0 transition-all placeholder-shown:border placeholder-shown:border-gray-600 placeholder-shown:border-t-gray-600 focus:border-2 focus:border-gray-600 focus:border-t-transparent focus:outline-0 disabled:border-0 disabled:bg-gray-50"
          placeholder=" "
        />
        <label
          class="before:content[' '] after:content[' '] pointer-events-none absolute left-0 -top-1.5 flex h-full w-full select-none text-[11px] font-normal leading-tight text-gray-600 transition-all before:pointer-events-none before:mt-[6.5px] before:mr-1 before:box-border before:block before:h-1.5 before:w-2.5 before:rounded-tl-md before:border-t before:border-l before:border-gray-600 before:transition-all after:pointer-events-none after:mt-[6.5px] after:ml-1 after:box-border after:block after:h-1.5 after:w-2.5 after:flex-grow after:rounded-tr-md after:border-t after:border-r after:border-gray-600 after:transition-all peer-placeholder-shown:text-sm peer-placeholder-shown:leading-[3.75] peer-placeholder-shown:text-gray-600 peer-placeholder-shown:before:border-transparent peer-placeholder-shown:after:border-transparent peer-focus:text-[11px] peer-focus:leading-tight peer-focus:text-gray-600 peer-focus:before:border-t-2 peer-focus:before:border-l-2 peer-focus:before:border-gray-600 peer-focus:after:border-t-2 peer-focus:after:border-r-2 peer-focus:after:border-gray-600 peer-disabled:text-transparent peer-disabled:before:border-transparent peer-disabled:after:border-transparent peer-disabled:peer-placeholder-shown:text-gray-600"
        >
          제목 입력...
        </label> -->
        <input
          v-model="article.subject"
          class="peer h-full w-full text-gray-600 border border-gray-300 border-t-transparent bg-transparent px-3 py-2.5 font-sans text-sm font-normal text-blue-gray-700 outline outline-0 transition-all placeholder-shown:border placeholder-shown:border-gray-300 placeholder-shown:border-t-gray-300 focus:border-2 focus:border-gray-300 focus:border-t-transparent focus:outline-0 disabled:border-0 disabled:bg-gray-50"
          placeholder=" "
        />
        <label
          class="before:content[' '] after:content[' '] pointer-events-none absolute left-0 -top-1.5 flex h-full w-full select-none text-[11px] font-normal leading-tight text-gray-600 transition-all before:pointer-events-none before:mt-[6.5px] before:mr-1 before:box-border before:block before:h-1.5 before:w-2.5 before:border-t before:border-l before:border-gray-300 before:transition-all after:pointer-events-none after:mt-[6.5px] after:ml-1 after:box-border after:block after:h-1.5 after:w-2.5 after:flex-grow after:border-t after:border-r after:border-gray-300 after:transition-all peer-placeholder-shown:text-sm peer-placeholder-shown:leading-[3.75] peer-placeholder-shown:text-gray-600 peer-placeholder-shown:before:border-transparent peer-placeholder-shown:after:border-transparent peer-focus:text-[11px] peer-focus:leading-tight peer-focus:text-gray-600 peer-focus:before:border-t-2 peer-focus:before:border-l-2 peer-focus:before:border-gray-300 peer-focus:after:border-t-2 peer-focus:after:border-r-2 peer-focus:after:border-gray-300 peer-disabled:text-transparent peer-disabled:before:border-transparent peer-disabled:after:border-transparent peer-disabled:peer-placeholder-shown:text-gray-600"
        >
          제목 입력...
        </label>
      </div>
      <div class="relative h-96 w-full min-w-[200px] mt-2">
        <!-- <textarea
          class="peer h-full w-full rounded-[7px] text-gray-600 border border-gray-600 border-t-transparent bg-transparent px-3 py-2.5 font-sans text-sm font-normal text-blue-gray-700 outline outline-0 transition-all placeholder-shown:border placeholder-shown:border-gray-600 placeholder-shown:border-t-gray-600 focus:border-2 focus:border-gray-600 focus:border-t-transparent focus:outline-0 disabled:border-0 disabled:bg-gray-50"
          placeholder=" "
        ></textarea>
        <label
          class="before:content[' '] after:content[' '] pointer-events-none absolute left-0 -top-1.5 flex h-full w-full select-none text-[11px] font-normal leading-tight text-gray-600 transition-all before:pointer-events-none before:mt-[6.5px] before:mr-1 before:box-border before:block before:h-1.5 before:w-2.5 before:rounded-tl-md before:border-t before:border-l before:border-gray-600 before:transition-all after:pointer-events-none after:mt-[6.5px] after:ml-1 after:box-border after:block after:h-1.5 after:w-2.5 after:flex-grow after:rounded-tr-md after:border-t after:border-r after:border-gray-600 after:transition-all peer-placeholder-shown:text-sm peer-placeholder-shown:leading-[3.75] peer-placeholder-shown:text-gray-600 peer-placeholder-shown:before:border-transparent peer-placeholder-shown:after:border-transparent peer-focus:text-[11px] peer-focus:leading-tight peer-focus:text-gray-600 peer-focus:before:border-t-2 peer-focus:before:border-l-2 peer-focus:before:border-gray-600 peer-focus:after:border-t-2 peer-focus:after:border-r-2 peer-focus:after:border-gray-600 peer-disabled:text-transparent peer-disabled:before:border-transparent peer-disabled:after:border-transparent peer-disabled:peer-placeholder-shown:text-gray-600"
        >
          내용 입력...
        </label> -->
        <QuillEditor v-model:content="article.content" contentType="html" theme="snow" />
      </div>

      <div class="flex w-full mt-14 justify-end">
        <button
          class="middle none center mr-2 rounded-lg bg-stone-500 py-3 px-6 font-sans text-xs font-bold uppercase text-white shadow-md shadow-stone-500/20 transition-all hover:shadow-lg hover:shadow-stone-500/40 focus:opacity-[0.85] focus:shadow-none active:opacity-[0.85] active:shadow-none disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none"
          data-ripple-light="true"
          @click="writeArticle"
        >
          글작성
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

<style scoped lang="scss">
#file {
  &::file-selector-button {
    display: none;
  }
}
</style>
