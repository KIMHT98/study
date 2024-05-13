<template>
  <div>
    <h3>검색하기</h3>
    <input type="text" v-model="keyword" />
    <button @click="search">검색</button>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useYoutubeStore } from "@/stores/youtube";

const store = useYoutubeStore();
const keyword = ref("");
const search = function () {
  store.youtubeSearch(keyword.value);
  keyword.value = "";
};
</script>

<style scoped></style>
