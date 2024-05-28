<script setup>
import { ref, watch } from "vue"
import { useRouter, useRoute } from "vue-router"
import { idCheck, joinUser } from "@/api/user"

import Swal from "sweetalert2"
// import { IconKakaoTalk } from "../icons/IconKakaoTalk.vue";

const router = useRouter()
const route = useRoute()

const userInfo = ref({
  userId: null,
  userName: null,
  password: null,
  email: null,
})

const idChecked = ref(false)
const idCheckedMsg = ref("")
const idCheckedMsgColor = ref("blue-gray")
watch(
  () => userInfo.value.userId,
  (value) => {
    let len = value.length
    if (len < 5 || len > 16) {
      idChecked.value = false
      idCheckedMsg.value = "아이디는 5자 이상 16자 이하입니다."
      idCheckedMsgColor.value = "blue-gray"
    } else {
      idCheck(
        userInfo.value.userId,
        ({ data }) => {
          if (data === 0) {
            idChecked.value = true
            idCheckedMsg.value = `${userInfo.value.userId} 아이디는 사용할 수 있습니다.`
            idCheckedMsgColor.value = "cyan"
          } else {
            idChecked.value = false
            idCheckedMsg.value = `${userInfo.value.userId}는 이미 사용 중입니다.`
            idCheckedMsgColor.value = "pink"
          }
        },
        (error) => {
          console.error(error)
        }
      )
    }
  }
)

const registUser = () => {
  let msg = "회원가입 처리중 문제 발생했습니다."
  joinUser(
    userInfo.value,
    (response) => {
      if (response.status == 201)
        msg = "회원가입을 축하합니다.\n로그인 후 서비스 이용이 가능합니다."

      Swal.fire("회원가입성공!!!", msg, "success")
      router.push({
        name: "user-login",
      })
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
      <div class="min-h-screen w-full flex justify-center items-center">
        <div class="container flex flex-col mx-auto rounded-lg pt-12 my-5">
          <div
            class="flex justify-center w-full h-full my-auto xl:gap-14 lg:justify-normal md:gap-5 draggable"
          >
            <div class="flex items-center justify-center w-full lg:p-12">
              <div class="flex items-center justify-center w-full xl:p-10">
                <div
                  class="relative flex flex-col w-1/2 rounded-xl bg-white bg-clip-border text-gray-700 shadow-md"
                >
                  <div
                    class="relative mx-4 -mt-6 mb-4 grid h-28 place-items-center overflow-hidden rounded-xl bg-gradient-to-tr from-brown-300 to-brown-200 bg-clip-border text-white shadow-lg shadow-brown-300/40"
                  >
                    <h3
                      class="block font-sans text-3xl font-semibold leading-snug tracking-normal text-slate-50 antialiased"
                    >
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        class="w-9 h-9"
                        style="display: inline"
                        viewBox="0 0 448 512"
                        fill="white"
                        stroke="currentColor"
                        stroke-width="2"
                      >
                        <path
                          stroke-linecap="round"
                          stroke-linejoin="round"
                          d="M304 128a80 80 0 1 0 -160 0 80 80 0 1 0 160 0zM96 128a128 128 0 1 1 256 0A128 128 0 1 1 96 128zM49.3 464H398.7c-8.9-63.3-63.3-112-129-112H178.3c-65.7 0-120.1 48.7-129 112zM0 482.3C0 383.8 79.8 304 178.3 304h91.4C368.2 304 448 383.8 448 482.3c0 16.4-13.3 29.7-29.7 29.7H29.7C13.3 512 0 498.7 0 482.3z"
                        />
                      </svg>
                      회원가입
                    </h3>
                  </div>
                  <div class="flex flex-col gap-4 p-6">
                    <div class="relative h-11 w-full min-w-[200px]">
                      <input
                        class="peer h-full w-full rounded-md border border-blue-gray-200 border-t-transparent bg-transparent px-3 py-3 font-sans text-sm font-normal text-blue-gray-700 outline outline-0 transition-all placeholder-shown:border placeholder-shown:border-blue-gray-200 placeholder-shown:border-t-blue-gray-200 focus:border-2 focus:border-pink-500 focus:border-t-transparent focus:outline-0 disabled:border-0 disabled:bg-blue-gray-50"
                        v-model="userInfo.userName"
                        placeHolder=" "
                      />
                      <label
                        class="before:content[' '] after:content[' '] pointer-events-none absolute left-0 -top-1.5 flex h-full w-full select-none text-[11px] font-normal leading-tight text-blue-gray-400 transition-all before:pointer-events-none before:mt-[6.5px] before:mr-1 before:box-border before:block before:h-1.5 before:w-2.5 before:rounded-tl-md before:border-t before:border-l before:border-blue-gray-200 before:transition-all after:pointer-events-none after:mt-[6.5px] after:ml-1 after:box-border after:block after:h-1.5 after:w-2.5 after:flex-grow after:rounded-tr-md after:border-t after:border-r after:border-blue-gray-200 after:transition-all peer-placeholder-shown:text-sm peer-placeholder-shown:leading-[4.1] peer-placeholder-shown:text-blue-gray-500 peer-placeholder-shown:before:border-transparent peer-placeholder-shown:after:border-transparent peer-focus:text-[11px] peer-focus:leading-tight peer-focus:text-pink-500 peer-focus:before:border-t-2 peer-focus:before:border-l-2 peer-focus:before:!border-pink-500 peer-focus:after:border-t-2 peer-focus:after:border-r-2 peer-focus:after:!border-pink-500 peer-disabled:text-transparent peer-disabled:before:border-transparent peer-disabled:after:border-transparent peer-disabled:peer-placeholder-shown:text-blue-gray-500"
                      >
                        이름...
                      </label>
                    </div>
                    <div class="relative h-11 w-full min-w-[200px]">
                      <input
                        class="peer h-full w-full rounded-md border border-blue-gray-200 border-t-transparent bg-transparent px-3 py-3 font-sans text-sm font-normal text-blue-gray-700 outline outline-0 transition-all placeholder-shown:border placeholder-shown:border-blue-gray-200 placeholder-shown:border-t-blue-gray-200 focus:border-2 focus:border-pink-500 focus:border-t-transparent focus:outline-0 disabled:border-0 disabled:bg-blue-gray-50"
                        v-model="userInfo.userId"
                        placeHolder=" "
                      />
                      <label
                        class="before:content[' '] after:content[' '] pointer-events-none absolute left-0 -top-1.5 flex h-full w-full select-none text-[11px] font-normal leading-tight text-blue-gray-400 transition-all before:pointer-events-none before:mt-[6.5px] before:mr-1 before:box-border before:block before:h-1.5 before:w-2.5 before:rounded-tl-md before:border-t before:border-l before:border-blue-gray-200 before:transition-all after:pointer-events-none after:mt-[6.5px] after:ml-1 after:box-border after:block after:h-1.5 after:w-2.5 after:flex-grow after:rounded-tr-md after:border-t after:border-r after:border-blue-gray-200 after:transition-all peer-placeholder-shown:text-sm peer-placeholder-shown:leading-[4.1] peer-placeholder-shown:text-blue-gray-500 peer-placeholder-shown:before:border-transparent peer-placeholder-shown:after:border-transparent peer-focus:text-[11px] peer-focus:leading-tight peer-focus:text-pink-500 peer-focus:before:border-t-2 peer-focus:before:border-l-2 peer-focus:before:!border-pink-500 peer-focus:after:border-t-2 peer-focus:after:border-r-2 peer-focus:after:!border-pink-500 peer-disabled:text-transparent peer-disabled:before:border-transparent peer-disabled:after:border-transparent peer-disabled:peer-placeholder-shown:text-blue-gray-500"
                      >
                        아이디...
                      </label>
                    </div>
                    <!-- <div
                      class="font-regular text-start relative block w-full rounded-lg border border-blue-gray-600 bg-blue-gray-50 p-3 leading-3 text-blue-gray-600 opacity-100"
                      role="alert"
                    >
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        class="w-4 h-4"
                        style="display: inline"
                        viewBox="0 0 192 512"
                        fill="#546e7a"
                        stroke="currentColor"
                        stroke-width="2"
                      >
                        <path
                          d="M48 80a48 48 0 1 1 96 0A48 48 0 1 1 48 80zM0 224c0-17.7 14.3-32 32-32H96c17.7 0 32 14.3 32 32V448h32c17.7 0 32 14.3 32 32s-14.3 32-32 32H32c-17.7 0-32-14.3-32-32s14.3-32 32-32H64V256H32c-17.7 0-32-14.3-32-32z"
                        />
                      </svg>
                      아이디는 5자이상 16자이하입니다.
                    </div>

                    <div
                      class="font-regular text-start relative block w-full rounded-lg border border-cyan-600 bg-cyan-50 p-3 leading-3 text-cyan-600 opacity-100"
                      role="alert"
                    >
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        class="w-4 h-4"
                        style="display: inline"
                        viewBox="0 0 448 512"
                        fill="#00acc1"
                        stroke="currentColor"
                        stroke-width="2"
                      >
                        <path
                          d="M438.6 105.4c12.5 12.5 12.5 32.8 0 45.3l-256 256c-12.5 12.5-32.8 12.5-45.3 0l-128-128c-12.5-12.5-12.5-32.8 0-45.3s32.8-12.5 45.3 0L160 338.7 393.4 105.4c12.5-12.5 32.8-12.5 45.3 0z"
                        />
                      </svg>
                      xxxx는 사용할 수 있습니다.
                    </div>

                    <div
                      class="font-regular text-start relative block w-full rounded-lg border border-pink-600 bg-pink-50 p-3 leading-3 text-pink-600 opacity-100"
                      role="alert"
                    >
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        class="w-4 h-4"
                        style="display: inline"
                        viewBox="0 0 384 512"
                        fill="#d81b60"
                        stroke="currentColor"
                        stroke-width="2"
                      >
                        <path
                          d="M342.6 150.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L192 210.7 86.6 105.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3L146.7 256 41.4 361.4c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0L192 301.3 297.4 406.6c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L237.3 256 342.6 150.6z"
                        />
                      </svg>
                      xxxx는 사용할 수 없습니다.
                    </div> -->
                    <div
                      v-if="userInfo.userId"
                      :class="`font-regular text-start relative block w-full rounded-lg border border-${idCheckedMsgColor}-600 bg-${idCheckedMsgColor}-50 p-3 leading-3 text-${idCheckedMsgColor}-600 opacity-100`"
                      role="alert"
                    >
                      <svg
                        v-show="idCheckedMsgColor === 'blue-gray'"
                        xmlns="http://www.w3.org/2000/svg"
                        class="w-4 h-4"
                        style="display: inline"
                        viewBox="0 0 192 512"
                        fill="#546e7a"
                        stroke="currentColor"
                        stroke-width="2"
                      >
                        <path
                          d="M48 80a48 48 0 1 1 96 0A48 48 0 1 1 48 80zM0 224c0-17.7 14.3-32 32-32H96c17.7 0 32 14.3 32 32V448h32c17.7 0 32 14.3 32 32s-14.3 32-32 32H32c-17.7 0-32-14.3-32-32s14.3-32 32-32H64V256H32c-17.7 0-32-14.3-32-32z"
                        />
                      </svg>
                      <svg
                        v-show="idCheckedMsgColor === 'cyan'"
                        xmlns="http://www.w3.org/2000/svg"
                        class="w-4 h-4"
                        style="display: inline"
                        viewBox="0 0 448 512"
                        fill="#00acc1"
                        stroke="currentColor"
                        stroke-width="2"
                      >
                        <path
                          d="M438.6 105.4c12.5 12.5 12.5 32.8 0 45.3l-256 256c-12.5 12.5-32.8 12.5-45.3 0l-128-128c-12.5-12.5-12.5-32.8 0-45.3s32.8-12.5 45.3 0L160 338.7 393.4 105.4c12.5-12.5 32.8-12.5 45.3 0z"
                        />
                      </svg>
                      <svg
                        v-show="idCheckedMsgColor === 'pink'"
                        xmlns="http://www.w3.org/2000/svg"
                        class="w-4 h-4"
                        style="display: inline"
                        viewBox="0 0 384 512"
                        fill="#d81b60"
                        stroke="currentColor"
                        stroke-width="2"
                      >
                        <path
                          d="M342.6 150.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L192 210.7 86.6 105.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3L146.7 256 41.4 361.4c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0L192 301.3 297.4 406.6c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L237.3 256 342.6 150.6z"
                        />
                      </svg>
                      {{ idCheckedMsg }}
                    </div>

                    <div class="relative h-11 w-full min-w-[200px]">
                      <input
                        class="peer h-full w-full rounded-md border border-blue-gray-200 border-t-transparent bg-transparent px-3 py-3 font-sans text-sm font-normal text-blue-gray-700 outline outline-0 transition-all placeholder-shown:border placeholder-shown:border-blue-gray-200 placeholder-shown:border-t-blue-gray-200 focus:border-2 focus:border-pink-500 focus:border-t-transparent focus:outline-0 disabled:border-0 disabled:bg-blue-gray-50"
                        v-model="userInfo.password"
                        type="password"
                        placeHolder=" "
                      />
                      <label
                        class="before:content[' '] after:content[' '] pointer-events-none absolute left-0 -top-1.5 flex h-full w-full select-none text-[11px] font-normal leading-tight text-blue-gray-400 transition-all before:pointer-events-none before:mt-[6.5px] before:mr-1 before:box-border before:block before:h-1.5 before:w-2.5 before:rounded-tl-md before:border-t before:border-l before:border-blue-gray-200 before:transition-all after:pointer-events-none after:mt-[6.5px] after:ml-1 after:box-border after:block after:h-1.5 after:w-2.5 after:flex-grow after:rounded-tr-md after:border-t after:border-r after:border-blue-gray-200 after:transition-all peer-placeholder-shown:text-sm peer-placeholder-shown:leading-[4.1] peer-placeholder-shown:text-blue-gray-500 peer-placeholder-shown:before:border-transparent peer-placeholder-shown:after:border-transparent peer-focus:text-[11px] peer-focus:leading-tight peer-focus:text-pink-500 peer-focus:before:border-t-2 peer-focus:before:border-l-2 peer-focus:before:!border-pink-500 peer-focus:after:border-t-2 peer-focus:after:border-r-2 peer-focus:after:!border-pink-500 peer-disabled:text-transparent peer-disabled:before:border-transparent peer-disabled:after:border-transparent peer-disabled:peer-placeholder-shown:text-blue-gray-500"
                      >
                        비밀번호...
                      </label>
                    </div>
                    <div class="relative h-11 w-full min-w-[200px]">
                      <input
                        class="peer h-full w-full rounded-md border border-blue-gray-200 border-t-transparent bg-transparent px-3 py-3 font-sans text-sm font-normal text-blue-gray-700 outline outline-0 transition-all placeholder-shown:border placeholder-shown:border-blue-gray-200 placeholder-shown:border-t-blue-gray-200 focus:border-2 focus:border-pink-500 focus:border-t-transparent focus:outline-0 disabled:border-0 disabled:bg-blue-gray-50"
                        v-model="userInfo.email"
                        placeHolder=" "
                      />
                      <label
                        class="before:content[' '] after:content[' '] pointer-events-none absolute left-0 -top-1.5 flex h-full w-full select-none text-[11px] font-normal leading-tight text-blue-gray-400 transition-all before:pointer-events-none before:mt-[6.5px] before:mr-1 before:box-border before:block before:h-1.5 before:w-2.5 before:rounded-tl-md before:border-t before:border-l before:border-blue-gray-200 before:transition-all after:pointer-events-none after:mt-[6.5px] after:ml-1 after:box-border after:block after:h-1.5 after:w-2.5 after:flex-grow after:rounded-tr-md after:border-t after:border-r after:border-blue-gray-200 after:transition-all peer-placeholder-shown:text-sm peer-placeholder-shown:leading-[4.1] peer-placeholder-shown:text-blue-gray-500 peer-placeholder-shown:before:border-transparent peer-placeholder-shown:after:border-transparent peer-focus:text-[11px] peer-focus:leading-tight peer-focus:text-pink-500 peer-focus:before:border-t-2 peer-focus:before:border-l-2 peer-focus:before:!border-pink-500 peer-focus:after:border-t-2 peer-focus:after:border-r-2 peer-focus:after:!border-pink-500 peer-disabled:text-transparent peer-disabled:before:border-transparent peer-disabled:after:border-transparent peer-disabled:peer-placeholder-shown:text-blue-gray-500"
                      >
                        이메일...
                      </label>
                    </div>
                  </div>
                  <div class="p-6 pt-0 columns-2">
                    <button
                      class="block w-full select-none rounded-lg bg-gradient-to-tr from-brown-300 to-brown-200 py-3 px-6 text-center align-middle font-sans text-xs font-bold uppercase text-white shadow-md shadow-brown-300/20 transition-all hover:shadow-lg hover:shadow-brown-300/40 active:opacity-[0.85] disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none"
                      type="button"
                      data-ripple-light="true"
                      :disabled="!idChecked"
                      @click="registUser"
                    >
                      회원가입
                    </button>
                    <button
                      class="block w-full select-none rounded-lg bg-gradient-to-tr from-slate-400 to-slate-300 py-3 px-6 text-center align-middle font-sans text-xs font-bold uppercase text-white shadow-md shadow-slate-400/20 transition-all hover:shadow-lg hover:shadow-slate-400/40 active:opacity-[0.85] disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none"
                      type="button"
                      data-ripple-light="true"
                      @click="router.push({ name: 'user-login' })"
                    >
                      로그인
                    </button>
                  </div>
                </div>
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
