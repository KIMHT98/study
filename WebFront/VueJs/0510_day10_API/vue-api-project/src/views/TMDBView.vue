<template>
  <div>
    <h1>TMDBView</h1>
    <RouterLink :to="{ name: 'tmdb-popular' }">인기 순위</RouterLink>
    <RouterLink :to="{ name: 'tmdb-toprank' }">역대 순위</RouterLink>
    <hr />
    <router-view></router-view>
  </div>
</template>

<script setup></script>

<style scoped></style>
