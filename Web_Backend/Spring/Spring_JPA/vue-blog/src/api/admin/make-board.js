import { blog } from "../../util/instance-axios";

const control = "/admin/board";

function listCategory(success, fail) {
  blog.get(`${control}/category/list`).then(success).catch(fail);
}

function registerCategory(params, success, fail) {
  blog.post(`${control}/category/create`, JSON.stringify(params)).then(success).catch(fail);
}

function listBoardType(success, fail) {
  blog.get(`${control}/board/type`).then(success).catch(fail);
}

function createBoard(params, success, fail) {
  blog.post(`${control}/board/create`, JSON.stringify(params)).then(success).catch(fail);
}

function listBoardMenus(success, fail) {
  blog.get(`${control}/board/menu`).then(success).catch(fail);
}

export { listCategory, registerCategory, listBoardType, createBoard, listBoardMenus };
