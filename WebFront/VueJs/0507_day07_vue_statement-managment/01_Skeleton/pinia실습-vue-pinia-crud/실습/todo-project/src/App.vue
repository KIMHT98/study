<script setup>
import TodoList from "@/components/TodoList.vue";
import TodoFrom from "@/components/TodoForm.vue";
import { useCounterStore } from "@/stores/counter";

const store = useCounterStore();
</script>

<template>
  <h1>ToDo</h1>
  <h2>완료된 Todo: {{ store.doneTodosCount }}</h2>
  <TodoList />
  <TodoFrom />
</template>

<style scoped></style>
