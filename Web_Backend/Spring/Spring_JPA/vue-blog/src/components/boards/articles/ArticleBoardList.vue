<script setup>
import { ref, onMounted, computed, watch } from "vue"
import { useRouter, useRoute } from "vue-router"
import { storeToRefs } from "pinia"
import { useCategoryStore } from "@/stores/category"

import { listArticle } from "@/api/board"

import VSelect from "../../common/VSelect.vue"
import VPageNavigation from "../../common/VPageNavigation.vue"

const router = useRouter()
const route = useRoute()

const categoryStore = useCategoryStore()
const { menuItems } = storeToRefs(categoryStore)

const control = ref(route.path.split("/")[1])
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
const { VITE_ARTICLE_LIST_SIZE } = import.meta.env
const param = ref({
  pgno: currentPage.value,
  spp: VITE_ARTICLE_LIST_SIZE,
  key: "",
  word: "",
  bcode: bcode.value,
})

onMounted(() => {
  getArticleList()
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
    if (val) {
      bcode.value = val
      param.value.bcode = val
      control.value = route.path.split("/")[1]
      getArticleList()
    }
  }
)

const getArticleList = () => {
  listArticle(
    control.value,
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
  getArticleList()
}

const onChangeKey = (val) => {
  param.value.key = val
}

const viewArticle = (article) => {
  router.push({
    name: `${control.value}-detail`,
    params: {
      articleNo: article.articleNo,
    },
    query: param.value,
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
          @click="router.push({ name: `${control}-write`, query: param })"
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
    <div class="w-full p-6 overflow-scroll px-10">
      <table class="w-full min-w-max table-auto text-center">
        <thead>
          <tr>
            <th class="border-y border-blue-gray-100 bg-blue-gray-50/50 p-4">
              <p
                class="block antialiased font-sans text-sm text-blue-gray-900 font-normal leading-none opacity-70"
              >
                글번호
              </p>
            </th>
            <th class="border-y border-blue-gray-100 bg-blue-gray-50/50 p-4">
              <p
                class="block antialiased font-sans text-sm text-blue-gray-900 font-normal leading-none opacity-70"
              >
                제목
              </p>
            </th>
            <th class="border-y border-blue-gray-100 bg-blue-gray-50/50 p-4">
              <p
                class="block antialiased font-sans text-sm text-blue-gray-900 font-normal leading-none opacity-70"
              >
                조회수
              </p>
            </th>
            <th class="border-y border-blue-gray-100 bg-blue-gray-50/50 p-4">
              <p
                class="block antialiased font-sans text-sm text-blue-gray-900 font-normal leading-none opacity-70"
              >
                작성자
              </p>
            </th>
            <th class="border-y border-blue-gray-100 bg-blue-gray-50/50 p-4">
              <p
                class="block antialiased font-sans text-sm text-blue-gray-900 font-normal leading-none opacity-70"
              >
                작성일
              </p>
            </th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="article in articles" :key="article.articleNo">
            <td class="p-4 border-b border-blue-gray-50">
              <div class="flex items-center justify-center gap-3">{{ article.articleNo }}</div>
            </td>
            <td class="p-4 border-b border-blue-gray-50">
              <p
                id="link-subject"
                class="block antialiased font-sans text-left leading-normal text-blue-gray-900 font-normal"
                :style="{ 'padding-left': article.depth * 1 + 'rem' }"
                @click="viewArticle(article)"
              >
                {{ article.subject }}
              </p>
            </td>
            <td class="p-4 border-b border-blue-gray-50">
              <p
                class="block antialiased font-sans text-center leading-normal text-blue-gray-900 font-normal"
              >
                {{ article.hit }}
              </p>
            </td>
            <td class="p-4 border-b border-blue-gray-50">
              <div class="flex justify-center items-center">
                <img
                  class="relative inline-block h-5 w-5 rounded-full object-cover object-center mr-1"
                  alt=""
                  src="@/assets/profile.png"
                />
                {{ article.userName }}
              </div>
            </td>
            <td class="p-4 border-b border-blue-gray-50">
              <div class="flex items-center justify-center gap-3">{{ article.registerTime }}</div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <v-page-navigation
      :current-page="currentPage"
      :total-page="totalPage"
      @pageChange="onPageChange"
    ></v-page-navigation>
  </div>
</template>

<style scoped lang="scss">
#link-subject {
  cursor: pointer;
  &:hover {
    font-weight: bold;
  }
}
</style>
