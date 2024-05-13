<template>
  <div>
    <!-- <h1>Todo리스트아이템</h1> -->
    <p
      @click="store.updateTodo(myTodo.id)"
      :class="{ 'is-done': myTodo.isDone }"
    >
      {{ myTodo }}
    </p>
    <button @click="store.deleteTodo(myTodo.id)">삭제</button>
  </div>
</template>

<script setup>
import { useCounterStore } from "@/stores/counter";
defineProps({
  myTodo: Object,
});
const store = useCounterStore();
</script>

<style scoped>
.is-done {
  text-decoration: line-through;
}
</style>
