<template>
  <div>
    <h1>UserView입니다.</h1>

    <h3>{{ userId }}번 User페이지</h3>
    <button @click="goHome">홈으로</button>
    <button @click="banKok">방콕</button>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useRoute, useRouter } from "vue-router";

const route = useRoute();
const userId = ref(route.params.id);
const router = useRouter();
const goHome = () => {
  router.push({ name: "home" });
};
const banKok = () => {
  router.replace({ name: "home" });
};
</script>

<style scoped></style>
