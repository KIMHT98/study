<template>
  <li @click="clickVideo">
    <img :src="video.snippet.thumbnails.default.url" />
    <p>{{ video.snippet.title }}</p>
  </li>
</template>

<script setup>
import { useYoutubeStore } from "@/stores/youtube";
const store = useYoutubeStore();

const props = defineProps({
  video: Object,
});
console.log(props);
const clickVideo = function () {
  store.clickVideo(props.video);
};
</script>

<style scoped></style>
