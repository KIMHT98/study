<template>
  <div>
    <h1>Todo리스트</h1>
    <TodoListItem v-for="todo in store.todos" :key="todo.id" :my-todo="todo" />
  </div>
</template>

<script setup>
import { useCounterStore } from "@/stores/counter";
import TodoListItem from "@/components/TodoListItem.vue";

const store = useCounterStore();
</script>

<style scoped></style>
