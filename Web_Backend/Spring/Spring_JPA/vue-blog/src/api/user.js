import { user } from "@/util/instance-axios"

function idCheck(params, success, fail) {
  user.get(`/user/${params}`).then(success).catch(fail)
}

function joinUser(userInfo, success, fail) {
  user.post(`/user`, JSON.stringify(userInfo)).then(success).catch(fail)
}

function loginUser(loginInfo, success, fail) {
  user.post(`/user/login`, JSON.stringify(loginInfo)).then(success).catch(fail)
}

export { idCheck, joinUser, loginUser }
