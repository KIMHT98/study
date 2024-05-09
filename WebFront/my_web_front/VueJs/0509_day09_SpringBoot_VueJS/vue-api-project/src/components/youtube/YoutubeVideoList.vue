<template>
  <div>
    <h2>검색 결과</h2>
    <ul>
      <YoutubeVideoListItem
        v-for="video in store.videos"
        :key="video.id.videoId"
        :video="video"
      />
    </ul>
  </div>
</template>

<script setup>
import YoutubeVideoListItem from "@/components/youtube/YoutubeVideoListItem.vue";
import { useYoutubeStore } from "@/stores/youtube";
const store = useYoutubeStore();
</script>

<style scoped></style>
