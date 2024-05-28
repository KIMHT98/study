<script setup>
import { ref } from "vue"
import { useRouter, useRoute, RouterLink } from "vue-router"
import { loginUser } from "@/api/user"

import Swal from "sweetalert2"
// import { IconKakaoTalk } from "../icons/IconKakaoTalk.vue";

const router = useRouter()
const route = useRoute()

const loginInfo = ref({
  userId: null,
  password: null,
})

const login = () => {
  loginUser(
    loginInfo.value,
    (response) => {
      console.log(response)
      if (response.status == 200) {
        Swal.fire("로그인성공!!!", response.data.userName + "님 안녕하세요", "success")
        router.push({
          name: "article-list",
          params: { bcode: 6 },
        })
      } else if (response.status == 204) {
        Swal.fire("로그인실패!!!", "아이디 또는 비밀번호 확인 후 로그인해주세요", "error")
        loginInfo.value.userId = ""
        loginInfo.value.password = ""
      }
    },
    (error) => {
      console.error(error)
    }
  )
}
</script>

<template>
  <div id="div" class="min-h-screen bg-no-repeat bg-cover bg-center">
    <div class="flex justify-center">
      <div class="min-h-screen w-2/5 flex justify-center items-center">
        <div class="container flex flex-col mx-auto rounded-lg pt-12 my-5">
          <div
            class="flex justify-center w-full h-full my-auto xl:gap-14 lg:justify-normal md:gap-5 draggable"
          >
            <div class="flex items-center justify-center w-full lg:p-12">
              <div class="flex items-center xl:p-10">
                <div
                  class="relative flex flex-col w-96 rounded-xl bg-white bg-clip-border text-gray-700 shadow-md"
                >
                  <div
                    class="relative mx-4 -mt-6 mb-4 grid h-28 place-items-center overflow-hidden rounded-xl bg-gradient-to-tr from-slate-400 to-slate-300 bg-clip-border text-white shadow-lg shadow-slate-400/40"
                  >
                    <h3
                      class="block font-sans text-3xl font-semibold leading-snug tracking-normal text-white antialiased"
                    >
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        class="w-12 h-12"
                        style="display: inline"
                        fill="none"
                        viewBox="0 0 24 24"
                        stroke="currentColor"
                        stroke-width="2"
                      >
                        <path
                          stroke-linecap="round"
                          stroke-linejoin="round"
                          d="M12 15v2m-6 4h12a2 2 0 002-2v-6a2 2 0 00-2-2H6a2 2 0 00-2 2v6a2 2 0 002 2zm10-10V7a4 4 0 00-8 0v4h8z"
                        />
                      </svg>
                      로그인
                    </h3>
                  </div>
                  <div class="flex flex-col gap-4 p-6">
                    <a
                      class="flex items-center justify-center w-full py-4 text-sm font-medium transition duration-300 rounded-lg text-gray-900 bg-yellow-400 hover:bg-yellow-500 focus:ring-4 focus:ring-yellow-300"
                    >
                      <img src="@/assets/kakaotalk.png" class="w-5 h-5 mr-2" />
                      카카오 로그인
                    </a>
                    <a
                      class="flex items-center justify-center w-full py-4 text-sm font-medium transition duration-300 rounded-lg text-gray-900 bg-green-500 hover:bg-green-600 focus:ring-4 focus:ring-green-300"
                    >
                      <img src="@/assets/naver.png" class="w-4 h-4 mr-2" />
                      네이버 로그인
                    </a>
                    <div class="flex items-center mb-3">
                      <hr class="h-0 border-b border-solid border-gray-500 grow" />
                      <p class="mx-4 text-gray-600">or</p>
                      <hr class="h-0 border-b border-solid border-gray-500 grow" />
                    </div>
                    <div class="relative h-11 w-full min-w-[200px]">
                      <input
                        class="peer h-full w-full rounded-md border border-blue-gray-200 border-t-transparent bg-transparent px-3 py-3 font-sans text-sm font-normal text-blue-gray-700 outline outline-0 transition-all placeholder-shown:border placeholder-shown:border-blue-gray-200 placeholder-shown:border-t-blue-gray-200 focus:border-2 focus:border-pink-500 focus:border-t-transparent focus:outline-0 disabled:border-0 disabled:bg-blue-gray-50"
                        v-model="loginInfo.userId"
                        placeHolder=" "
                      />
                      <label
                        class="before:content[' '] after:content[' '] pointer-events-none absolute left-0 -top-1.5 flex h-full w-full select-none text-[11px] font-normal leading-tight text-blue-gray-400 transition-all before:pointer-events-none before:mt-[6.5px] before:mr-1 before:box-border before:block before:h-1.5 before:w-2.5 before:rounded-tl-md before:border-t before:border-l before:border-blue-gray-200 before:transition-all after:pointer-events-none after:mt-[6.5px] after:ml-1 after:box-border after:block after:h-1.5 after:w-2.5 after:flex-grow after:rounded-tr-md after:border-t after:border-r after:border-blue-gray-200 after:transition-all peer-placeholder-shown:text-sm peer-placeholder-shown:leading-[4.1] peer-placeholder-shown:text-blue-gray-500 peer-placeholder-shown:before:border-transparent peer-placeholder-shown:after:border-transparent peer-focus:text-[11px] peer-focus:leading-tight peer-focus:text-pink-500 peer-focus:before:border-t-2 peer-focus:before:border-l-2 peer-focus:before:!border-pink-500 peer-focus:after:border-t-2 peer-focus:after:border-r-2 peer-focus:after:!border-pink-500 peer-disabled:text-transparent peer-disabled:before:border-transparent peer-disabled:after:border-transparent peer-disabled:peer-placeholder-shown:text-blue-gray-500"
                      >
                        아이디...
                      </label>
                    </div>
                    <div class="relative h-11 w-full min-w-[200px]">
                      <input
                        class="peer h-full w-full rounded-md border border-blue-gray-200 border-t-transparent bg-transparent px-3 py-3 font-sans text-sm font-normal text-blue-gray-700 outline outline-0 transition-all placeholder-shown:border placeholder-shown:border-blue-gray-200 placeholder-shown:border-t-blue-gray-200 focus:border-2 focus:border-pink-500 focus:border-t-transparent focus:outline-0 disabled:border-0 disabled:bg-blue-gray-50"
                        type="password"
                        v-model="loginInfo.password"
                        placeHolder=" "
                      />
                      <label
                        class="before:content[' '] after:content[' '] pointer-events-none absolute left-0 -top-1.5 flex h-full w-full select-none text-[11px] font-normal leading-tight text-blue-gray-400 transition-all before:pointer-events-none before:mt-[6.5px] before:mr-1 before:box-border before:block before:h-1.5 before:w-2.5 before:rounded-tl-md before:border-t before:border-l before:border-blue-gray-200 before:transition-all after:pointer-events-none after:mt-[6.5px] after:ml-1 after:box-border after:block after:h-1.5 after:w-2.5 after:flex-grow after:rounded-tr-md after:border-t after:border-r after:border-blue-gray-200 after:transition-all peer-placeholder-shown:text-sm peer-placeholder-shown:leading-[4.1] peer-placeholder-shown:text-blue-gray-500 peer-placeholder-shown:before:border-transparent peer-placeholder-shown:after:border-transparent peer-focus:text-[11px] peer-focus:leading-tight peer-focus:text-pink-500 peer-focus:before:border-t-2 peer-focus:before:border-l-2 peer-focus:before:!border-pink-500 peer-focus:after:border-t-2 peer-focus:after:border-r-2 peer-focus:after:!border-pink-500 peer-disabled:text-transparent peer-disabled:before:border-transparent peer-disabled:after:border-transparent peer-disabled:peer-placeholder-shown:text-blue-gray-500"
                      >
                        비밀번호...
                      </label>
                    </div>
                    <div class="-ml-2.5 text-end">
                      <div class="inline-flex items-center">
                        <label
                          class="relative flex cursor-pointer items-center rounded-full p-3"
                          for="checkbox"
                          data-ripple-dark="true"
                        >
                          <input
                            type="checkbox"
                            class="before:content[''] peer relative h-5 w-5 cursor-pointer appearance-none rounded-md border border-blue-gray-200 transition-all before:absolute before:top-2/4 before:left-2/4 before:block before:h-12 before:w-12 before:-translate-y-2/4 before:-translate-x-2/4 before:rounded-full before:bg-blue-gray-500 before:opacity-0 before:transition-opacity checked:border-pink-500 checked:bg-pink-500 checked:before:bg-pink-500 hover:before:opacity-10"
                            id="checkbox"
                          />
                          <span
                            class="pointer-events-none absolute top-2/4 left-2/4 -translate-y-2/4 -translate-x-2/4 text-white opacity-0 transition-opacity peer-checked:opacity-100"
                          >
                            <svg
                              xmlns="http://www.w3.org/2000/svg"
                              class="h-3.5 w-3.5"
                              viewBox="0 0 20 20"
                              fill="currentColor"
                              stroke="currentColor"
                              stroke-width="1"
                            >
                              <path
                                fill-rule="evenodd"
                                d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z"
                                clip-rule="evenodd"
                              ></path>
                            </svg>
                          </span>
                        </label>
                        <label
                          class="mt-px cursor-pointer select-none font-light text-gray-700"
                          for="checkbox"
                        >
                          아이디저장
                        </label>
                      </div>
                    </div>
                  </div>
                  <div class="p-6 pt-0">
                    <button
                      class="block w-full select-none rounded-lg bg-gradient-to-tr from-slate-400 to-slate-300 py-3 px-6 text-center align-middle font-sans text-xs font-bold uppercase text-white shadow-md shadow-slate-400/20 transition-all hover:shadow-lg hover:shadow-slate-400/40 active:opacity-[0.85] disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none"
                      type="button"
                      data-ripple-light="true"
                      @click="login"
                    >
                      로그인
                    </button>
                    <p
                      class="mt-6 flex justify-center font-sans text-sm font-light leading-normal text-inherit antialiased"
                    >
                      아직 회원이 아니신가요?
                      <router-link
                        class="ml-1 block font-sans text-sm font-bold leading-normal text-slate-500 antialiased"
                        :to="{ name: 'user-join' }"
                      >
                        회원가입
                      </router-link>
                    </p>
                  </div>
                </div>
                <!-- <form class="flex flex-col w-full h-full pb-6 text-center bg-white rounded-3xl">
                  <h3 class="mb-3 text-4xl font-extrabold text-gray-600">
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      class="w-12 h-12"
                      style="display: inline"
                      fill="none"
                      viewBox="0 0 24 24"
                      stroke="currentColor"
                      stroke-width="2"
                    >
                      <path
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        d="M12 15v2m-6 4h12a2 2 0 002-2v-6a2 2 0 00-2-2H6a2 2 0 00-2 2v6a2 2 0 002 2zm10-10V7a4 4 0 00-8 0v4h8z"
                      />
                    </svg>
                    로그인
                  </h3>
                  <a
                    class="flex items-center justify-center w-full py-4 mb-6 text-sm font-medium transition duration-300 rounded-2xl text-gray-900 bg-yellow-300 hover:bg-yellow-400 focus:ring-4 focus:ring-yellow-200"
                  >
                    <img src="@/assets/kakaotalk.png" class="w-5 h-5 mr-2" />
                    카카오 로그인
                  </a>
                  <a
                    class="flex items-center justify-center w-full py-4 mb-6 text-sm font-medium transition duration-300 rounded-2xl text-gray-900 bg-green-500 hover:bg-green-600 focus:ring-4 focus:ring-green-300"
                  >
                    <img src="@/assets/naver.png" class="w-4 h-4 mr-2" />
                    네이버 로그인
                  </a>
                  <div class="flex items-center mb-3">
                    <hr class="h-0 border-b border-solid border-gray-500 grow" />
                    <p class="mx-4 text-gray-600">or</p>
                    <hr class="h-0 border-b border-solid border-gray-500 grow" />
                  </div>
                  <label for="id" class="mb-2 text-sm text-start text-gray-900">Id*</label>
                  <input
                    id="id"
                    type="text"
                    placeholder="ssafy or ssafy@ssafy.com"
                    class="flex items-center w-full px-5 py-4 mr-2 text-sm font-medium outline-none focus:bg-gray-300 mb-7 placeholder:text-gray-700 bg-gray-200 text-gray-900 rounded-2xl"
                  />
                  <label for="password" class="mb-2 text-sm text-start text-gray-900"
                    >Password*</label
                  >
                  <input
                    id="password"
                    type="password"
                    placeholder="비밀번호..."
                    class="flex items-center w-full px-5 py-4 mb-5 mr-2 text-sm font-medium outline-none focus:bg-gray-300 placeholder:text-gray-700 bg-gray-200 text-gray-900 rounded-2xl"
                  />
                  <div class="flex flex-row justify-between mb-8">
                    <label
                      class="relative inline-flex items-center mr-3 cursor-pointer select-none"
                    >
                      <input type="checkbox" checked value="" class="sr-only peer" />
                      <div
                        class="w-5 h-5 bg-white border-2 rounded-sm border-gray-500 peer peer-checked:border-0 peer-checked:bg-purple-400"
                      >
                        <img
                          class=""
                          src="https://raw.githubusercontent.com/Loopple/loopple-public-assets/main/motion-tailwind/img/icons/check.png"
                          alt="tick"
                        />
                      </div>
                      <span class="ml-3 text-sm font-normal text-gray-900">아이디 저장</span>
                    </label>
                    <a href="javascript:void(0)" class="mr-4 text-sm font-medium text-purple-400">
                      비밀번호찾기
                    </a>
                  </div>
                  <button
                    class="w-full px-6 py-5 mb-5 text-sm font-bold leading-none text-white transition duration-300 md:w-96 rounded-2xl hover:bg-purple-500 focus:ring-4 focus:ring-purple-100 bg-purple-400"
                  >
                    Log In
                  </button>
                  <p class="text-sm leading-relaxed text-gray-900">
                    아직 가입 전 인가요?
                    <a href="javascript:void(0)" class="font-bold text-gray-700">계정 만들기</a>
                  </p>
                </form> -->
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
#div {
  width: 100%;
  height: 100%;
  text-align: center;
  position: relative;
  z-index: 1;
}

#div::after {
  background-image: url("../../assets/login_side.png");
  background-repeat: no-repeat;
  background-position: center center;
  /* filter: blur(3px); */
  /* backdrop-filter: blur(10px); */

  width: 100%;
  height: 100%;
  content: "";
  /* background: url("./images/sunrise.jpg"); */
  position: absolute;
  top: 0;
  left: 0;
  z-index: -1;
  opacity: 0.5;
}
</style>
