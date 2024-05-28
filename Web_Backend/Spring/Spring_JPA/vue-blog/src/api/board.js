import { blog } from "@/util/instance-axios"

function listArticle(control, params, success, fail) {
  blog.get(`/${control}`, { params }).then(success).catch(fail)
}

function registerArticle(control, article, success, fail) {
  blog.post(`/${control}`, JSON.stringify(article)).then(success).catch(fail)
}

function replyArticle(control, article, success, fail) {
  blog.post(`/${control}/reply`, JSON.stringify(article)).then(success).catch(fail)
}

function detailArticle(control, articleno, success, fail) {
  blog.get(`/${control}/${articleno}`).then(success).catch(fail)
}

export { listArticle, registerArticle, replyArticle, detailArticle }
