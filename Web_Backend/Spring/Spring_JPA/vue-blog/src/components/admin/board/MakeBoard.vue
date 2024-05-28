<script setup>
import { ref, onMounted } from "vue"
import Swal from "sweetalert2"

import { listCategory, registerCategory, listBoardType, createBoard } from "@/api/admin/make-board"

const categories = ref([])

const boardTypes = ref([])

const categoryName = ref("")

const boardInfo = ref({
  ccode: 0,
  btype: 0,
  bname: "",
})

// const selecteCategory = ref({
//   ccode: 0,
//   cname: "",
// });

onMounted(() => {
  listCategory(
    ({ data }) => {
      categories.value = data
    },
    (error) => {
      console.error(error)
    }
  )
  listBoardType(
    ({ data }) => {
      boardTypes.value = data
    },
    (error) => {
      console.error(error)
    }
  )
})

const makeCategory = async () => {
  if (categoryName.value) {
    console.log("카테고리이름 ::: " + categoryName.value)
    let msg = "카테고리등록 처리시 문제 발생했습니다."
    await registerCategory(
      { cname: categoryName.value },
      (response) => {
        if (response.status == 201) {
          msg = "카테고리등록이 완료되었습니다."
          listCategory(
            ({ data }) => {
              categories.value = data
            },
            (error) => {
              console.error(error)
            }
          )
        }
        // alert(msg);
        Swal.fire("카테고리생성", msg, "success")
      },
      (error) => {
        console.error(error)
        Swal.fire("카테고리생성", msg, "error")
      }
    )
  }
}

const makeBoard = () => {
  console.log("make boar info : ", boardInfo.value)
  let msg = "게시판 생성 처리시 문제 발생했습니다."
  createBoard(
    boardInfo.value,
    (response) => {
      if (response.status == 201) {
        msg = "게시판 생성이 완료되었습니다."
      }
      // alert(msg);
      Swal.fire("게시판생성", msg, "success")
    },
    (error) => {
      console.error(error)
      Swal.fire("게시판생성", msg, "error")
    }
  )
}
</script>

<template>
  <div id="main" class="absolute top-0 w-full h-1/2 bg-center bg-cover pt-[4.5rem]"></div>
  <div class="bg-gray-100 min-h-screen py-12 flex items-center justify-center">
    <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-2 gap-6">
      <!-- 카테고리 생성 및 변경 -->
      <div
        class="w-96 h-96 bg-white rounded-lg overflow-hidden shadow-lg transition-transform transform hover:scale-150 hover:z-10"
      >
        <div class="p-1 bg-deep-orange-200"></div>
        <div class="px-8 pt-5 text-center">
          <h2 class="text-2xl font-bold text-gray-800 mb-4">카테고리 생성 및 변경</h2>
        </div>
        <div class="px-2">
          <div class="flex w-full mb-3">
            <div class="relative h-10 w-full min-w-[200px]">
              <input
                v-model="categoryName"
                class="peer h-full w-full rounded-[7px] border border-blue-gray-200 bg-transparent px-3 py-2.5 font-sans text-sm font-normal text-blue-gray-700 outline outline-0 transition-all placeholder-shown:border placeholder-shown:border-blue-gray-200 placeholder-shown:border-t-blue-gray-200 focus:border-2 focus:border-teal-500 focus:border-t-transparent focus:outline-0 disabled:border-0 disabled:bg-blue-gray-50"
                placeholder=" "
              />
              <label
                class="before:content[' '] after:content[' '] pointer-events-none absolute left-0 -top-1.5 flex h-full w-full select-none text-[11px] font-normal leading-tight text-blue-gray-400 transition-all before:pointer-events-none before:mt-[6.5px] before:mr-1 before:box-border before:block before:h-1.5 before:w-2.5 before:rounded-tl-md before:border-t before:border-l before:border-blue-gray-200 before:transition-all after:pointer-events-none after:mt-[6.5px] after:ml-1 after:box-border after:block after:h-1.5 after:w-2.5 after:flex-grow after:rounded-tr-md after:border-t after:border-r after:border-blue-gray-200 after:transition-all peer-placeholder-shown:text-sm peer-placeholder-shown:leading-[3.75] peer-placeholder-shown:text-blue-gray-500 peer-placeholder-shown:before:border-transparent peer-placeholder-shown:after:border-transparent peer-focus:text-[11px] peer-focus:leading-tight peer-focus:text-teal-500 peer-focus:before:border-t-2 peer-focus:before:border-l-2 peer-focus:before:border-teal-500 peer-focus:after:border-t-2 peer-focus:after:border-r-2 peer-focus:after:border-teal-500 peer-disabled:text-transparent peer-disabled:before:border-transparent peer-disabled:after:border-transparent peer-disabled:peer-placeholder-shown:text-blue-gray-500"
              >
                카테고리명 입력
              </label>
            </div>
            <button
              class="flex h-10 items-center whitespace-nowrap ml-1 rounded-lg bg-gradient-to-tr from-deep-orange-800 to-deep-orange-300 py-3 px-8 text-center align-middle font-sans text-xs font-bold text-white shadow-md shadow-green-500/20 transition-all hover:shadow-lg hover:shadow-green-500/40 active:opacity-[0.85] disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none"
              type="button"
              data-ripple-light="true"
              @click="makeCategory"
            >
              생성
            </button>
          </div>
          <div
            class="center flex justify-center select-none whitespace-nowrap rounded-lg bg-orange-50 mb-3 py-2 px-3.5 align-baseline font-sans text-xs font-bold uppercase leading-none text-gray-700"
          >
            <div class="mt-px">현재 카테고리 목록</div>
          </div>
          <ul class="text-sm text-gray-600 mb-6">
            <template v-for="category in categories" :key="category.ccode">
              <li class="mb-2 flex items-center justify-between">
                <div class="flex">
                  <svg
                    class="w-4 h-4 mx-2 text-rose-500 bg"
                    fill="none"
                    stroke="currentColor"
                    viewBox="0 0 24 24"
                    xmlns="http://www.w3.org/2000/svg"
                  >
                    <path
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      stroke-width="2"
                      d="M5 13l4 4L19 7"
                    ></path>
                  </svg>
                  <span class="font-bold">{{ category.cname }}</span>
                </div>
                <div>
                  <button
                    class="flex h-7 items-center whitespace-nowrap ml-1 rounded-lg bg-gradient-to-tr bg-slate-600 py-3 px-2 text-center align-middle font-sans text-xs font-bold text-white shadow-md shadow-slate-500/20 transition-all hover:shadow-lg hover:shadow-slate-500/40 active:opacity-[0.85] disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none"
                    type="button"
                    data-ripple-light="true"
                    @click="makeCategory"
                  >
                    이름변경
                  </button>
                </div>
              </li>
            </template>
          </ul>
        </div>
      </div>

      <!-- 게시판 생성 -->
      <div
        class="w-96 h-96 bg-white rounded-lg overflow-hidden shadow-lg transition-transform transform hover:scale-150 hover:z-10"
      >
        <div class="p-1 bg-purple-200"></div>
        <div class="px-8 pt-5 text-center">
          <h2 class="text-2xl font-bold text-gray-800 mb-4">게시판 생성</h2>
        </div>
        <div class="px-2">
          <div class="flex flex-col w-full mb-3">
            <div class="mb-4">
              <select
                id="category"
                v-model="boardInfo.ccode"
                class="lign-middle select-none font-sans font-bold text-center uppercase transition-all disabled:opacity-50 disabled:shadow-none disabled:pointer-events-none text-xs py-2 px-4 rounded-lg bg-slate-600 text-white shadow-md shadow-slate-600/10 hover:shadow-lg hover:shadow-slate-600/20 focus:opacity-[0.85] focus:shadow-none active:opacity-[0.85] active:shadow-none"
              >
                <option value="0" selected disabled>카테고리선택</option>
                <option
                  v-for="category in categories"
                  :key="category.ccode"
                  :value="category.ccode"
                >
                  {{ category.cname }}
                </option>
              </select>
              <label for="category" class="ml-2"> : 카테고리 선택</label>
            </div>
            <div class="mb-4">
              <select
                id="category"
                v-model="boardInfo.btype"
                class="lign-middle select-none font-sans font-bold text-center uppercase transition-all disabled:opacity-50 disabled:shadow-none disabled:pointer-events-none text-xs py-2 px-4 rounded-lg bg-slate-600 text-white shadow-md shadow-slate-600/10 hover:shadow-lg hover:shadow-slate-600/20 focus:opacity-[0.85] focus:shadow-none active:opacity-[0.85] active:shadow-none"
              >
                <option value="0" selected disabled>게시판형식선택</option>
                <option
                  v-for="boardType in boardTypes"
                  :key="boardType.btype"
                  :value="boardType.btype"
                >
                  {{ boardType.btypeName }}
                </option>
              </select>
              <label for="category" class="ml-2">: 게시판 형식 선택</label>
            </div>
            <div class="flex w-full mb-3">
              <div class="relative h-10 w-full min-w-[200px]">
                <input
                  v-model="boardInfo.bname"
                  class="peer h-full w-full rounded-[7px] border border-blue-gray-200 bg-transparent px-3 py-2.5 font-sans text-sm font-normal text-blue-gray-700 outline outline-0 transition-all placeholder-shown:border placeholder-shown:border-blue-gray-200 placeholder-shown:border-t-blue-gray-200 focus:border-2 focus:border-purple-500 focus:border-t-transparent focus:outline-0 disabled:border-0 disabled:bg-blue-gray-50"
                  placeholder=" "
                />
                <label
                  class="before:content[' '] after:content[' '] pointer-events-none absolute left-0 -top-1.5 flex h-full w-full select-none text-[11px] font-normal leading-tight text-blue-gray-400 transition-all before:pointer-events-none before:mt-[6.5px] before:mr-1 before:box-border before:block before:h-1.5 before:w-2.5 before:rounded-tl-md before:border-t before:border-l before:border-blue-gray-200 before:transition-all after:pointer-events-none after:mt-[6.5px] after:ml-1 after:box-border after:block after:h-1.5 after:w-2.5 after:flex-grow after:rounded-tr-md after:border-t after:border-r after:border-blue-gray-200 after:transition-all peer-placeholder-shown:text-sm peer-placeholder-shown:leading-[3.75] peer-placeholder-shown:text-blue-gray-500 peer-placeholder-shown:before:border-transparent peer-placeholder-shown:after:border-transparent peer-focus:text-[11px] peer-focus:leading-tight peer-focus:text-purple-500 peer-focus:before:border-t-2 peer-focus:before:border-l-2 peer-focus:before:border-purple-500 peer-focus:after:border-t-2 peer-focus:after:border-r-2 peer-focus:after:border-purple-500 peer-disabled:text-transparent peer-disabled:before:border-transparent peer-disabled:after:border-transparent peer-disabled:peer-placeholder-shown:text-blue-gray-500"
                >
                  게시판 이름 입력
                </label>
              </div>
              <button
                class="flex h-10 items-center whitespace-nowrap ml-1 rounded-lg bg-gradient-to-tr from-purple-600 to-purple-400 py-3 px-8 text-center align-middle font-sans text-xs font-bold text-white shadow-md shadow-purple-500/20 transition-all hover:shadow-lg hover:shadow-purple-500/40 active:opacity-[0.85] disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none"
                type="button"
                data-ripple-light="true"
                @click="makeBoard"
              >
                생성
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
