<script setup>
import { RouterView } from "vue-router";

import BoardMenuList from "../components/boards/BoardMenuList.vue";
</script>

<template>
  <div class="flex xl:pt-[4.5rem]">
    <board-menu-list></board-menu-list>
    <router-view></router-view>
  </div>
</template>

<style scoped></style>
