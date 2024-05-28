<script setup>
import { ref, onMounted, computed, watch } from "vue"
import { useRouter, useRoute } from "vue-router"
import { storeToRefs } from "pinia"
import { useCategoryStore } from "@/stores/category"

import { listArticle } from "@/api/board"

import VSelect from "../../common/VSelect.vue"
import VPageNavigation from "../../common/VPageNavigation.vue"

const control = "picture"

const router = useRouter()
const route = useRoute()

const categoryStore = useCategoryStore()
const { menuItems } = storeToRefs(categoryStore)

const bcode = ref(route.params.bcode)

const selectOption = ref([
  { text: "검색조건", value: "" },
  { text: "글번호", value: "article_no" },
  { text: "제목", value: "subject" },
  { text: "작성자아이디", value: "user_id" },
])

const articles = ref([])
const currentPage = ref(1)
const totalPage = ref(0)
const { VITE_PICTURE_LIST_SIZE } = import.meta.env
const param = ref({
  pgno: currentPage.value,
  spp: VITE_PICTURE_LIST_SIZE,
  key: "",
  word: "",
  bcode: bcode.value,
})

onMounted(() => {
  getPictureList()
})

const boardTitle = computed(() => {
  let title = ""
  menuItems.value.forEach((menu) => {
    menu.boardLists.forEach((boardInfo) => {
      if (boardInfo.bcode == bcode.value) {
        title = boardInfo.bname
      }
    })
  })
  return title
})

watch(
  () => route.params.bcode,
  (val) => {
    param.value.bcode = val
    getPictureList()
  }
)

const getPictureList = () => {
  listArticle(
    control,
    param.value,
    ({ data }) => {
      articles.value = data.articles
      currentPage.value = data.currentPage
      totalPage.value = data.totalPageCount
    },
    (error) => {
      console.error(error)
    }
  )
}

const onPageChange = (val) => {
  currentPage.value = val
  param.value.pgno = val
  getPictureList()
}

const onChangeKey = (val) => {
  param.value.key = val
  console.log(param.value)
}

const viewPicture = () => {
  router.push({
    name: "picture-detail",
    params: { articleNo: 10 },
  })
}
</script>

<template>
  <div class="flex flex-col w-full min-h-screen items-center justify-start bg-white mt-10">
    <div class="flex justify-center rounded-xl bg-white bg-clip-border text-slate-500 shadow-sm">
      <div class="p-3 text-center">
        <h2 class="w-96 font-sans text-4xl font-semibold leading-snug tracking-normal antialiased">
          {{ boardTitle }}
        </h2>
      </div>
    </div>
    <div class="flex flex-col md:flex-row w-full justify-between items-center pe-6 mt-5">
      <div class="ml-5">
        <button
          class="flex select-none items-center gap-3 rounded-lg bg-gradient-to-tr text-stone-600 bg-stone-100 py-3 px-6 text-center align-middle font-sans text-xs font-bold uppercase shadow-md shadow-stone-500/20 transition-all hover:shadow-lg hover:shadow-stone-500/40 hover:bg-stone-200 active:opacity-[0.85] disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none"
          type="button"
          data-ripple-light="true"
          @click="router.push({ name: 'picture-write' })"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            height="1em"
            viewBox="0 0 512 512"
            class="h-5 w-5 fill-stone-600"
          >
            <!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
            <path
              d="M362.7 19.3L314.3 67.7 444.3 197.7l48.4-48.4c25-25 25-65.5 0-90.5L453.3 19.3c-25-25-65.5-25-90.5 0zm-71 71L58.6 323.5c-10.4 10.4-18 23.3-22.2 37.4L1 481.2C-1.5 489.7 .8 498.8 7 505s15.3 8.5 23.7 6.1l120.3-35.4c14.1-4.2 27-11.8 37.4-22.2L421.7 220.3 291.7 90.3z"
            />
          </svg>
          글작성
        </button>
      </div>
      <div class="flex w-100 items-end gap-2 pe-2">
        <div class="relative h-10 w-full min-w-[200px]">
          <v-select :selectOption="selectOption" @onKeySelect="onChangeKey"></v-select>
        </div>

        <div class="relative h-10 w-full min-w-[200px]">
          <input
            class="peer h-full w-full rounded-[7px] text-pink-600 border border-pink-600 border-t-transparent bg-transparent px-3 py-2.5 font-sans text-sm font-normal text-blue-gray-700 outline outline-0 transition-all placeholder-shown:border placeholder-shown:border-pink-600 placeholder-shown:border-t-pink-600 focus:border-2 focus:border-pink-600 focus:border-t-transparent focus:outline-0 disabled:border-0 disabled:bg-pink-50"
            placeholder=" "
          />
          <label
            class="before:content[' '] after:content[' '] pointer-events-none absolute left-0 -top-1.5 flex h-full w-full select-none text-[11px] font-normal leading-tight text-pink-600 transition-all before:pointer-events-none before:mt-[6.5px] before:mr-1 before:box-border before:block before:h-1.5 before:w-2.5 before:rounded-tl-md before:border-t before:border-l before:border-pink-600 before:transition-all after:pointer-events-none after:mt-[6.5px] after:ml-1 after:box-border after:block after:h-1.5 after:w-2.5 after:flex-grow after:rounded-tr-md after:border-t after:border-r after:border-pink-600 after:transition-all peer-placeholder-shown:text-sm peer-placeholder-shown:leading-[3.75] peer-placeholder-shown:text-pink-600 peer-placeholder-shown:before:border-transparent peer-placeholder-shown:after:border-transparent peer-focus:text-[11px] peer-focus:leading-tight peer-focus:text-pink-600 peer-focus:before:border-t-2 peer-focus:before:border-l-2 peer-focus:before:border-pink-600 peer-focus:after:border-t-2 peer-focus:after:border-r-2 peer-focus:after:border-pink-600 peer-disabled:text-transparent peer-disabled:before:border-transparent peer-disabled:after:border-transparent peer-disabled:peer-placeholder-shown:text-pink-600"
          >
            검색어 입력...
          </label>
        </div>
        <button
          class="flex h-10 select-none items-center gap-3 rounded-lg bg-gradient-to-tr from-pink-600 to-pink-400 py-3 px-6 text-center align-middle font-sans text-xs font-bold uppercase text-white shadow-md shadow-pink-500/20 transition-all hover:shadow-lg hover:shadow-pink-500/40 active:opacity-[0.85] disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none"
          type="button"
          data-ripple-light="true"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            height="1em"
            viewBox="0 0 512 512"
            class="fill-white"
          >
            <!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
            <path
              d="M416 208c0 45.9-14.9 88.3-40 122.7L502.6 457.4c12.5 12.5 12.5 32.8 0 45.3s-32.8 12.5-45.3 0L330.7 376c-34.4 25.2-76.8 40-122.7 40C93.1 416 0 322.9 0 208S93.1 0 208 0S416 93.1 416 208zM208 352a144 144 0 1 0 0-288 144 144 0 1 0 0 288z"
            />
          </svg>
        </button>
      </div>
    </div>
    <div class="grid lg:grid-cols-4 md:grid-cols-2 sm:grid-cols-1 w-full p-6 overflow-scroll px-2">
      <!-- card start -->
      <div
        class="w-full max-w-[20rem] flex-col rounded-xl bg-white bg-clip-border text-gray-700 shadow-lg mx-2 my-2 transition-transform transform hover:scale-105 cursor-pointer"
        v-for="i in 12"
        :key="i"
        @click="viewPicture"
      >
        <div
          class="relative mx-4 mt-4 overflow-hidden rounded-xl bg-gray-500 bg-clip-border text-white shadow-lg shadow-gray-500/40"
        >
          <img
            src="https://images.unsplash.com/photo-1499696010180-025ef6e1a8f9?ixlib=rb-4.0.3&amp;ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&amp;auto=format&amp;fit=crop&amp;w=1470&amp;q=80"
            alt=""
          />
          <div
            class="to-bg-black-10 absolute inset-0 h-full w-full bg-gradient-to-tr from-transparent via-transparent to-black/60"
          ></div>
        </div>
        <div class="p-6">
          <div class="mb-3 flex items-center justify-between">
            <span
              class="block font-sans text-md font-medium leading-snug tracking-normal text-blue-gray-900 antialiased cursor-pointer"
              @click="viewPicture"
            >
              제목이 나오는 부분입니다.
            </span>
            <p
              class="flex items-center gap-1.5 font-sans text-base font-normal leading-relaxed text-blue-gray-900 antialiased"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                height="1em"
                viewBox="0 0 512 512"
                class="h-6 w-6 fill-pink-600"
              >
                <!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
                <path
                  d="M47.6 300.4L228.3 469.1c7.5 7 17.4 10.9 27.7 10.9s20.2-3.9 27.7-10.9L464.4 300.4c30.4-28.3 47.6-68 47.6-109.5v-5.8c0-69.9-50.5-129.5-119.4-141C347 36.5 300.6 51.4 268 84L256 96 244 84c-32.6-32.6-79-47.5-124.6-39.9C50.5 55.6 0 115.2 0 185.1v5.8c0 41.5 17.2 81.2 47.6 109.5z"
                />
              </svg>
              5.0
            </p>
          </div>
          <div class="group mt-3 flex justify-end flex-wrap items-center gap-3">
            <span
              class="cursor-pointer rounded-full border border-indigo-500/5 bg-indigo-500/5 p-3 text-indigo-500 transition-colors hover:border-indigo-500/10 hover:bg-indigo-500/10 hover:!opacity-100 group-hover:opacity-70"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                height="1em"
                viewBox="0 0 576 512"
                class="fill-indigo-600"
              >
                <!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
                <path
                  d="M352 144c0-44.2 35.8-80 80-80s80 35.8 80 80v48c0 17.7 14.3 32 32 32s32-14.3 32-32V144C576 64.5 511.5 0 432 0S288 64.5 288 144v48H64c-35.3 0-64 28.7-64 64V448c0 35.3 28.7 64 64 64H384c35.3 0 64-28.7 64-64V256c0-35.3-28.7-64-64-64H352V144z"
                />
              </svg>
            </span>
            <span>20</span>
            <span
              class="cursor-pointer rounded-full border border-slate-500/5 bg-slate-500/5 p-3 text-slate-500 transition-colors hover:border-slate-500/10 hover:bg-slate-500/10 hover:!opacity-100 group-hover:opacity-70"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                height="1em"
                viewBox="0 0 512 512"
                class="fill-slate-600"
              >
                <!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
                <path
                  d="M64 0C28.7 0 0 28.7 0 64V352c0 35.3 28.7 64 64 64h96v80c0 6.1 3.4 11.6 8.8 14.3s11.9 2.1 16.8-1.5L309.3 416H448c35.3 0 64-28.7 64-64V64c0-35.3-28.7-64-64-64H64z"
                />
              </svg>
            </span>
            <span>30</span>
          </div>
        </div>
      </div>
      <!-- card end -->
    </div>
    <v-page-navigation
      :current-page="currentPage"
      :total-page="totalPage"
      @pageChange="onPageChange"
    ></v-page-navigation>
  </div>
</template>

<style scoped></style>
