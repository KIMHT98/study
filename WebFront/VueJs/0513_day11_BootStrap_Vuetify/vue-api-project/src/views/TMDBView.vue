<template>
  <div class="container">
    <div class="text-center">
      <h1 class="my-underline">TMDBView</h1>
    </div>

    <ul class="nav nav-tabs">
      <li class="nav-item">
        <RouterLink
          :class="popular"
          class="nav-link"
          :to="{ name: 'tmdb-popular' }"
          >인기 순위</RouterLink
        >
      </li>
      <li class="nav-item">
        <RouterLink :class="top" class="nav-link" :to="{ name: 'tmdb-toprank' }"
          >역대 순위</RouterLink
        >
      </li>
    </ul>
    <hr />
    <router-view></router-view>
  </div>
</template>

<script setup>
import { computed } from "vue";
import { useRoute } from "vue-router";
const route = useRoute();

const popular = computed(() => {
  if (route.name === "tmdb-popular") return { active: true };
});
const top = computed(() => {
  if (route.name === "tmdb-toprank") return { active: true };
});
</script>

<style scoped>
.my-underline {
  background: linear-gradient(to top, yellow 20%, transparent 50%);
  display: inline-block;
  /* width: 50%; */
}
</style>
