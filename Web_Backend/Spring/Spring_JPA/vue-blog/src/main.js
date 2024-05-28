import "./assets/tailwind.css";

import { createApp } from "vue";
import { createPinia } from "pinia";

import App from "./App.vue";
import router from "./router";
import "material-icons/iconfont/material-icons.css";

// Vue Quill Editor
// https://vueup.github.io/vue-quill/
import { QuillEditor } from "@vueup/vue-quill";
import "@vueup/vue-quill/dist/vue-quill.snow.css";

// Sweetalert2
// https://sweetalert2.github.io/
import VueSweetalert2 from "vue-sweetalert2";
import "sweetalert2/dist/sweetalert2.min.css";

const app = createApp(App);

app.use(createPinia());
app.use(router);
app.use(VueSweetalert2);

app.component("QuillEditor", QuillEditor);

app.mount("#app");
