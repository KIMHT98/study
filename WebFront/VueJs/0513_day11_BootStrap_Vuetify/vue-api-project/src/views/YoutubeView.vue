<template>
  <div class="container">
    <h1 class="text-center">
      <i class="bi bi-youtube" style="color: red"></i> Youtube
    </h1>
    <YoutubeVideoSearch />
    <hr />
    <YoutubeVideoDetail />
    <hr />
    <YoutubeVideoList />
  </div>
</template>

<script setup>
import YoutubeVideoSearch from "@/components/youtube/YoutubeVideoSearch.vue";
import YoutubeVideoList from "@/components/youtube/YoutubeVideoList.vue";
import YoutubeVideoDetail from "@/components/youtube/YoutubeVideoDetail.vue";
</script>

<style scoped></style>
