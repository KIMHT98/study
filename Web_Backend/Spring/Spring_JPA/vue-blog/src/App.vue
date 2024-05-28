<script setup>
import { RouterView } from "vue-router";
import TheHeader from "./components/layout/TheHeader.vue";
import TheFooter from "./components/layout/TheFooter.vue";
</script>

<template>
  <the-header></the-header>
  <router-view></router-view>
  <the-footer></the-footer>
</template>

<style scoped></style>
