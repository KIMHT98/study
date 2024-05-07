<script setup>
import { useCounterStore } from "@/stores/counter";

const store = useCounterStore();

console.log(store);
console.log(store.count);
console.log(store.doubleCount);
</script>

<template>
  <h1>Chang Yong Song</h1>
  <!--state-->
  <p>state: {{ store.count }}</p>

  <!--getters-->
  <p>getters: {{ store.doubleCount }}</p>

  <!--actions -->
  <button @click="store.increment">가버렷</button>
</template>

<style scoped></style>
