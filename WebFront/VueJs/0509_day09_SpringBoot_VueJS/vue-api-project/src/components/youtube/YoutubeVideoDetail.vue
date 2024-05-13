<template>
  <div v-if="store.selectVideo">
    <h3>영상 상세보기</h3>
    <iframe
      width="560"
      height="315"
      :src="videoURL"
      title="YouTube video player"
      frameborder="0"
      allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
      referrerpolicy="strict-origin-when-cross-origin"
      allowfullscreen
    ></iframe>
  </div>
</template>

<script setup>
import { computed } from "vue";
import { useYoutubeStore } from "@/stores/youtube";
const store = useYoutubeStore();
const videoURL = computed(() => {
  const videoId = store.selectVideo.id.videoId;
  return `https://www.youtube.com/embed/${videoId}`;
});
</script>

<style scoped></style>
