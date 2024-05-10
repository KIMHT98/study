<template>
  <div>
    <h1>YoutubeView야 반갑다!</h1>
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
