<template>
  <div class="container">
    <h2 class="text-center" v-if="store.videos.length === 0">
      검색 결과가 없습니다.
    </h2>
    <div id="youtubeCarousel" class="carousel slide">
      <div class="carousel-inner">
        <YoutubeVideoListItem
          v-for="(video, index) in store.videos"
          :key="video.id.videoId"
          :video="video"
          :index="index"
          :current="current"
        />
      </div>
      <button
        class="carousel-control-prev"
        type="button"
        data-bs-target="#youtubeCarousel"
        data-bs-slide="prev"
        @click="prev"
      >
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button
        class="carousel-control-next"
        type="button"
        data-bs-target="#youtubeCarousel"
        data-bs-slide="next"
        @click="next"
      >
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
  </div>
</template>

<script setup>
import YoutubeVideoListItem from "@/components/youtube/YoutubeVideoListItem.vue";
import { useYoutubeStore } from "@/stores/youtube";
import { ref } from "vue";
const store = useYoutubeStore();
const current = ref(0);
const next = function () {
  current.value = (current.value + 1) % 10;
};
const prev = function () {
  current.value = (current.value + 9) % 10;
};
</script>

<style scoped></style>
